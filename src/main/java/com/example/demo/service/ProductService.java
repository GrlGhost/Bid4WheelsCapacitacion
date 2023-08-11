package com.example.demo.service;

import com.example.demo.dto.CreateProductDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProducts();
    ProductDTO createProduct(CreateProductDTO createProductDTO);
    Optional<Product> updateProduct(CreateProductDTO createProductDTO, UUID uuid);
    void deleteProduct(UUID uuid);
    Optional<Product> getProductByID(UUID uuid);
}
