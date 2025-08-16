package com.br.emakers.apiEmakers.controller;

import com.br.emakers.apiEmakers.data.dto.request.EmprestimoRequestDTO;
import com.br.emakers.apiEmakers.data.entity.Emprestimo;
import com.br.emakers.apiEmakers.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping(value = "/create")
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody @Valid EmprestimoRequestDTO emprestimoRequestDTO){
        Emprestimo emprestimo = emprestimoService.criarEmprestimo(emprestimoRequestDTO.idLivro(), emprestimoRequestDTO.idPessoa());
        return ResponseEntity.status(HttpStatus.OK).body(emprestimo);
    }

    @GetMapping(value = "/{idEmprestimo}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Long idEmprestimo) {
        return ResponseEntity.ok(emprestimoService.buscarPorId(idEmprestimo));
    }

    @DeleteMapping(value = "/delete/{idEmprestimo}")
    public ResponseEntity<Void> devolverEmprestimo(@PathVariable Long idEmprestimo) {
        emprestimoService.devolverEmprestimo(idEmprestimo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Emprestimo>> getAllEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoService.getAllEmprestimos();
        return ResponseEntity.ok(emprestimos);
    }
}
