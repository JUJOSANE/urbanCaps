package com.example.urbanCaps_Spring.modelos.dtos;

public class DetalleVentaRespuestaDTO {
    private Integer id;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subTotal;
    private String nombreProdu;

    public DetalleVentaRespuestaDTO() {
    }

    public DetalleVentaRespuestaDTO(Integer id, Integer cantidad, Double precioUnitario, Double subTotal, String nombreProdu) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.nombreProdu = nombreProdu;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
    public Double getPrecioUnitario() {return precioUnitario;}
    public void setPrecioUnitario(Double precioUnitario) {this.precioUnitario = precioUnitario;}
    public Double getSubTotal() {return subTotal;}
    public void setSubTotal(Double subTotal) {this.subTotal = subTotal;}
    public String getNombreProdu() {return nombreProdu;}
    public void setNombreProdu(String nombreProdu) {this.nombreProdu = nombreProdu;}
}
