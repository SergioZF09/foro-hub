package com.aluracursos.forohub.domain.topico.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Future
        LocalDateTime fechaCreacion,
        @NotBlank
        String estado,
        @NotBlank
        String autor,
        @NotBlank
        String curso

    ) {
}
