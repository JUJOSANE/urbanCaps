package com.example.urbanCaps_Spring.modelos.dtos;

public class CiudadDTO {
    private Integer id;
    private String nombreCiudad;

    public CiudadDTO() {
    }

    public CiudadDTO(Integer id, String nombreCiudad) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombreCiudad() {return nombreCiudad;}
    public void setNombreCiudad(String nombreCiudad) {this.nombreCiudad = nombreCiudad;}
}
