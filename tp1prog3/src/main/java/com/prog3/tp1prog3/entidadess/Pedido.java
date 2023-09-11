package com.prog3.tp1prog3.entidadess;



import com.prog3.tp1prog3.util.Estado;
import com.prog3.tp1prog3.util.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Pedido")
public class Pedido extends BaseEntidad {

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "Estado")
    private Estado estado;

    @Column(name = "Hora_Estimada_Entrega")
    private LocalDateTime horaEstimadaEntrega;

    @Column(name = "Tipo_Envio")
    private TipoEnvio tipoEnvio;

    @Column(name = "Total")
    private double total;

    @OneToOne
    private Factura factura;

    @OneToMany
    @Column(name = "Detalle_Pedido_ID")
    private List<DetallePedido> detallesPedidos;

}