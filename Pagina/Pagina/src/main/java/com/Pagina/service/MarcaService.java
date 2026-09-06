package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.Marca;
import com.Pagina.repository.MarcaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository repository;

    public List<Marca> listar() { return repository.findAll(); }

    public Marca guardar(Marca m) { return repository.save(m); }

    public Marca obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
