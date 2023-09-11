package com.prog3.tp1prog3.entidadess;



import com.prog3.tp1prog3.util.TipoProducto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Producto")
public class Producto extends BaseEntidad{

    @Column(name = "Tipo_Producto")
    private TipoProducto tipoProducto;

    @Column(name = "Tiempo_Estimado")
    private int tiempoEstimadoCocina;

    @Column(name = "Denominacion")
    private String denominacion;

    @Column(name = "Precio_Venta")
    private Double precioVenta;

    @Column(name = "Precio_Compra")
    private Double precioCompra;

    @Column(name = "Stock_Actual")
    private int stockActual;

    @Column(name = "Stock_Minimo")
    private int stockMinimo;

    @Column(name = "Unidad_Medida")
    private String unidadMedida;

    @Column(name = "Foto")
    private String foto;

    @Column(name = "Receta")
    private String receta;

}
