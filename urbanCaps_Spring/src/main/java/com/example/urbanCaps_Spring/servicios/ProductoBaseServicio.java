package com.example.urbanCaps_Spring.servicios;

import com.example.urbanCaps_Spring.modelos.ProductoBase;
import com.example.urbanCaps_Spring.modelos.dtos.ProductoBaseDTO;
import com.example.urbanCaps_Spring.modelos.mapas.IMapaProductoBase;
import com.example.urbanCaps_Spring.repositorios.IProductoBaseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoBaseServicio {
    @Autowired
    private IProductoBaseRepositorio repositorio;
    @Autowired
    private IMapaProductoBase mapa;

    //Guardar Productos
    public ProductoBaseDTO guardarProducto(ProductoBaseDTO datos)throws Exception{
        try {
            ProductoBase producto = mapa.convertirDTOaModelo(datos);
            ProductoBase guardado = this.repositorio.save(producto);
            return mapa.convertirModeloADTO(guardado);

        }catch (Exception error){
            throw new Exception("Error al guardar el producto: " + error.getMessage());
        }
    }
    
    //Editar productos(PUT)
    public ProductoBaseDTO modificarProductos(ProductoBaseDTO datosDTO)throws Exception{
        if (datosDTO.getId() == null){
            throw new IllegalArgumentException("El id del producto es necesario");
        }
        try {
            this.repositorio.findById(datosDTO.getId())
                    .orElseThrow(() -> new NoSuchElementException("Producto con id: " + datosDTO.getId() +
                            " No se encontro para actualizar"));
            
            ProductoBase productoActualizar = this.mapa.convertirDTOaModelo(datosDTO);
            ProductoBase productoActualizado = this.repositorio.save(productoActualizar);
            
            return this.mapa.convertirModeloADTO(productoActualizado);

        }catch (NoSuchElementException e){
            throw e;
        }catch (IllegalArgumentException err){
            throw err;
        } catch (Exception error) {
            throw new Exception("Error al actualizar el producto: " + error.getMessage());
        }
    }

    //Elliminar producto
    public String eliminarProducto(Integer id)throws Exception{
        try {
            this.repositorio.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Producto con id: " +
                            id + " No fue encontrado para eliminarlo"));

            this.repositorio.deleteById(id);

            return "El producot id: " + id + " Fue eliminado Con Exito!";

        }catch (NoSuchElementException e){
            throw e;
        }catch (Exception error){
            throw new Exception("Error inesperado al intentar eliminar el producto: " + error.getMessage());
        }
    }

    //listar todos
    public List<ProductoBaseDTO> findAll(){
        List<ProductoBase> productos = this.repositorio.findAll();

        return this.mapa.convertirListaADTO(productos);
    }

    //Buscar por nombre
    public List<ProductoBaseDTO> buscarPorNombre(String nombreProdu)throws Exception{
        try {

            List<ProductoBase> listaAEncontrar = this.repositorio.findByNombreProdu(nombreProdu);
            if (listaAEncontrar.isEmpty()){
                throw new NoSuchElementException("No se encontraron Productos con el nombre: " + nombreProdu);
            }
            return this.mapa.convertirListaADTO(listaAEncontrar);

        }catch (NoSuchElementException e){
            throw e;
        }catch (Exception error){
            throw new RuntimeException("Ocurrio un error no esperado: " + error.getMessage());
        }
    }

    //Buscar por marca
    public List<ProductoBaseDTO> buscarPorMarca(String marca)throws Exception{
        try {

            List<ProductoBase> marcaAEncontrar = this.repositorio.findByMarca(marca);
            if (marcaAEncontrar.isEmpty()){
                throw new NoSuchElementException("No se encontro la marca con el nombre: " + marca);
            }
            return this.mapa.convertirListaADTO(marcaAEncontrar);

        }catch (NoSuchElementException e){
            throw e;
        }catch (Exception error){
            throw new RuntimeException("Ocurrio un error no esperado: " + error.getMessage());
        }
    }

    //Descontar Stock
    @Transactional
    public ProductoBase descontarStock(Integer productoId, Integer cantidadVendida){
        ProductoBase producto = repositorio.findById(productoId)
                .orElseThrow(()-> new NoSuchElementException("Producto con id: " + productoId + " No enccontrado"));

        if (producto.getStock() < cantidadVendida){
            throw new IllegalArgumentException("Stock insuficiente para el producto: " + producto.getNombreProdu());
        }
        producto.setStock(producto.getStock() - cantidadVendida);
        return repositorio.save(producto);

    }



}
