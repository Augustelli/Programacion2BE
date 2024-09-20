package com.umprogramacion.web.rest.dto.response;

import com.umprogramacion.web.rest.dto.Aditional;
import com.umprogramacion.web.rest.dto.Characteristics;
import com.umprogramacion.web.rest.dto.Personalization;
import java.util.List;

public class Device {

    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Float precioBase;
    private String moneda;
    private List<Characteristics> caracteristicas;
    private List<Personalization> personalizaciones;
    private List<Aditional> adicionales;

    public Device(
        Integer id,
        String codigo,
        String nombre,
        String descripcion,
        Float precioBase,
        String moneda,
        List<Characteristics> caracteristicas,
        List<Personalization> personalizaciones,
        List<Aditional> adicionales
    ) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.moneda = moneda;
        this.caracteristicas = caracteristicas;
        this.personalizaciones = personalizaciones;
        this.adicionales = adicionales;
    }

    public Device() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Float precioBase) {
        this.precioBase = precioBase;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public List<Characteristics> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Characteristics> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<Personalization> getPersonalizaciones() {
        return personalizaciones;
    }

    public void setPersonalizaciones(List<Personalization> personalizaciones) {
        this.personalizaciones = personalizaciones;
    }

    public List<Aditional> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(List<Aditional> adicionales) {
        this.adicionales = adicionales;
    }
}
