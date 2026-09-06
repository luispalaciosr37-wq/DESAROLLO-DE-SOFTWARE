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

import com.Pagina.model.Pedido;
import com.Pagina.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PedidoController {

    private final PedidoService service;

    @GetMapping
    public List<Pedido> listar() { return service.listar(); }

    @PostMapping
    public Pedido guardar(@RequestBody Pedido p) { return service.guardar(p); }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Long id) { return service.obtener(id); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
