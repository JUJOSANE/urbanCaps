package com.example.urbanCaps_Spring.modelos.dtos;

public class DetalleVentaDTO {
    private Integer cantidad;
    private Integer productoId;
    private Integer ventaId;

    public DetalleVentaDTO() {
    }

    public DetalleVentaDTO(Integer cantidad, Integer productoId, Integer ventaId) {
        this.cantidad = cantidad;
        this.productoId = productoId;
        this.ventaId = ventaId;
    }

    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
    public Integer getProductoId() {return productoId;}
    public void setProductoId(Integer productoId) {this.productoId = productoId;}
    public Integer getVentaId() {return ventaId;}
    public void setVentaId(Integer ventaId) {this.ventaId = ventaId;}
}
