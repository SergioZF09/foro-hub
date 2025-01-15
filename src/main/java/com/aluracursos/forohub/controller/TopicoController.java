package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.ValidacionExcepcion;
import com.aluracursos.forohub.domain.topico.dto.DatosActualizarTopico;
import com.aluracursos.forohub.domain.topico.dto.DatosListadoTopico;
import com.aluracursos.forohub.domain.topico.dto.DatosRegistroTopico;
import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import com.aluracursos.forohub.domain.topico.validaciones.ValidadorSiExisteTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private ValidadorSiExisteTopico validadorSiExisteTopico;

    //Registra un tópico
    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    //Muestra todos los tópico
    @GetMapping
    public List<DatosListadoTopico> listarTopicos() {
        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }

    //Muestra un tópico en específico
    @GetMapping("/{id}")
    public List<DatosListadoTopico> listarUnTopico(@PathVariable Long id) {
        validadorSiExisteTopico.validarTopico(id);

        return topicoRepository.findById(id).stream().map(DatosListadoTopico::new).toList();
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        validadorSiExisteTopico.validarTopico(datosActualizarTopico.id());

        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        validadorSiExisteTopico.validarTopico(id);

        topicoRepository.deleteById(id);
    }

}
