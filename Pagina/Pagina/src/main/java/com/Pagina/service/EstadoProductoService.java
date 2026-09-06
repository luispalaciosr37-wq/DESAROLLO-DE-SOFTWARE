package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.EstadoProducto;
import com.Pagina.repository.EstadoProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoProductoService {

    private final EstadoProductoRepository repository;

    public List<EstadoProducto> listar() { return repository.findAll(); }

    public EstadoProducto guardar(EstadoProducto e) { return repository.save(e); }

    public EstadoProducto obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de producto no encontrado"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
