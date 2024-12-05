package com.inventarihotel.inventariohotel.repositories;

import com.inventarihotel.inventariohotel.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @file: ProductoRepository.java
 * @author: (c)2024 MARCO
 * @created: 23/11/2024 15:18
 */

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
