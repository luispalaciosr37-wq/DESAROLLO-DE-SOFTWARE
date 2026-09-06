package com.Pagina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pagina.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
