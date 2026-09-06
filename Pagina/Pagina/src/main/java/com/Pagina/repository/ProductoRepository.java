package com.Pagina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pagina.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
