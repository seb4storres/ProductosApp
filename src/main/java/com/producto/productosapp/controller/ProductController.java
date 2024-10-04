package com.producto.productosapp.controller;

import com.producto.productosapp.exeption.ProductAlreadyExistsException;
import com.producto.productosapp.model.ProductModel;
import com.producto.productosapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getUserById(@PathVariable Long id) {
        ProductModel product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductModel> createProduct( @RequestBody ProductModel product) {
        try {
            ProductModel  productCreated = productService.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
        }catch (ProductAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ProductModel(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel updatedProduct) {
        ProductModel updatedModified = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(updatedModified);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-price")
    public ResponseEntity<List<ProductModel>> getProductsByMinPrice(@RequestParam Double minPrice) {
        List<ProductModel> products = productService.getProductsByMinPrice(minPrice);
        return ResponseEntity.ok(products);
    }
}
