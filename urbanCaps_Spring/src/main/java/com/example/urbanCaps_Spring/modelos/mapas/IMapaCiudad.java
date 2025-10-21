package com.example.urbanCaps_Spring.modelos.mapas;

import com.example.urbanCaps_Spring.modelos.Ciudad;
import com.example.urbanCaps_Spring.modelos.dtos.CiudadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaCiudad {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombreCiudad", target = "nombreCiudad")
    CiudadDTO convertirModeloADto(Ciudad ciudad);

    Ciudad covertirDtoAModelo(CiudadDTO ciudadDTO);

    List<CiudadDTO> convertirListaADto(List<Ciudad> lista);
}
