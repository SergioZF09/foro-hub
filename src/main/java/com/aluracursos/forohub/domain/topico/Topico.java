package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.domain.topico.dto.DatosActualizarTopico;
import com.aluracursos.forohub.domain.topico.dto.DatosRegistroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String estado;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {

        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.estado = datosRegistroTopico.estado();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();

    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }

        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.fechaCreacion() != null) {
            this.fechaCreacion = datosActualizarTopico.fechaCreacion();
        }

        if (datosActualizarTopico.estado() != null) {
            this.estado = datosActualizarTopico.estado();
        }

        if (datosActualizarTopico.autor() != null) {
            this.autor = datosActualizarTopico.autor();
        }

        if (datosActualizarTopico.curso() != null) {
            this.curso = datosActualizarTopico.curso();
        }

    }

}
