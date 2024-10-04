package com.producto.productosapp.service;

import com.producto.productosapp.model.ProductModel;
import com.producto.productosapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductModel getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductModel createProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel updateProduct(Long id, ProductModel updatedProduct) {
        ProductModel productModel = productRepository.findById(id).orElse(null);
        if (productModel != null) {
            productModel.setName(updatedProduct.getName());
            productModel.setType(updatedProduct.getType());
            return productRepository.save(productModel);
        } else {
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductModel> getProductsWithPriceGreaterThan(Double minPrice) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getPrice() > minPrice)
                .collect(Collectors.toList());
    }
    public List<ProductModel> getProductsByMinPrice(Double minPrice) {
        return productRepository.getProductsByMinPrice(minPrice);
    }
}
