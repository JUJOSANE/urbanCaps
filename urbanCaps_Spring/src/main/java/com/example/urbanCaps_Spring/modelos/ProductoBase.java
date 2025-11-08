package com.example.urbanCaps_Spring.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "precio",nullable = false)
    private Double precio;

    //RELACION CON DETALLEVENTA (1)
    @OneToMany(mappedBy = "productoBase")
    @JsonIgnore
    //@JsonManagedReference(value = "relacionproductodetalle")
    private List<DetalleVenta> detalleVentas = new ArrayList<>();

    public ProductoBase() {
    }

    public ProductoBase(Integer id, String nombreProdu,
                        String marca, Integer stock, Double precio,
                        List<DetalleVenta> detalleVentas) {
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
    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}
    public List<DetalleVenta> getDetalleVentas() {return detalleVentas;}
    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {this.detalleVentas = detalleVentas;}
}
