package com.example.urbanCaps_Spring.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;
    @Column(name = "telefono", nullable = false)
    private Integer telefono;
    @Column(name = "cedula", nullable = false, unique = true)
    private Integer cedula;

    //RELACION CON VENTA (1)
    @OneToMany( mappedBy = "vendedor")
    @JsonManagedReference(value = "relacionvendedorventa")
    private List<Venta> ventas;

    public Vendedor() {
    }

    public Vendedor(Integer id, String nombre, String apellido,
                    Integer telefono, Integer cedula, List<Venta> ventas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cedula = cedula;
        this.ventas = ventas;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public Integer getTelefono() {return telefono;}
    public void setTelefono(Integer telefono) {this.telefono = telefono;}
    public Integer getCedula() {return cedula;}
    public void setCedula(Integer cedula) {this.cedula = cedula;}
    public List<Venta> getVentas() {return ventas;}
    public void setVentas(List<Venta> ventas) {this.ventas = ventas;}
}
