package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.Rol;
import com.Pagina.repository.RolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository repository;

    public List<Rol> listar() { return repository.findAll(); }

    public Rol guardar(Rol r) { return repository.save(r); }

    public Rol obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
