package com.example.urbanCaps_Spring.servicios;


import com.example.urbanCaps_Spring.excepciones.StockInsuficienteExcepcion;
import com.example.urbanCaps_Spring.modelos.*;
import com.example.urbanCaps_Spring.modelos.dtos.*;
import com.example.urbanCaps_Spring.modelos.mapas.IMapaDetalleVenta;
import com.example.urbanCaps_Spring.modelos.mapas.IMapaVenta;
import com.example.urbanCaps_Spring.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
@Transactional
public class VentaServicio {
    @Autowired
    private IVentaRepositorio repoVenta;
    @Autowired
    private IDetalleVentaRepositorio repoDetalle;
    @Autowired
    private IClienteRepositorio repoCliente;
    @Autowired
    private IVendedorRepositorio repoVendedor;
    @Autowired
    private IProductoBaseRepositorio repoProducto;
    @Autowired
    private IMapaVenta mapaVenta;
    @Autowired
    private IMapaDetalleVenta mapaDetalle;


    //Guardar Venta
    public VentaRespuestaDTO guardarVenta(VentaDTO ventaDTO) throws Exception {
        //Validar y obtener entidades(Cliente,Vendedor)
        Cliente cliente = repoCliente.findById(ventaDTO.getClienteId())
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado."));

        Vendedor vendedor = repoVendedor.findById(ventaDTO.getVendedorId())
                .orElseThrow(() -> new NoSuchElementException("Vendedor no encontrado."));

        //Crear y guardar venta principal
        Venta venta = mapaVenta.convertirDTOAModelo(ventaDTO);
        venta.setCliente(cliente);
        venta.setVendedor(vendedor);
        venta.setFecha(LocalDate.now());
        venta.setTotalVenta(0);

        Venta ventaGuardada = repoVenta.save(venta);

        double totalGlobal = 0.0;

        //Iterar y guardar cada detalle
        for (DetalleVentaDTO detalleDTO : ventaDTO.getDetalles()) {
            //Obtenemos producto
            ProductoBase producto = repoProducto.findById(detalleDTO.getProductoId())
                    .orElseThrow(() -> new NoSuchElementException("Producto con id: "
                            + detalleDTO.getProductoId() + " no encontado."));

            //Validacion de stock
            int cantidadSolicitada = detalleDTO.getCantidad();
            int stockDisponible = producto.getStock();
            if (cantidadSolicitada > stockDisponible) {
                throw new StockInsuficienteExcepcion(producto.getNombreProdu(), stockDisponible, cantidadSolicitada);
            }

            //Mapear y calcular el detalle
            DetalleVenta detalle = mapaDetalle.convertirDTOAModelo(detalleDTO);

            double subTotal = producto.getPrecio() * detalle.getCantidad();

            //Asignar las refetencias y valores calculados
            detalle.setProductoBase(producto);
            detalle.setVenta(ventaGuardada);
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubTotal(subTotal);

            //Actualizar stock
            producto.setStock(producto.getStock() - detalle.getCantidad());
            repoProducto.save(producto);

            //GuardarDetalle
            repoDetalle.save(detalle);

            totalGlobal += subTotal;
        }
        //Actualizar el total de la venta
        ventaGuardada.setTotalVenta((int) Math.round(totalGlobal));
        return new VentaRespuestaDTO(ventaGuardada.getId(), totalGlobal);
    }

    //Buscar por id
    public VentaDetalleDTO buscarPorId(Integer id) throws NoSuchElementException {
        Venta venta = repoVenta.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontrla Venta con el id: " + id));

            for (DetalleVenta detalle : venta.getDetalleVentas()){
                detalle.getProductoBase().getNombreProdu();
            }
        return mapaVenta.convertirModeloADTO(venta);

    }
    @Transactional
    public void eliminarVenta (Integer id)throws NoSuchElementException{
        Venta venta = repoVenta.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Venta com id: " + id + " no encontrada."));
        for (DetalleVenta detalle : venta.getDetalleVentas()){
            ProductoBase producto = detalle.getProductoBase();

            int stockActual = producto.getStock();
            int cantidadVendida = detalle.getCantidad();

            producto.setStock(stockActual + cantidadVendida);

            repoDetalle.delete(detalle);
        }
        repoVenta.delete(venta);
    }

}

