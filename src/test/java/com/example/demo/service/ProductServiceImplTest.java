package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    void simpleTest(){
        assertTrue(productService.getAllProducts().isEmpty());

        ProductDTO productDTO = ProductDTO.builder()
                .name("MacBook")
                .price(1500)
                .build();

        Product savedProduct = productService.createProduct(productDTO);
        List<Product> products = productService.getAllProducts();
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());

        Product product = products.get(0);
        assertEquals(product, savedProduct);

        ProductDTO updatedProductDTO = ProductDTO.builder()
                .name("Macbook Pro")
                .price(2000)
                .build();
        Optional<Product> savedUpdatedProduct = productService.updateProduct(updatedProductDTO,savedProduct.getUuid());

        List<Product> updatedProducts = productService.getAllProducts();
        assertFalse(updatedProducts.isEmpty());
        assertEquals(1, updatedProducts.size());

        Product updatedProduct = updatedProducts.get(0);
        assertEquals(savedUpdatedProduct.get(), updatedProduct);

        productService.deleteProduct(updatedProduct.getUuid());
        assertTrue(productService.getAllProducts().isEmpty());

    }
}
