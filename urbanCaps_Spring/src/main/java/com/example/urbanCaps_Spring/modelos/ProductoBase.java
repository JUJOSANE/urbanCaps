package com.example.urbanCaps_Spring.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table(name = "productoBase")
public class ProductoBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombreProdu", length = 50, nullable = false)
    private String nombreProdu;
    @Column(name = "marca", length = 50, nullable = false)
    private String marca;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Column(name = "precio", precision = 10, scale = 2,nullable = false)
    private BigDecimal precio;

    //RELACION CON DETALLEVENTA (1)
    @OneToMany(mappedBy = "productoBase")
    @JsonManagedReference(value = "relacionproductodetalle")
    private ArrayList<DetalleVenta> detalleVentas;

    public ProductoBase() {
    }

    public ProductoBase(Integer id, String nombreProdu,
                        String marca, Integer stock, BigDecimal precio,
                        ArrayList<DetalleVenta> detalleVentas) {
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
    public Integer getStock() {return stock;}
    public void setStock(Integer stock) {this.stock = stock;}
    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}
    public ArrayList<DetalleVenta> getDetalleVentas() {return detalleVentas;}
    public void setDetalleVentas(ArrayList<DetalleVenta> detalleVentas) {this.detalleVentas = detalleVentas;}
}
