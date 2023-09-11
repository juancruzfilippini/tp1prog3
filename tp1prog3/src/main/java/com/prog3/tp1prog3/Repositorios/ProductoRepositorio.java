package com.prog3.tp1prog3.Repositorios;

import com.prog3.tp1prog3.entidadess.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
