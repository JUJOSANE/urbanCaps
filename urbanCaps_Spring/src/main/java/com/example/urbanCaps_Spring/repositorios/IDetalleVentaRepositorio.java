package com.example.urbanCaps_Spring.repositorios;

import com.example.urbanCaps_Spring.modelos.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVentaRepositorio extends JpaRepository<DetalleVenta, Integer> {

}
