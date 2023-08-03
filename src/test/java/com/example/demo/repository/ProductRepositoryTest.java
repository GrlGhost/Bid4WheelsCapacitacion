package com.example.demo.repository;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureWebClient
@DataJpaTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void simpleProductRepositoryTest(){
        assertTrue(productRepository.findAll().isEmpty());

        String name = "name";
        double  price = 1500;
        Product nonPersistedProduct = Product.builder().name(name).price(price).build();

        assertNull(nonPersistedProduct.getUuid());
        assertEquals(nonPersistedProduct.getName(), name);
        assertEquals(nonPersistedProduct.getPrice(), price);

        productRepository.save(nonPersistedProduct);
        List<Product> products = productRepository.findAll();
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());

        Product persistedProduct = products.get(0);
        assertNotNull(persistedProduct.getUuid());
        assertEquals(persistedProduct.getName(), name);
        assertEquals(persistedProduct.getPrice(), price);
    }
}
