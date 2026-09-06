package mx.edu.um.editortextosaas.service;

import mx.edu.um.editortextosaas.model.Documento;
import mx.edu.um.editortextosaas.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    public List<Documento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Documento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Documento crear(Documento doc) {
        doc.setFechaCreacion(LocalDateTime.now());
        doc.setFechaModificacion(LocalDateTime.now());
        return repository.save(doc);
    }

    public Documento actualizar(Long id, Documento datos) {
        Documento doc = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));
        doc.setTitulo(datos.getTitulo());
        doc.setContenido(datos.getContenido());
        doc.setFechaModificacion(LocalDateTime.now());
        return repository.save(doc);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
