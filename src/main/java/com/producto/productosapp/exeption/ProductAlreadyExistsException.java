package com.producto.productosapp.exeption;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException (String message){
        super(message);
    }
}
