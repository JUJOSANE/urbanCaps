package org.example.Clases;

import org.example.ayudas.Ciudades;

import java.util.List;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String correo;
    private Integer cedula;
    private Ciudades ciudades;
    private String direccion;

    //Relacion de 1 a muchos(DEL LADO DEL 1 RECIBE UNA LISTA)
    private List<Venta> ventas;


    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String apellido, Integer telefono, String correo, Integer cedula,
                   Ciudades ciudades, String direccion, List<Venta> ventas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
        this.ciudades = ciudades;
        this.direccion = direccion;
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
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public Integer getCedula() {return cedula;}
    public void setCedula(Integer cedula) {this.cedula = cedula;}
    public Ciudades getCiudades() {return ciudades;}
    public void setCiudades(Ciudades ciudades) {this.ciudades = ciudades;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public List<Venta> getVentas() {return ventas;}
    public void setVentas(List<Venta> ventas) {this.ventas = ventas;}
}
