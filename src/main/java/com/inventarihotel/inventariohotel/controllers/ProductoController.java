package com.inventarihotel.inventariohotel.controllers;

import com.inventarihotel.inventariohotel.domain.Producto;
import com.inventarihotel.inventariohotel.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @file: ProductoController.java
 * @author: (c)2024 MARCO
 * @created: 23/11/2024 15:22
 */

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Método para listar todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = productoService.listar();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();  // Devuelve 204 si no hay productos
        }
        return ResponseEntity.ok(productos);  // Devuelve los productos con un 200 OK
    }

    // Método para buscar un producto por ID
    @GetMapping("{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.buscarPorId(id);
        return productoOptional
                .map(ResponseEntity::ok)  // Si el producto existe, devuelve 200 OK con el producto
                .orElseGet(() -> ResponseEntity.notFound().build());  // Si no se encuentra, devuelve 404
    }

    // Método para guardar un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        Producto productoGuardado = productoService.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);  // Devuelve 201 creado con el producto guardado
    }

    // Método para eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.buscarPorId(id);
        if (productoOptional.isPresent()) {
            productoService.eliminar(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        }
        return ResponseEntity.notFound().build();  // Devuelve 404 si no se encuentra el producto
    }
}
