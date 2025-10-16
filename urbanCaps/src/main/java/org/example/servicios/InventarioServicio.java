package org.example.servicios;

import org.example.Clases.ProductoBase;

import java.math.BigDecimal;
import java.util.*;

public class InventarioServicio {

    //IMPLEMETACION DE ARRAYLIST
    //Creamos la Lista que va guardar el INVENTARIO
    private List<ProductoBase> inventarioList = new ArrayList<>();
    private Map<Integer, ProductoBase> inventarioMap = new HashMap<>();
    //Creamos un constructor vacio de InventarioServicio, que podemos implementar mas adelante, como para inicializar el servicio
    public InventarioServicio(){
    }

    //Metodo para agregar los productos
    public void agregarProducto(ProductoBase producto){
        this.inventarioList.add(producto);
        this.inventarioMap.put(producto.getId(), producto);
        System.out.println("Producto " + producto.getNombreProdu() + " Ingresado con exito\n");
    }
    //Metodo para Listar los productos
//
//    public List<ProductoBase> listarTodos() {
//        return this.inventario;
//    }

    //LISTA COMPLETA
    public void reporteCompleto(){
        System.out.println("Lista de Productos");
        for (ProductoBase produ : this.inventarioList) {
            BigDecimal impuesto = produ.calcularImpuesto();
            BigDecimal total = produ.calcularPrecioTotal();

            System.out.println("---" + produ.getNombreProdu() + "---");
            System.out.println("Id: " + produ.getId());
            System.out.println("Marca: " + produ.getMarca());
            System.out.println("Precio Base: " + produ.getPrecio());
            System.out.println("Impuestos de: " + impuesto);
            System.out.println("El precio con el impuesto incluido es de: " + total + "\n");
            System.out.println("----------------------------------------------");
        }
        }
        //IMPLEMENTACION DE HASH MAP

    public ProductoBase busquedaPorId(int id){
        ProductoBase produ = this.inventarioMap.get(id);
        if (produ == null){
            throw new NoSuchElementException("Producto con id: " + id + ", No se encontro");
        }
        return produ;
    }



}
