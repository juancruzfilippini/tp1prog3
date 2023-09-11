package com.prog3.tp1prog3.entidadess;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "Rubro")
public class Rubro extends BaseEntidad{

    @Column(name = "Denominacion")
    private String denominacion;

    @OneToMany
    @Column(name = "Productos_ID")
    private List<Producto> productos;

}
