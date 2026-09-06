package com.Pagina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pagina.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Esto es necesario para que findByEmail funcione
    Optional<Usuario> findByEmail(String email);
}
