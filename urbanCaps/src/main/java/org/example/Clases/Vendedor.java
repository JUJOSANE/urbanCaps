package org.example.Clases;

import java.util.List;

public class Vendedor {
        private Integer id;
        private String nombre;
        private String apellido;
        private Integer telefono;
        private Integer cedula;

        //La relacion es 1 a Muchos en este caso el UNO esta en vendedor pero recibe UnaLista
    //Seria UNA VENTA TIENE UN VENDEDOR(RECIBE UN DATO), Y VENDEDOR TIENE MUCHAS VENTAS(RECIBE MUCHOOOS DATOS UNA LISTA )
        private List<Venta> ventas;

    public Vendedor() {
    }

    public Vendedor(Integer id, String nombre, String apellido, Integer telefono, Integer cedula, List<Venta> ventas) {
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
