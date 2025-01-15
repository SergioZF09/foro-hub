package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.ValidacionExcepcion;
import com.aluracursos.forohub.domain.topico.dto.DatosActualizarTopico;
import com.aluracursos.forohub.domain.topico.dto.DatosListadoTopico;
import com.aluracursos.forohub.domain.topico.dto.DatosRegistroTopico;
import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import com.aluracursos.forohub.domain.topico.dto.DatosRespuestaTopico;
import com.aluracursos.forohub.domain.topico.validaciones.ValidadorSiExisteTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                          UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaTopico);
    }

    //Muestra todos los tópicos
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 5)Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    //Muestra un tópico en específico usando el id
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> listarUnTopico(@PathVariable Long id) {
        //validadorSiExisteTopico.validarTopico(id);

        Topico topico = topicoRepository.getReferenceById(id);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico);
        return ResponseEntity.ok(datosRespuestaTopico);
    }

    //Actualiza un tópico en específico usando el id
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        //validadorSiExisteTopico.validarTopico(datosActualizarTopico.id());

        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    //Elimina un tópico en específico usando el id
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        //validadorSiExisteTopico.validarTopico(id);

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
