package com.example.urbanCaps_Spring.controladores;


import com.example.urbanCaps_Spring.modelos.dtos.ProductoBaseDTO;
import com.example.urbanCaps_Spring.servicios.ProductoBaseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/productos")
public class ProductoBaseControlador {
    @Autowired
    ProductoBaseServicio servicio;

    //Guardar Producto
    @PostMapping
    public ResponseEntity<ProductoBaseDTO> guardarProducto(@RequestBody ProductoBaseDTO datos){
        try {
            ProductoBaseDTO productoGuardado = this.servicio.guardarProducto(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productoGuardado);

        }catch (IllegalArgumentException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);

        }
    }

    //Editar producto
    @PutMapping("/modificar/{id}")
    public ResponseEntity<ProductoBaseDTO> modificarProducto(@PathVariable Integer id, @RequestBody ProductoBaseDTO datos){
        try {
            datos.setId(id);
            ProductoBaseDTO productoModificar = this.servicio.modificarProductos(datos);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productoModificar);

        }catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    //Eliminar prodcuto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id){
        try {
            String productoEliminar = this.servicio.eliminarProducto(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productoEliminar);

        }catch (NoSuchElementException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    //Buscar todos
    @GetMapping
    public ResponseEntity<List<ProductoBaseDTO>> findAll(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.findAll());

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    //Bscar por nombre
    @GetMapping("/nombre/{nombreProdu}")
    public ResponseEntity<ProductoBaseDTO> buscarPorNombre(@PathVariable String nombreProdu){
        try {
            ProductoBaseDTO productoNombre = this.servicio.buscarPorNombre(nombreProdu);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productoNombre);

        }catch (NoSuchElementException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    //Buscar por Marca
    @GetMapping("/marca/{marca}")
    public ResponseEntity<ProductoBaseDTO> buscarPorMarca(@PathVariable String marca){
        try {
            ProductoBaseDTO productoMarca = this.servicio.buscarPorMarca(marca);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productoMarca);

        }catch (NoSuchElementException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
