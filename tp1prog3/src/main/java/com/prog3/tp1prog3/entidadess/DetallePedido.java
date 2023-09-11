package com.prog3.tp1prog3.entidadess;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Detalle_Pedido")
public class DetallePedido extends BaseEntidad{

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "Productos_ID")
    private Producto producto;

}
