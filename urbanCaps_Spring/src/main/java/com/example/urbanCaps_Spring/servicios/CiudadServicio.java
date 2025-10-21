package com.example.urbanCaps_Spring.servicios;

import com.example.urbanCaps_Spring.modelos.Ciudad;
import com.example.urbanCaps_Spring.modelos.dtos.CiudadDTO;
import com.example.urbanCaps_Spring.modelos.mapas.IMapaCiudad;
import com.example.urbanCaps_Spring.repositorios.ICiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CiudadServicio {

    //LO PRIMERO ES DESDE EL SERVICIO ES LLAMAR AL REPOSITORIO
    //INYECTAR SUS DEPENDENCIAS

    @Autowired
    private ICiudadRepositorio respositorio;
    @Autowired
    private IMapaCiudad mapa;

    //SERIVICIO PARA GUARDAR UNA CIUDAD
    public CiudadDTO guardarCiudad(CiudadDTO datosCiudadDTO) throws Exception {
        // 1. Convertir DTO a Entidad para hacer la validación
        Ciudad ciudadAValidar = this.mapa.covertirDtoAModelo(datosCiudadDTO);
        try {
            Optional<Ciudad> ciudadEncontrada = this.respositorio.findByNombreCiudad(ciudadAValidar.getNombreCiudad());
            if (ciudadEncontrada.isPresent()) {
                throw new IllegalArgumentException("La Ciudad: " + datosCiudadDTO.getNombreCiudad() + " ya existe");
            }
            // 2. Guardar la Entidad
            Ciudad ciudadAGuardar = this.respositorio.save(ciudadAValidar);
            // 3. Mapear y Retornar DTO
            return this.mapa.convertirModeloADto(ciudadAGuardar);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception error) {
            throw new Exception("Hubo un error: " + error.getMessage());
        }
    }

    public CiudadDTO buscarCiudad(String nombre) throws Exception {
        try {
            Optional<Ciudad> ciudadAEncontrar = this.respositorio.findByNombreCiudad(nombre);
            if (ciudadAEncontrar.isEmpty()) {
                throw new NoSuchElementException("No se encontro la ciudad con el nombre: " + nombre);
            }
            return this.mapa.convertirModeloADto(ciudadAEncontrar.get());

        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);

        }catch (Exception error) {
            throw new Exception("Hubo un error buscando la ciudad: " + error.getMessage());
        }
    }
}