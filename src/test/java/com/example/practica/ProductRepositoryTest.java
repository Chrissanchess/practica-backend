package com.example.practica.repository;

import com.example.practica.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;              // Spring Boot 4.x
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;    // Spring Boot 4.x
// Si tu proyecto es Spring Boot 3.x, usa en su lugar:
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void shouldSaveAndFindByNameIgnoringCase() {
        Product saved = repository.save(Product.builder()
                .name("Laptop Gamer")
                .price(new BigDecimal("1500.00"))
                .stock(5)
                .build());

        List<Product> result = repository.findByNameContainingIgnoreCase("laptop");

        assertThat(saved.getId()).isNotNull();
        assertThat(result).extracting(Product::getName).contains("Laptop Gamer");
    }
}