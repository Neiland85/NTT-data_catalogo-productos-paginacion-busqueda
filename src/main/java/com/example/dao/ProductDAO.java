package com.example.dao;

import com.example.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {
        // Simulación de datos de una base de datos
        List<Product> products = new ArrayList<>();
        products.add(new Product("Producto 1", 10.99));
        products.add(new Product("Producto 2", 25.50));
        products.add(new Product("Producto 3", 5.75));
        products.add(new Product("Producto 4", 12.20));
        products.add(new Product("Producto 5", 8.00));
        products.add(new Product("Producto 6", 30.75));
        products.add(new Product("Producto 7", 15.99));


        return products;
    }
}
