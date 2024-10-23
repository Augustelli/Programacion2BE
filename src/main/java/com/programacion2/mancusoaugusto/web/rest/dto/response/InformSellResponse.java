package com.programacion2.mancusoaugusto.web.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InformSellResponse {

    @JsonProperty("idVenta")
    private Integer idVenta;

    public InformSellResponse() {
    }

    public InformSellResponse(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
}
