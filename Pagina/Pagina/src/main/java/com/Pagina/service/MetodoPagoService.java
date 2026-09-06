package com.Pagina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Pagina.model.MetodoPago;
import com.Pagina.repository.MetodoPagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetodoPagoService {

    private final MetodoPagoRepository repository;

    public List<MetodoPago> listar() { return repository.findAll(); }

    public MetodoPago guardar(MetodoPago m) { return repository.save(m); }

    public MetodoPago obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
