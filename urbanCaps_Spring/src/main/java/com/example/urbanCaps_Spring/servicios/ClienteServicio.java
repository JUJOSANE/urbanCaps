package com.example.urbanCaps_Spring.servicios;

import com.example.urbanCaps_Spring.modelos.Ciudad;
import com.example.urbanCaps_Spring.modelos.Cliente;
import com.example.urbanCaps_Spring.modelos.dtos.ClienteDTO;
import com.example.urbanCaps_Spring.modelos.mapas.IMapaCliente;
import com.example.urbanCaps_Spring.repositorios.ICiudadRepositorio;
import com.example.urbanCaps_Spring.repositorios.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private IClienteRepositorio repositorio;
    @Autowired
    private ICiudadRepositorio repoCiudad;
    @Autowired
    private IMapaCliente mapa;

    //SERVICIO PARA GUARDAR UN CLIENTE
    public ClienteDTO guardarCliente (ClienteDTO datosClienteDTO)throws Exception{
        Cliente clienteAValidar = this.mapa.convertirDtoAModelo(datosClienteDTO);
        try {
            Optional<Cliente> clientePorCedula = this.repositorio.findByCedula(clienteAValidar.getCedula());
            if (clientePorCedula.isPresent()){
                throw new IllegalArgumentException("Ya existe un cliente con esta cedula: " + clienteAValidar.getCedula());
            }
            Integer ciudadId = datosClienteDTO.getCiudadId();
            Optional<Ciudad> ciudadEncontrada = this.repoCiudad.findById(ciudadId);
            if (ciudadEncontrada.isEmpty()){
                throw  new NoSuchElementException("La ciudad con el ID: " + ciudadId + " No fue encontrada, no se puede guardar el cliente.");
            }

            clienteAValidar.setCiudad(ciudadEncontrada.get());
            Cliente clienteGuardado = this.repositorio.save(clienteAValidar);
            return this.mapa.convertirModeloADTO(clienteGuardado);

        }catch (IllegalArgumentException | NoSuchElementException e){
            throw  e;

        } catch (Exception error) {
            throw new Exception("hubo un error inesperado: "+ error.getMessage());
        }
    }

    //BuscarPorNombre
    public ClienteDTO buscarPorNombre(String nombre)throws Exception{
        try {

            Optional<Cliente> clienteAEncontrar = this.repositorio.findByNombre(nombre);
            if (clienteAEncontrar.isEmpty()){
                throw new NoSuchElementException("No se encontro el cliente con el nombre: " + nombre);
            }
            return this.mapa.convertirModeloADTO(clienteAEncontrar.get());

        }catch (NoSuchElementException e){
            throw e;
        }catch (Exception error){
            throw new RuntimeException("Ocurrio un error no esperado: " + error.getMessage());
        }
    }

    //Buscar por Cedula
    public ClienteDTO buscarPorCedula(Integer cedula)throws Exception{
     try {
         Optional<Cliente> clienteAEncontrar = this.repositorio.findByCedula(cedula);
         if (clienteAEncontrar.isEmpty()){
             throw new NoSuchElementException("No se encontro el cliente con la cedula: " + cedula);
         }
         return this.mapa.convertirModeloADTO(clienteAEncontrar.get());

     }catch (NoSuchElementException e) {
         throw e;
     } catch (Exception error) {
         throw new RuntimeException("Ocurrio un error MegamenteInesperado: " + error.getMessage());
     }
    }

    //Buscat Todos
    public List<ClienteDTO> findAll(){
        List<Cliente> clientes = this.repositorio.findAll();
        return this.mapa.convertirListaADTO(clientes);
    }




}
