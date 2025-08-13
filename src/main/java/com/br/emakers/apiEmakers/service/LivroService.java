package com.br.emakers.apiEmakers.service;

import com.br.emakers.apiEmakers.data.dto.request.LivroRequestDTO;
import com.br.emakers.apiEmakers.data.dto.response.LivroResponseDTO;
import com.br.emakers.apiEmakers.data.entity.Livro;
import com.br.emakers.apiEmakers.exceptions.general.EntityNotFoundException;
import com.br.emakers.apiEmakers.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroResponseDTO> getAllLivros(){
        List<Livro> livros = livroRepository.findAll();

        return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    public LivroResponseDTO getLivroById(Long idLivro){
        Livro livro = getLivroEntityBiId(idLivro);

        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO createLivro(LivroRequestDTO livroRequestDTO){
        Livro livro = new Livro(livroRequestDTO);
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO updateLivro(Long idLivro, LivroRequestDTO livroRequestDTO){
        Livro livro = getLivroEntityBiId(idLivro);
        livro.setNome(livroRequestDTO.nome());
        livro.setAutor(livroRequestDTO.autor());
        livro.setDataLancamento(livroRequestDTO.dataLancamento());
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    public String deleteLivro(Long idLivro){
        Livro livro = getLivroEntityBiId(idLivro);
        livroRepository.delete(livro);

        return "Livro deletado com sucesso!";
    }

    private Livro getLivroEntityBiId(Long idLivro){
        return livroRepository.findById(idLivro).orElseThrow(()-> new EntityNotFoundException(idLivro));
    }
}
