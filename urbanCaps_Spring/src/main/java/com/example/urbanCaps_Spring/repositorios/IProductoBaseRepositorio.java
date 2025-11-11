package com.example.urbanCaps_Spring.repositorios;

import com.example.urbanCaps_Spring.modelos.ProductoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoBaseRepositorio extends JpaRepository<ProductoBase, Integer> {
    //IMPLEMENTACION DE METODOS COMPLEJOS

    List<ProductoBase> findByNombreProdu(String nombreProdu);
    List<ProductoBase> findByMarca(String marca);
}
