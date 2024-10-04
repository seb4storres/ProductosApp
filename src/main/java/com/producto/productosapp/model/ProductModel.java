package com.producto.productosapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "type", length = 45)
    private String type;
    @Column(name = "price")
    private Double price;

    public ProductModel(){}

    public ProductModel(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public ProductModel(String message) {

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



