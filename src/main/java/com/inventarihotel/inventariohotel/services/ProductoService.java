package com.inventarihotel.inventariohotel.services;

import com.inventarihotel.inventariohotel.domain.Producto;

import java.util.List;
import java.util.Optional;

/**
 * @file: ProductoService.java
 * @author: (c)2024 MARCO
 * @created: 23/11/2024 15:20
 */
public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> buscarPorId(Long id);
    Producto guardar(Producto producto);
    void eliminar(Long id);
}
