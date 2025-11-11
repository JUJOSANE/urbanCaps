package com.example.urbanCaps_Spring.modelos.dtos;

import java.time.LocalDate;
import java.util.List;

public class VentaDetalleDTO {
    private Integer id;
    private LocalDate fecha;
    private Double totalVenta;
    private String nombreCliente;
    private String nombreVendedor;
    private List<DetalleVentaRespuestaDTO> detalles;

    public VentaDetalleDTO() {
    }

    public VentaDetalleDTO(Integer id, LocalDate fecha, Double totalVenta,
                           String nombreCliente, String nombreVendedor, List<DetalleVentaRespuestaDTO> detalles) {
        this.id = id;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.nombreCliente = nombreCliente;
        this.nombreVendedor = nombreVendedor;
        this.detalles = detalles;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public Double getTotalVenta() {return totalVenta;}
    public void setTotalVenta(Double totalVenta) {this.totalVenta = totalVenta;}
    public String getNombreCliente() {return nombreCliente;}
    public void setNombreCliente(String nombreCliente) {this.nombreCliente = nombreCliente;}
    public String getNombreVendedor() {return nombreVendedor;}
    public void setNombreVendedor(String nombreVendedor) {this.nombreVendedor = nombreVendedor;}
    public List<DetalleVentaRespuestaDTO> getDetalles() {return detalles;}
    public void setDetalles(List<DetalleVentaRespuestaDTO> detalles) {this.detalles = detalles;

    }
}
