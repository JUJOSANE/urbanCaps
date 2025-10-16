package org.example.Clases;

import java.math.BigDecimal;
import java.util.List;

public class Tenni extends ProductoBase{
    private Double talla;
    private String color;

    public Tenni() {
    }

    public Tenni(Integer id, String nombreProdu, String marca,
                 Integer stock, BigDecimal precio, List<DetalleVenta> detalleVentas, Double talla, String color) {
        super(id, nombreProdu, marca, stock, precio, detalleVentas);
        this.talla = talla;
        this.color = color;
    }

    public Double getTalla() {return talla;}
    public void setTalla(Double talla) {this.talla = talla;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    @Override
    public BigDecimal calcularPrecioTotal(){
        return this.getPrecio().add(this.calcularImpuesto());
    }
    @Override
    public BigDecimal calcularImpuesto(){
        return this.getPrecio().multiply(new BigDecimal("0.19"));
    }
}
