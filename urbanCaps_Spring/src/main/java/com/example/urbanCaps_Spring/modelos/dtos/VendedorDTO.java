package com.example.urbanCaps_Spring.modelos.dtos;

public class VendedorDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private Integer cedula;


    public VendedorDTO() {
    }

    public VendedorDTO(Integer id, String nombre, String apellido, Integer telefono, Integer cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cedula = cedula;
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
}
