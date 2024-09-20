package com.umprogramacion.web.rest.dto;

public class ItemSold {

    private Integer id;
    private Float precio;

    public ItemSold(Integer id, Float precio) {
        this.id = id;
        this.precio = precio;
    }

    public ItemSold() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
