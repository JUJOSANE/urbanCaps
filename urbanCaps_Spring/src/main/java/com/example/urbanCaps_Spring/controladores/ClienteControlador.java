package com.example.urbanCaps_Spring.controladores;

import com.example.urbanCaps_Spring.modelos.Cliente;
import com.example.urbanCaps_Spring.modelos.dtos.ClienteDTO;
import com.example.urbanCaps_Spring.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    ClienteServicio servicio;

    //Guardar cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> guardarCliente(@RequestBody ClienteDTO datos){
        try{
            ClienteDTO clienteGuardado = this.servicio.guardarCliente(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(clienteGuardado);

        }catch (IllegalArgumentException e){
         return ResponseEntity
                 .status(HttpStatus.BAD_REQUEST)
                 .body(null);
        }catch (Exception error){
            error.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    //BuscarPornombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ClienteDTO> buscarPorNombre(@PathVariable String nombre){
        try {
            ClienteDTO cliente = this.servicio.buscarPorNombre(nombre);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(cliente);

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
    public ResponseEntity<ClienteDTO> buscarPorCedula(@PathVariable Integer cedula){
        try {
            ClienteDTO clienteCedula = this.servicio.buscarPorCedula(cedula);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(clienteCedula);

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
    //Buscar Todos
    @GetMapping
    public ResponseEntity <List<ClienteDTO>> findAll(){
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
