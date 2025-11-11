package com.example.urbanCaps_Spring.modelos.dtos;

import java.util.List;

public class VentaDTO {

    private Integer clienteId;
    private Integer vendedorId;

    private List<DetalleVentaDTO> detalles;

    public VentaDTO() {}

    public VentaDTO(Integer clienteId, Integer vendedorId, List<DetalleVentaDTO> detalles) {

        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.detalles = detalles;
    }


    public Integer getClienteId() {return clienteId;}
    public void setClienteId(Integer clienteId) {this.clienteId = clienteId;}
    public Integer getVendedorId() {return vendedorId;}
    public void setVendedorId(Integer vendedorId) {this.vendedorId = vendedorId;}
    public List<DetalleVentaDTO> getDetalles() {return detalles;}
    public void setDetalles(List<DetalleVentaDTO> detalles) {this.detalles = detalles;}
}
