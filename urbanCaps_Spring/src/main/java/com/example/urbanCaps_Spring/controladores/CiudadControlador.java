package com.example.urbanCaps_Spring.controladores;

import com.example.urbanCaps_Spring.modelos.dtos.CiudadDTO;
import com.example.urbanCaps_Spring.servicios.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ciudades")
public class CiudadControlador {

    @Autowired
    CiudadServicio servicio;

    //Activando guardar una CIUDAD
    @PostMapping
    public ResponseEntity<CiudadDTO> guardarCiudad(@RequestBody CiudadDTO datos) {
        try {
            CiudadDTO ciudadGuardada = this.servicio.guardarCiudad(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ciudadGuardada);

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<CiudadDTO> buscarCiudad(@PathVariable String nombre) {
        try {
            CiudadDTO ciudad = this.servicio.buscarCiudad(nombre);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ciudad);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<CiudadDTO>>buscarTodos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.findAll());
        }catch (Exception error){
            error.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
