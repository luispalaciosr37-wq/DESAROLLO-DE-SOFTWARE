package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.DetallePedido;
import com.Pagina.repository.DetallePedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetallePedidoService {

    private final DetallePedidoRepository repository;

    public List<DetallePedido> listar() { return repository.findAll(); }

    public DetallePedido guardar(DetallePedido d) { return repository.save(d); }

    public DetallePedido obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
