package com.prog3.tp1prog3.entidadess;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Config_General")
public class ConfiguracionGeneral extends BaseEntidad{

    @Column(name = "Cantidad_Cocineros")
    private int cantidadCocineros;

    @Column(name = "Email_Empresa")
    private String emailEmpresa;

    @Column(name = "Token_Mercadopago")
    private String tokenMercadoPago;

}
