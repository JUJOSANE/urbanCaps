package com.example.urbanCaps_Spring.modelos.mapas;

import com.example.urbanCaps_Spring.modelos.Vendedor;
import com.example.urbanCaps_Spring.modelos.dtos.VendedorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaVendedor {

    VendedorDTO convertirModeloADTO(Vendedor vendedor);

    Vendedor convertirDTOAModelo (VendedorDTO vendedorDTO);

    List<VendedorDTO> listaADTO(List<Vendedor> lista);
}
