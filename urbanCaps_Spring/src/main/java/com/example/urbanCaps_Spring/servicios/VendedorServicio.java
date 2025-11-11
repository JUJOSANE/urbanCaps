package com.example.urbanCaps_Spring.servicios;


import com.example.urbanCaps_Spring.modelos.Vendedor;
import com.example.urbanCaps_Spring.modelos.dtos.VendedorDTO;
import com.example.urbanCaps_Spring.modelos.mapas.IMapaVendedor;
import com.example.urbanCaps_Spring.repositorios.IVendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VendedorServicio {
    
    @Autowired
    private IMapaVendedor mapaVendedor;
    @Autowired
    private IVendedorRepositorio repositorio;
    
    //Guardar Vendedor
    public VendedorDTO guardarVendedor (VendedorDTO datos)throws Exception{
        Vendedor vendedorAValidar = this.mapaVendedor.convertirDTOAModelo(datos);
        try {
            if (this.repositorio.findByCedula(vendedorAValidar.getCedula()).isPresent()){
                throw new IllegalArgumentException("ya existe un vendedor con la cedula: " + vendedorAValidar.getCedula());
            }
            Vendedor vendedorAGuardar = this.repositorio.save(vendedorAValidar);
            return this.mapaVendedor.convertirModeloADTO(vendedorAGuardar);
            
        }catch (IllegalArgumentException e){
            throw e;
        } catch (Exception error) {
            throw new Exception(error);
        }
        
    }
    
    //EDITAR VENDEDOR
    public VendedorDTO modificarVendedor(VendedorDTO vendedorDTO)throws Exception{
        if (vendedorDTO.getId() == null){
            throw new IllegalArgumentException("El id del vendedor es obligatorio");            
        }
        try {
            this.repositorio.findById(vendedorDTO.getId())
                    .orElseThrow(()-> new NoSuchElementException("Vendedor con id " + vendedorDTO.getId() + " No se encontro para actualizar"));
            Vendedor vendedorActualizar = this.mapaVendedor.convertirDTOAModelo(vendedorDTO);
            Vendedor vendedotActualizado = this.repositorio.save(vendedorActualizar);
            
            return this.mapaVendedor.convertirModeloADTO(vendedotActualizado);
            
        }catch (NoSuchElementException | IllegalArgumentException e){
            throw e;
        } catch (Exception error) {
            throw new Exception("Error al actualizar un vendedor: " + error.getMessage());
        }
    }
    
    //Eliminar Vendedor
    public String eliminarVendedor(Integer id)throws Exception{
        try {
            this.repositorio.findById(id)
                    .orElseThrow(()->  new NoSuchElementException("Vendedor con id: " + id + " No fue encontrado para eliminarlo" ));
            
            this.repositorio.deleteById(id);
            return "El vendedor con id " + id + " Fue eliminado con exito!";
            
        }catch (NoSuchElementException e){
            throw e;
        }catch (Exception error){
            throw new Exception("Error inesperado al intentar eliminar un vendedor: " + error.getMessage());
        }
    }
    
    //Buscar por Nombre
    public List<VendedorDTO> buscarPorNombre (String nombre)throws Exception{
        try {
            List<Vendedor> vendedores = this.repositorio.findByNombre(nombre);
                if (vendedores.isEmpty()){
                 throw new NoSuchElementException("No se encontraron los vendedores con el nombre: " + nombre);
                }
                return this.mapaVendedor.listaADTO(vendedores);
            
        }catch (NoSuchElementException e){
            throw e;
        }catch (Exception error){
            throw new RuntimeException("Error al buscar el vendedor por nombre " + error.getMessage());
        }
    }

    //Buscar por Cedula
    public VendedorDTO buscarPorCedula (Integer cedula)throws Exception{
        try {
            Vendedor vendedor = this.repositorio.findByCedula(cedula)
                    .orElseThrow(()-> new NoSuchElementException("No se encontro el vendedor con la cedula: " + cedula));

            return this.mapaVendedor.convertirModeloADTO(vendedor);
        }catch (NoSuchElementException error){
            throw error;
        } catch (Exception e) {
            throw new Exception("Error al buscar el vendedor por cedula: " + e.getMessage());
        }

    }

    //Buscar todos
    public List<VendedorDTO> findAll(){
        List<Vendedor> vendedores = this.repositorio.findAll();
        return this.mapaVendedor.listaADTO(vendedores);
    }
    
}
