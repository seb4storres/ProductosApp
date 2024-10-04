package com.producto.productosapp.repository;

import com.producto.productosapp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    @Query(nativeQuery = true, value = "CALL getProductsByMinPrice(?)")
    List<ProductModel> getProductsByMinPrice(Double minPrice);
}
