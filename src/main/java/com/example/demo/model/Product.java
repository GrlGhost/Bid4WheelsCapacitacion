package com.example.demo.model;

import com.example.demo.dto.CreateProductDTO;
import com.example.demo.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private double price;

    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .uuid(this.getUuid())
                .name(this.getName())
                .price(this.getPrice())
                .build();
    }


}
