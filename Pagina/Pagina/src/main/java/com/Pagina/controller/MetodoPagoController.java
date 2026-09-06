package com.Pagina.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Pagina.model.MetodoPago;
import com.Pagina.service.MetodoPagoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/metodos-pago")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MetodoPagoController {

    private final MetodoPagoService service;

    @GetMapping
    public List<MetodoPago> listar() { return service.listar(); }

    @PostMapping
    public MetodoPago guardar(@RequestBody MetodoPago m) { return service.guardar(m); }

    @GetMapping("/{id}")
    public MetodoPago obtener(@PathVariable Long id) { return service.obtener(id); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
