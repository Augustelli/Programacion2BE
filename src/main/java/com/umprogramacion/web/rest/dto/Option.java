package com.umprogramacion.web.rest.dto;

public class Option {

    private Integer id;
    private String nombre;
    private String codigo;
    private String descripcion;
    private Float precioAdicional;

    public Option(Integer id, String nombre, String codigo, String descripcion, Float precioAdicional) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioAdicional = precioAdicional;
    }

    public Option() {}

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecioAdicional() {
        return precioAdicional;
    }

    public void setPrecioAdicional(Float precioAdicional) {
        this.precioAdicional = precioAdicional;
    }
}
