package org.example.Clases;

import java.math.BigDecimal;
import java.util.List;

public abstract class ProductoBase {

    private Integer id;
    private String nombreProdu;
    private String marca;
    private Integer stock;
    private BigDecimal precio;

    //Relacion de Uno a MUCHOS (La lista la va recibir el lado del Uno)
    private List<DetalleVenta> detalleVentas;

    public ProductoBase() {}

    public ProductoBase(Integer id, String nombreProdu, String marca, Integer stock,
                        BigDecimal precio, List<DetalleVenta> detalleVentas) {
        this.id = id;
        this.nombreProdu = nombreProdu;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
        this.detalleVentas = detalleVentas;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombreProdu() {return nombreProdu;}
    public void setNombreProdu(String nombreProdu) {this.nombreProdu = nombreProdu;}
    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public Integer getStock(){return stock;}
    public void setStock(Integer stock){this.stock = stock;}
    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}
    public List<DetalleVenta> getDetalleVentas() {return detalleVentas;}
    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {this.detalleVentas = detalleVentas;}

    //Metodos
    public abstract BigDecimal calcularPrecioTotal();

    public abstract BigDecimal calcularImpuesto();
}
