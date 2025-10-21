package com.example.urbanCaps_Spring.repositorios;

import com.example.urbanCaps_Spring.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {

    //Agregacion del Crud, Aparte consultas para buenas practicas
    Optional<Cliente> findByNombre(String nombre);

    Optional<Cliente> findByCedula (Integer cedula);
}
