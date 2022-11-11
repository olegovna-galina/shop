package com.solutions.shop.repository;

import com.solutions.shop.model.Product;
import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    /* New Product for all Tests */
    Product product = new Product(500, "Eis 50 Cent",
            "milk ice cream covered with chocolate",
            new BigDecimal("2.50"), "OOO 'MinskMilk'", "food");

    @Test
    public void testProductCreate() {
        entityManager.persist(product);
        entityManager.flush();
    }

    @Test
    public void testProductRead() {
        entityManager.persist(product);
        entityManager.flush();

        Product result = entityManager.find(Product.class, 500);
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testProductUpdate() {
        entityManager.persist(product);
        entityManager.flush();

        product.setPrice(new BigDecimal("3.99"));
        System.out.println(product);
    }

    @Test
    public void testProductDelete() {
        entityManager.persist(product);
        entityManager.flush();

        entityManager.remove(product); // ?? I don't see Delete-Operation
    }
}
