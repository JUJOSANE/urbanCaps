package com.example.urbanCaps_Spring.modelos.dtos;

public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String correo;
    private Integer cedula;
    private String direccion;

    private Integer ciudadId;

    public ClienteDTO() {}

    public ClienteDTO(Integer id, String nombre,
                      String apellido, Integer telefono, String correo,
                      Integer cedula, String direccion, Integer ciudadId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
        this.direccion = direccion;
        this.ciudadId = ciudadId;
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
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public Integer getCiudadId() {return ciudadId;}
    public void setCiudadId(Integer ciudadId) {this.ciudadId = ciudadId;
    }
}
