package com.example.urbanCaps_Spring.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_ciudad", length = 50, nullable = false)
    private String nombreCiudad;

    //RELACION CON CIUDAD (1)
    @OneToMany(mappedBy = "ciudad")
    @JsonManagedReference(value = "relacionciudadcliente")
    private List<Cliente> clientes = new ArrayList<>();


    public Ciudad() {
    }

    public Ciudad(Integer id, String nombreCiudad, List<Cliente> clientes) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
        this.clientes = clientes;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombreCiudad() {return nombreCiudad;}
    public void setNombreCiudad(String nombreCiudad) {this.nombreCiudad = nombreCiudad;}
    public List<Cliente> getClientes() {return clientes;}
    public void setClientes(List<Cliente> clientes) {this.clientes = clientes;}
}
