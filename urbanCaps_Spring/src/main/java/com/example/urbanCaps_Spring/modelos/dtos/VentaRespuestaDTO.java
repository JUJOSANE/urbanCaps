package com.example.urbanCaps_Spring.modelos.dtos;

public class VentaRespuestaDTO {
    private Integer id;
    private Double totalGlobal;

    public VentaRespuestaDTO() {
    }

    public VentaRespuestaDTO(Integer id, Double totalGlobal) {
        this.id = id;
        this.totalGlobal = totalGlobal;
    }
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Double getTotalGlobal() {return totalGlobal;}
    public void setTotalGlobal(Double totalGlobal) {this.totalGlobal = totalGlobal;}
}
