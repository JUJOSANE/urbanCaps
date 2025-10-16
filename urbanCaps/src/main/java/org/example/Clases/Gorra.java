package org.example.Clases;

import java.math.BigDecimal;
import java.util.List;

public class Gorra extends ProductoBase{
    private String tipoVicera;
    private String color;

    public Gorra() {
    }

    public Gorra(Integer id, String nombreProdu, String marca, Integer stock,
                 BigDecimal precio, List<DetalleVenta> detalleVentas, String tipoVicera, String color) {
        super(id, nombreProdu, marca, stock, precio, detalleVentas);
        this.tipoVicera = tipoVicera;
    }

    public String getTipoVicera() {return tipoVicera;}
    public void setTipoVicera(String tipoVicera) {this.tipoVicera = tipoVicera;}
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
