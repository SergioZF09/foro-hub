package com.aluracursos.forohub.domain;

public class ValidacionExcepcion extends RuntimeException{

    public ValidacionExcepcion(String mensaje) {
        super(mensaje);
    }

}
