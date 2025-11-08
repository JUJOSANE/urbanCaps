package com.example.urbanCaps_Spring.modelos.mapas;

import com.example.urbanCaps_Spring.modelos.Cliente;
import com.example.urbanCaps_Spring.modelos.dtos.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaCliente {

    @Mapping(source = "ciudad.id", target = "ciudadId")
    ClienteDTO convertirModeloADTO(Cliente cliente);

    @Mapping(target = "ciudad", ignore = true)
    Cliente convertirDtoAModelo(ClienteDTO clienteDTO);

    List<ClienteDTO> convertirListaADTO(List<Cliente> lista);

}
