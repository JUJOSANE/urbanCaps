package com.example.urbanCaps_Spring.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_ciudad",length = 50, nullable = false)
    private String nombre_ciudad;

    //RELACION CON CIUDAD (1)
    @OneToMany(mappedBy = "ciudad")
    @JsonManagedReference(value = "relacionciudadcliente")
    private ArrayList<Cliente> clientes;



    public Ciudad() {
    }

    public Ciudad(Integer id, String nombre_ciudad, ArrayList<Cliente> clientes) {
        this.id = id;
        this.nombre_ciudad = nombre_ciudad;
        this.clientes = clientes;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombre_ciudad() {return nombre_ciudad;}
    public void setNombre_ciudad(String nombre_ciudad) {this.nombre_ciudad = nombre_ciudad;}
    public ArrayList<Cliente> getClientes() {return clientes;}
    public void setClientes(ArrayList<Cliente> clientes) {this.clientes = clientes;}
}
