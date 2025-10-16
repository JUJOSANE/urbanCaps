package org.example.Clases;

public class DetalleVenta {
    private Integer id;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subTotal;

    //Relacion de Muchos a 1(Este es el lado de muchos entonces recibe SOLO UN PRODUCTO)
    private ProductoBase producto;
    private Venta venta;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer id, Integer cantidad, Double precioUnitario, Double subTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
    public Double getPrecioUnitario() {return precioUnitario;}
    public void setPrecioUnitario(Double precioUnitario) {this.precioUnitario = precioUnitario;}
    public Double getSubTotal() {return subTotal;}
    public void setSubTotal(Double subTotal) {this.subTotal = subTotal;}
}
