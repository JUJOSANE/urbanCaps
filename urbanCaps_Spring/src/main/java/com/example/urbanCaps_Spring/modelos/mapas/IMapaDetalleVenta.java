package com.example.urbanCaps_Spring.modelos.mapas;

import com.example.urbanCaps_Spring.modelos.DetalleVenta;
import com.example.urbanCaps_Spring.modelos.dtos.DetalleVentaDTO;
import com.example.urbanCaps_Spring.modelos.dtos.DetalleVentaRespuestaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaDetalleVenta {

    DetalleVentaDTO convertirModeloADTO (DetalleVenta detalleVenta);

    @Mapping(target = "venta", ignore = true)
    @Mapping(target = "productoBase", ignore = true)
    @Mapping(target = "subTotal", ignore = true)
    DetalleVenta convertirDTOAModelo (DetalleVentaDTO detalleVentaDTO);

    @Mapping(source = "productoBase.nombreProdu", target = "nombreProdu")
    DetalleVentaRespuestaDTO covertirModeloARespuestaDTO(DetalleVenta detalleVenta);



    //List<DetalleVentaDTO> convertirListaADTO(List<DetalleVenta> lista);


}
