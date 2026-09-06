package mx.edu.um.editortextosaas.controller;

import mx.edu.um.editortextosaas.model.Documento;
import mx.edu.um.editortextosaas.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @GetMapping
    public List<Documento> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Documento obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));
    }

    @PostMapping
    public Documento crear(@RequestBody Documento doc) {
        if (doc.getTitulo() == null || doc.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        return service.crear(doc);
    }

    @PutMapping("/{id}")
    public Documento actualizar(@PathVariable Long id, @RequestBody Documento doc) {
        return service.actualizar(id, doc);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
