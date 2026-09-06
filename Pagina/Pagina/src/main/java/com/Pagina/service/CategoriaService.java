package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.Categoria;
import com.Pagina.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria guardar(Categoria c) {
        return repository.save(c);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
