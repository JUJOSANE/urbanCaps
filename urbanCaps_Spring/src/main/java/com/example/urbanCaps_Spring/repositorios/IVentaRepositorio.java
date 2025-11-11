package com.example.urbanCaps_Spring.repositorios;

import com.example.urbanCaps_Spring.modelos.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IVentaRepositorio extends JpaRepository<Venta, Integer> {

}
