package com.example.urbanCaps_Spring.modelos.mapas;

import com.example.urbanCaps_Spring.modelos.Venta;
import com.example.urbanCaps_Spring.modelos.dtos.VentaDTO;
import com.example.urbanCaps_Spring.modelos.dtos.VentaDetalleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IMapaDetalleVenta.class})
public interface IMapaVenta {

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "vendedor", ignore = true)
    @Mapping(target = "detalleVentas", ignore = true)
    @Mapping(target = "totalVenta", ignore = true)
    Venta convertirDTOAModelo (VentaDTO ventaDTO);

    @Mapping(source = "cliente.nombre", target = "nombreCliente")
    @Mapping(source = "vendedor.nombre", target = "nombreVendedor")
    @Mapping(source = "totalVenta", target = "totalVenta")
    @Mapping(source = "detalleVentas", target = "detalles")
    VentaDetalleDTO convertirModeloADTO(Venta venta);

    List<VentaDTO> listaADTO (List<Venta> lista);
}
