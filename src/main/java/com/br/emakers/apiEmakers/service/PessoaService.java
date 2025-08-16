package com.br.emakers.apiEmakers.service;

import com.br.emakers.apiEmakers.data.dto.request.PessoaRequestDTO;
import com.br.emakers.apiEmakers.data.dto.response.PessoaResponseDTO;
import com.br.emakers.apiEmakers.data.dto.response.ViaCepResponseDTO;
import com.br.emakers.apiEmakers.data.entity.Pessoa;
import com.br.emakers.apiEmakers.exceptions.general.PessoaNotFoundException;
import com.br.emakers.apiEmakers.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ViaCepService viaCepService;

    public List<PessoaResponseDTO> getAllPessoas(){
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public PessoaResponseDTO getPessoaById(Long idPessoa){
        Pessoa pessoa = getPessoaEntityBiId(idPessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaRequestDTO){
        Pessoa pessoa = new Pessoa(pessoaRequestDTO);

        ViaCepResponseDTO endereco = viaCepService.buscarEndereco(pessoaRequestDTO.cep());
        if (endereco != null) {
            pessoa.setLogradouro(endereco.logradouro());
            pessoa.setComplemento(endereco.complemento());
            pessoa.setBairro(endereco.bairro());
            pessoa.setLocalidade(endereco.localidade());
            pessoa.setUf(endereco.uf());
        }

        pessoaRepository.save(pessoa);
        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO updatePessoa(Long idPessoa, PessoaRequestDTO pessoaRequestDTO){
        Pessoa pessoa = getPessoaEntityBiId(idPessoa);
        pessoa.setNome(pessoaRequestDTO.nome());
        pessoa.setCpf(pessoaRequestDTO.cpf());
        pessoa.setCep(pessoaRequestDTO.cep());
        pessoa.setEmail(pessoaRequestDTO.email());
        pessoa.setSenha(pessoaRequestDTO.senha());

        ViaCepResponseDTO endereco = viaCepService.buscarEndereco(pessoaRequestDTO.cep());
        if (endereco != null) {
            pessoa.setLogradouro(endereco.logradouro());
            pessoa.setComplemento(endereco.complemento());
            pessoa.setBairro(endereco.bairro());
            pessoa.setLocalidade(endereco.localidade());
            pessoa.setUf(endereco.uf());
        }

        pessoaRepository.save(pessoa);
        return new PessoaResponseDTO(pessoa);
    }

    public String deletePessoa(Long idPessoa){
        Pessoa pessoa = getPessoaEntityBiId(idPessoa);
        pessoaRepository.delete(pessoa);

        return "Pessoa removida com sucesso!";
    }

    private Pessoa getPessoaEntityBiId(Long idPessoa){
        return pessoaRepository.findById(idPessoa).orElseThrow(()-> new PessoaNotFoundException(idPessoa));
    }
}
