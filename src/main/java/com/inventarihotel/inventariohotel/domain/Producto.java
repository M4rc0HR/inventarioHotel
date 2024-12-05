package com.inventarihotel.inventariohotel.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombreProducto;

    private String descripcionProducto;

    private Double precioProducto;

}
