package com.example.urbanCaps_Spring.modelos.mapas;

import com.example.urbanCaps_Spring.modelos.ProductoBase;
import com.example.urbanCaps_Spring.modelos.dtos.ProductoBaseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaProductoBase {

    ProductoBaseDTO convertirModeloADTO (ProductoBase productoBase);

    ProductoBase convertirDTOaModelo (ProductoBaseDTO productoBaseDTO);

    List<ProductoBaseDTO> convertirListaADTO (List<ProductoBase> lista);
}
