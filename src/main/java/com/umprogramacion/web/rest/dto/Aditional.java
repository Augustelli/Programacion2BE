package com.umprogramacion.web.rest.dto;

public class Aditional {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Float precioGratis;

    public Aditional(Integer id, String nombre, String descripcion, Float precio, Float precioGratis) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioGratis = precioGratis;
    }

    public Aditional() {}

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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getPrecioGratis() {
        return precioGratis;
    }

    public void setPrecioGratis(Float precioGratis) {
        this.precioGratis = precioGratis;
    }
}
