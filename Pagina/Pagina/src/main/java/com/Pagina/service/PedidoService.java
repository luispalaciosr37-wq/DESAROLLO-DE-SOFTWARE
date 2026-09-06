package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.Pedido;
import com.Pagina.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    public List<Pedido> listar() { return repository.findAll(); }

    public Pedido guardar(Pedido p) { return repository.save(p); }

    public Pedido obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
