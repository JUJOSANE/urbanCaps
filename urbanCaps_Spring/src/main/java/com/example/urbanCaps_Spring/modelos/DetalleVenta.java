package com.example.urbanCaps_Spring.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "precioUnitario", nullable = false)
    private Double precioUnitario;
    @Column(name = "subTotal", nullable = false)
    private Double subTotal;

    //RELACION CON VENTA (M)
    @ManyToOne
    @JoinColumn(name = "fk_venta",referencedColumnName = "id")
    @JsonBackReference(value = "relacionventadetalleventa")
    private Venta venta;

    //RELACION CON DETALLEVENTA(M)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_productoBase", referencedColumnName = "id")
    @JsonBackReference(value = "relacionproductodetalle")
    private ProductoBase productoBase;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer id, Integer cantidad,
                        Double precioUnitario, Double subTotal, Venta venta, ProductoBase productoBase) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.venta = venta;
        this.productoBase = productoBase;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
    public Double getPrecioUnitario() {return precioUnitario;}
    public void setPrecioUnitario(Double precioUnitario) {this.precioUnitario = precioUnitario;}
    public Double getSubTotal() {return subTotal;}
    public void setSubTotal(Double subTotal) {this.subTotal = subTotal;}
    public Venta getVenta() {return venta;}
    public void setVenta(Venta venta) {this.venta = venta;}
    public ProductoBase getProductoBase() {return productoBase;}
    public void setProductoBase(ProductoBase productoBase) {this.productoBase = productoBase;}
}
