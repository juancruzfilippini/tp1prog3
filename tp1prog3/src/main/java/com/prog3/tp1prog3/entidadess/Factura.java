package com.prog3.tp1prog3.entidadess;



import com.prog3.tp1prog3.util.FormaPago;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Factura")
public class Factura extends BaseEntidad {

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @Column(name = "Numero")
    private int numero;

    @Column(name = "Descuento")
    private Double descuento;

    @Column(name = "Forma_Pago")
    private FormaPago formaPago;

    @Column(name = "Total")
    private int total;

}
