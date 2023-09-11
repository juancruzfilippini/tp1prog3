package com.prog3.tp1prog3.entidadess;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Domicilio")
public class Domicilio extends BaseEntidad{

    @Column(name = "Calle")
    private String calle;

    @Column(name = "Numero")
    private String numero;

    @Column(name = "Localidad")
    private String localidad;

    @OneToMany
    @Column(name = "Pedidos_ID")
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "Cliente_ID")
    private Cliente cliente;

}