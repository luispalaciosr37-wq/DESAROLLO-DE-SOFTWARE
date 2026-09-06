package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.EstadoPedido;
import com.Pagina.repository.EstadoPedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoPedidoService {

    private final EstadoPedidoRepository repository;

    public List<EstadoPedido> listar() { return repository.findAll(); }

    public EstadoPedido guardar(EstadoPedido e) { return repository.save(e); }

    public EstadoPedido obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de pedido no encontrado"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
