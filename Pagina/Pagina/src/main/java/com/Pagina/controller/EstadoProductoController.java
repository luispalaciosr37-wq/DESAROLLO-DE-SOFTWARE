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

import com.Pagina.model.EstadoProducto;
import com.Pagina.service.EstadoProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/estados-producto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EstadoProductoController {

    private final EstadoProductoService service;

    @GetMapping
    public List<EstadoProducto> listar() { return service.listar(); }

    @PostMapping
    public EstadoProducto guardar(@RequestBody EstadoProducto e) { return service.guardar(e); }

    @GetMapping("/{id}")
    public EstadoProducto obtener(@PathVariable Long id) { return service.obtener(id); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
