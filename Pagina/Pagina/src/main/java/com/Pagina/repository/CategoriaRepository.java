package com.Pagina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pagina.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
