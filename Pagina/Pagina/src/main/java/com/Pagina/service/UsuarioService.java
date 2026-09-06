package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.Usuario;
import com.Pagina.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<Usuario> listar() { return repository.findAll(); }

    public Usuario guardar(Usuario u) { return repository.save(u); }

    public Usuario obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }

    public Usuario obtenerPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
