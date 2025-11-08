package com.example.urbanCaps_Spring.modelos.mapas;

import com.example.urbanCaps_Spring.modelos.DetalleVenta;
import com.example.urbanCaps_Spring.modelos.dtos.DetalleVentaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaDetalleVenta {

    DetalleVentaDTO convertirModeloADTO (DetalleVenta detalleVenta);

    DetalleVenta convertirDTOAModelo (DetalleVentaDTO detalleVentaDTO);

    List<DetalleVentaDTO> convertirListaADTO(List<DetalleVenta> lista);
}
