package mx.edu.um.editortextosaas.repository;

import mx.edu.um.editortextosaas.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
