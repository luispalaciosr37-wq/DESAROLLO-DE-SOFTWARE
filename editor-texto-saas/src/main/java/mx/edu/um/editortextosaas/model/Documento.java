package mx.edu.um.editortextosaas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    private String autor;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Documento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime f) { this.fechaCreacion = f; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime f) { this.fechaModificacion = f; }
}
