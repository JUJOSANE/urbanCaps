package org.example;

import org.example.Clases.*;
import org.example.servicios.InventarioServicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        InventarioServicio servicio = new InventarioServicio();
        List<DetalleVenta> detallesVacios = Collections.emptyList();

        servicio.agregarProducto(new Camiseta(
                1,
                "Camiseta Clásica",
                "POLO",
                3,
                new BigDecimal("75000"),
                detallesVacios,
                "M",
                "Azul"));

        servicio.agregarProducto(new Gorra(2,
                "Gorra Clasica",
                "HugoBoss",
                1,
                new BigDecimal("35000"),
                detallesVacios,
                "Plana",
                "Negra"));
        servicio.agregarProducto(new Tenni(3,
                "Los 97",
                "Nike",
                2,
                new BigDecimal("150000"),
                detallesVacios,
                39.5,
                "Blanco"));



        //Lamar el metodo de Reporte COmpleto
        //servicio.reporteCompleto();

        //Implementacion de buscar por ID,
        int idABuscar = 2;
        try {
        ProductoBase producto = servicio.busquedaPorId(idABuscar);
            System.out.println("----------------------------------------------");
        System.out.println("Producto con Id: " + idABuscar + "\nNombre: " + producto.getNombreProdu());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Precio Base: " + producto.getPrecio());
            System.out.println("----------------------------------------------");

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

    }
}
