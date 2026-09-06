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

import com.Pagina.model.DetallePedido;
import com.Pagina.service.DetallePedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/detalle-pedido")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DetallePedidoController {

    private final DetallePedidoService service;

    @GetMapping
    public List<DetallePedido> listar() { return service.listar(); }

    @PostMapping
    public DetallePedido guardar(@RequestBody DetallePedido d) { return service.guardar(d); }

    @GetMapping("/{id}")
    public DetallePedido obtener(@PathVariable Long id) { return service.obtener(id); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
