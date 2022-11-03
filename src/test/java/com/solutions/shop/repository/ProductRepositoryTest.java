package com.solutions.shop.repository;

import com.solutions.shop.model.Product;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testProductCreate() {
        Product product = new Product(500, "Eis 50 Cent",
                "milk ice cream covered with chocolate",
                new BigDecimal("2.50"), "OOO 'MinskMilk'", "food");

        entityManager.persist(product);
        entityManager.flush();
    }
}
