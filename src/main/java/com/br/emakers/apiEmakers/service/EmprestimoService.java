package com.br.emakers.apiEmakers.service;

import com.br.emakers.apiEmakers.data.entity.Emprestimo;
import com.br.emakers.apiEmakers.data.entity.Livro;
import com.br.emakers.apiEmakers.data.entity.Pessoa;
import com.br.emakers.apiEmakers.exceptions.general.EmprestimoNotFoundException;
import com.br.emakers.apiEmakers.exceptions.general.LivroNotFoundException;
import com.br.emakers.apiEmakers.exceptions.general.PessoaNotFoundException;
import com.br.emakers.apiEmakers.repository.EmprestimoRepository;
import com.br.emakers.apiEmakers.repository.LivroRepository;
import com.br.emakers.apiEmakers.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Emprestimo criarEmprestimo(Long idLivro, Long idPessoa) {
        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new LivroNotFoundException(idLivro));

        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new PessoaNotFoundException(idPessoa));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setPessoa(pessoa);

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new EmprestimoNotFoundException(id));
    }

    public List<Emprestimo> getAllEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public void devolverEmprestimo(Long id) {
        if (!emprestimoRepository.existsById(id)) {
            throw new EmprestimoNotFoundException(id);
        }
        emprestimoRepository.deleteById(id);
    }
}
