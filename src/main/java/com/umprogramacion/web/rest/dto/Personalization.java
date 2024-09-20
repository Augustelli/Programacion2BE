package com.umprogramacion.web.rest.dto;

import java.util.List;

public class Personalization {

    private Integer id;
    private String nombre;
    private String descripcion;
    private List<Option> opciones;

    public Personalization(Integer id, String nombre, String descripcion, List<Option> opciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.opciones = opciones;
    }

    public Personalization() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Option> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Option> opciones) {
        this.opciones = opciones;
    }
}
