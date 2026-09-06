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

import com.Pagina.model.EstadoPedido;
import com.Pagina.service.EstadoPedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/estados-pedido")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EstadoPedidoController {

    private final EstadoPedidoService service;

    @GetMapping
    public List<EstadoPedido> listar() { return service.listar(); }

    @PostMapping
    public EstadoPedido guardar(@RequestBody EstadoPedido e) { return service.guardar(e); }

    @GetMapping("/{id}")
    public EstadoPedido obtener(@PathVariable Long id) { return service.obtener(id); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
