package com.prog3.tp1prog3.Repositorios;

import com.prog3.tp1prog3.entidadess.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
