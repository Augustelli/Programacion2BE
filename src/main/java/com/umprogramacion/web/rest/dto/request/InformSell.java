package com.umprogramacion.web.rest.dto.request;

import com.umprogramacion.web.rest.dto.ItemSold;
import java.util.List;

public class InformSell {

    private Integer idDispositivo;
    private List<ItemSold> personalizaciones;
    private List<ItemSold> adicionales;
    private Float precioFinal;
    private String fechaVenta;

    public InformSell(
        Integer idDispositivo,
        List<ItemSold> personalizaciones,
        List<ItemSold> adicionales,
        Float precioFinal,
        String fechaVenta
    ) {
        this.idDispositivo = idDispositivo;
        this.personalizaciones = personalizaciones;
        this.adicionales = adicionales;
        this.precioFinal = precioFinal;
        this.fechaVenta = fechaVenta;
    }

    public InformSell() {}

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public List<ItemSold> getPersonalizaciones() {
        return personalizaciones;
    }

    public void setPersonalizaciones(List<ItemSold> personalizaciones) {
        this.personalizaciones = personalizaciones;
    }

    public List<ItemSold> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(List<ItemSold> adicionales) {
        this.adicionales = adicionales;
    }

    public Float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
