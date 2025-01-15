package com.aluracursos.forohub.domain.topico.dto;

import com.aluracursos.forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autor,
        String curso

    ) {

    public DatosRespuestaTopico(Topico topico) {

        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getEstado(), topico.getAutor(), topico.getCurso());

    }

}
