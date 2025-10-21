package com.example.urbanCaps_Spring.repositorios;

import com.example.urbanCaps_Spring.modelos.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVendedorRepositorio extends JpaRepository<Vendedor, Integer> {
    Optional<Vendedor> findByNombre(String nombre);
    Optional<Vendedor> findByCedula(Integer cedula);
}
