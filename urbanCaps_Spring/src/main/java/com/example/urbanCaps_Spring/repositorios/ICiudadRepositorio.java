package com.example.urbanCaps_Spring.repositorios;

import com.example.urbanCaps_Spring.modelos.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICiudadRepositorio extends JpaRepository<Ciudad, Integer> {

    Optional<Ciudad> findByNombreCiudad(String nombreCiudad);
}
