package org.example.Clases;

import java.time.LocalDate;
import java.util.List;

public class Venta {
    private Integer id;
    private LocalDate fecha;
    private Integer totalVenta;

    //Relacion de muchos a 1(Aca el Muchos es VENTA y el  Uno  es Cliente y vendedor)
    private Cliente cliente;
    private Vendedor vendedor;

    //Relacion de Uno a MUCHOS(El 1 RECIBE SIEMPRE UNA LISTA)
    private List<DetalleVenta> detalleVentas;

    public Venta() {
    }

    public Venta(Integer id, LocalDate fecha, Integer totalVenta, Cliente cliente, Vendedor vendedor, List<DetalleVenta> detalleVentas) {
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
    public List<DetalleVenta> getDetalleVentas() {return detalleVentas;}
    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {this.detalleVentas = detalleVentas;}
}
