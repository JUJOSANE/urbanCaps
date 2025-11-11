package com.example.urbanCaps_Spring.controladores;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.urbanCaps_Spring.modelos.dtos.VendedorDTO;
import com.example.urbanCaps_Spring.servicios.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/vendedores")
public class VendedorControlador {

    @Autowired
    VendedorServicio servicio;

    //Guardar Vendedor
    @PostMapping
    public ResponseEntity<VendedorDTO> guardarVendedor(@RequestBody VendedorDTO datosVendedor){
        try {
            VendedorDTO vendedorGuardado = this.servicio.guardarVendedor(datosVendedor);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(vendedorGuardado);

        }catch (IllegalArgumentException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    //Editar Vendedor
    @PutMapping("/modificar/{id}")
    public ResponseEntity<VendedorDTO> modificarVendedor (@PathVariable Integer id,  @RequestBody VendedorDTO datosAEditar){
        try {
            datosAEditar.setId(id);
            VendedorDTO vendedorAEditar = this.servicio.modificarVendedor(datosAEditar);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vendedorAEditar);

        }catch (NoSuchElementException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);

        }
    }

    //Eliminar vendedor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVendedor (@PathVariable Integer id){
        try {
                String vendedorEliminar = this.servicio.eliminarVendedor(id);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(vendedorEliminar);


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

    //Buscar vendedores por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<VendedorDTO>> buscarPorNombre(@PathVariable String nombre){
        try{
                List<VendedorDTO> nombreVendedor = this.servicio.buscarPorNombre(nombre);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(nombreVendedor);
        }catch (NoSuchElementException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }

    }

    //Buscar por cedula
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<VendedorDTO> buscarPorCedula(@PathVariable Integer cedula){
        try {
            VendedorDTO buscarConCedula = this.servicio.buscarPorCedula(cedula);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(buscarConCedula);

        }catch (NoSuchElementException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> buscarTodos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.findAll());

        }catch (Exception e){
             return ResponseEntity
                     .status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body(null);
        }

    }

}
