package com.example.urbanCaps_Spring.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "totalVenta", nullable = false)
    private Integer totalVenta;

    //RELACION CON CLIENTE (M)
    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id")
    @JsonBackReference(value = "relacionclienteventa")
    private Cliente cliente;

    //RELACION CON VENDEDOR (M)
    @ManyToOne
    @JoinColumn(name = "fk_vendedor", referencedColumnName = "id")
    @JsonBackReference(value = "relacionvendedorventa")
    private Vendedor vendedor;

    //RELCION CON DETALLEVENTA(1)
    @OneToMany(mappedBy = "venta")
    @JsonManagedReference(value = "relacionventadetalleventa")
    private ArrayList<DetalleVenta> detalleVentas;

    public Venta() {}

    public Venta(Integer id, LocalDate fecha, Integer totalVenta, Cliente cliente, Vendedor vendedor,ArrayList<DetalleVenta> detalleVentas) {
        this.id = id;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.detalleVentas = detalleVentas;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public Integer getTotalVenta() {return totalVenta;}
    public void setTotalVenta(Integer totalVenta) {this.totalVenta = totalVenta;}
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
    public Vendedor getVendedor() {return vendedor;}
    public void setVendedor(Vendedor vendedor) {this.vendedor = vendedor;}
}
