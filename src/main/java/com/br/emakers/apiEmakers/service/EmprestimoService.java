package com.br.emakers.apiEmakers.service;

import com.br.emakers.apiEmakers.data.entity.Emprestimo;
import com.br.emakers.apiEmakers.data.entity.Livro;
import com.br.emakers.apiEmakers.data.entity.Pessoa;
import com.br.emakers.apiEmakers.repository.EmprestimoRepository;
import com.br.emakers.apiEmakers.repository.LivroRepository;
import com.br.emakers.apiEmakers.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             LivroRepository livroRepository,
                             PessoaRepository pessoaRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.pessoaRepository = pessoaRepository;
    }

    // Criar um empréstimo
    public Emprestimo criarEmprestimo(Long idLivro, Long idPessoa) {
        Livro livro = livroRepository.findById(idLivro).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setPessoa(pessoa);

        return emprestimoRepository.save(emprestimo);
    }

    // Buscar por ID
    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Empréstimo não encontrado"));
    }

    // Deletar um empréstimo
    public void devolverEmprestimo(Long id) {
        if (!emprestimoRepository.existsById(id)) {
            throw new EntityNotFoundException("Empréstimo não encontrado");
        }
        emprestimoRepository.deleteById(id);
    }
}
