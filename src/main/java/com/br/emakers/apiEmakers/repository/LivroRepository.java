package com.br.emakers.apiEmakers.repository;

import com.br.emakers.apiEmakers.data.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {
}
