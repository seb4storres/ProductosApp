package com.producto.productosapp.service;

import com.producto.productosapp.model.ProductModel;
import com.producto.productosapp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void obtenerProductos() {
        List<ProductModel> expectedProducts = new ArrayList<>();
        expectedProducts.add(new ProductModel(Long.valueOf(1586555), "Category 1","plastic"));
        expectedProducts.add(new ProductModel(Long.valueOf(1586547), "Category 1","plastic"));

        when(productRepository.findAll()).thenReturn(expectedProducts);

        List<ProductModel> actualProducts = productService.getAllProducts();

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void obtenerProductoporIdNUllsinoexiste() {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        ProductModel actualProduct = productService.getProductById(productId);

        assertNull(actualProduct);
    }
}