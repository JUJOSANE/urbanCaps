package com.example.urbanCaps_Spring.modelos;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(name = "nombre" ,length = 50, unique = false, nullable = false)
        private String nombre;
        @Column(name = "apellido", length = 50, unique = false, nullable = false)
        private String apellido;
        @Column(name = "telefono", length = 11, unique = false, nullable = false)
        private Integer telefono;
        @Column(name = "correo", length = 100, unique = true, nullable = false)
        private String correo;
        @Column(name = "cedula", unique = true, nullable = false)
        private Integer cedula;
        @Column(name = "direccion", length = 100, nullable = false)
        private String direccion;

        //RELACION CON CIUDAD(M)
        @ManyToOne
        @JoinColumn(name = "fk_ciudad", referencedColumnName = "id")
        @JsonBackReference( value = "relacionciudadcliente")
        private Ciudad ciudad;

        //RELACION CON VENTA(1)
        @OneToMany(mappedBy = "cliente")
        @JsonManagedReference(value = "relacionclienteventa")
        private List<Venta> ventas = new ArrayList<>();

        public Cliente() {
        }

        public Cliente(Integer id, String nombre, String apellido,
                       Integer telefono, String correo, Integer cedula,
                       String direccion, Ciudad ciudad, List<Venta> ventas) {
                this.id = id;
                this.nombre = nombre;
                this.apellido = apellido;
                this.telefono = telefono;
                this.correo = correo;
                this.cedula = cedula;
                this.direccion = direccion;
                this.ciudad = ciudad;
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
        public String getDireccion() {return direccion;}
        public void setDireccion(String direccion) {this.direccion = direccion;}
        public Ciudad getCiudad() {return ciudad;}
        public void setCiudad(Ciudad ciudad) {this.ciudad = ciudad;}
        public List<Venta> getVentas() {return ventas;}
        public void setVentas(List<Venta> ventas) {this.ventas = ventas;}
}
