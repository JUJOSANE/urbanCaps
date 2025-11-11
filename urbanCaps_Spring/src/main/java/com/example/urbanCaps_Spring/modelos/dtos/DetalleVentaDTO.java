package com.example.urbanCaps_Spring.modelos.dtos;

public class DetalleVentaDTO {
    private Integer cantidad;
    private Integer productoId;

    public DetalleVentaDTO() {
    }

    public DetalleVentaDTO(Integer cantidad, Integer productoId) {
        this.cantidad = cantidad;
        this.productoId = productoId;

    }

    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
    public Integer getProductoId() {return productoId;}
    public void setProductoId(Integer productoId) {this.productoId = productoId;}

}
