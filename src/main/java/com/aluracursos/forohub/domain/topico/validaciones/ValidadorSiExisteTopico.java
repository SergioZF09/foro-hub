package com.aluracursos.forohub.domain.topico.validaciones;

import com.aluracursos.forohub.domain.ValidacionExcepcion;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorSiExisteTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validarTopico(Long id) {
        if (topicoRepository.findById(id).isEmpty()) {
            throw new ValidacionExcepcion("No se encontró el tópico por el id introducido");
        }
    }

}
