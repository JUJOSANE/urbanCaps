package com.example.urbanCaps_Spring.modelos.dtos;

public class ProductoBaseDTO {
    private Integer id;
    private String nombreProdu;
    private String marca;
    private Integer stock;
    private Double precio;

    public ProductoBaseDTO() {}

    public ProductoBaseDTO(Integer id, String nombreProdu,
                           String marca, Integer stock, Double precio) {
        this.id = id;
        this.nombreProdu = nombreProdu;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
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
}
