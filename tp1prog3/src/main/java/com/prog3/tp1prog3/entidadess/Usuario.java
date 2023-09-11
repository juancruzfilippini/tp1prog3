package com.prog3.tp1prog3.entidadess;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Usuario")
public class Usuario extends BaseEntidad{

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Password")
    private String password;

    @Column(name = "Rol")
    private String rol;

    @OneToMany
    @Column(name = "Pedidos_ID")
    private List<Pedido> pedidos;

}

