package com.example.urbanCaps_Spring.excepciones;

public class StockInsuficienteExcepcion extends RuntimeException{
    public StockInsuficienteExcepcion(String producto, int stock, int solicitado){
        super("Stock insuficiente para el producto: " + producto + ". Disponible: " +
                stock + ", Solicitado: " + solicitado);
    }
}
