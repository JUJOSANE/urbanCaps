package com.example.urbanCaps_Spring.controladores;

import com.example.urbanCaps_Spring.excepciones.StockInsuficienteExcepcion;
import com.example.urbanCaps_Spring.modelos.dtos.VentaDTO;
import com.example.urbanCaps_Spring.modelos.dtos.VentaDetalleDTO;
import com.example.urbanCaps_Spring.modelos.dtos.VentaRespuestaDTO;
import com.example.urbanCaps_Spring.servicios.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ventas")
public class VentaControlador {

    @Autowired
    private VentaServicio servicio;

    @PostMapping
    public ResponseEntity<?> guardarVenta (@RequestBody VentaDTO datos){
        try{
            VentaRespuestaDTO respuestaDTO = this.servicio.guardarVenta(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaDTO);

        }catch (NoSuchElementException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }catch (StockInsuficienteExcepcion err){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(err.getMessage());

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    //Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<VentaDetalleDTO> buscarVentaPorId(@PathVariable Integer id) {
        try {
            VentaDetalleDTO venta = this.servicio.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(venta); // Código 200 OK

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Código 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Código 500
        }
    }

    //eliminar venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> anularVenta(@PathVariable Integer id){
        try {
            this.servicio.eliminarVenta(id);

            return ResponseEntity.noContent().build();

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
