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

import com.Pagina.model.Marca;
import com.Pagina.service.MarcaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MarcaController {

    private final MarcaService service;

    @GetMapping
    public List<Marca> listar() { return service.listar(); }

    @PostMapping
    public Marca guardar(@RequestBody Marca m) { return service.guardar(m); }

    @GetMapping("/{id}")
    public Marca obtener(@PathVariable Long id) { return service.obtener(id); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
