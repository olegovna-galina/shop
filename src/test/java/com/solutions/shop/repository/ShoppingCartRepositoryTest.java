package com.solutions.shop.repository;

import com.solutions.shop.model.Customer;
import com.solutions.shop.model.Product;
import com.solutions.shop.model.ShoppingCart;
import java.math.BigDecimal;

import com.solutions.shop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ShoppingCartRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testShoppingCartCreate() {
        User user1 = new User(998,"test-logon", "test-passw");

        Customer testCustomer1 = new Customer(998, "Customer1",
                "testLastName", "Polesskaya 8");

        Product product = new Product(500, "Eis 50 Cent",
                "milk ice cream covered with chocolate",
                new BigDecimal("2.50"), "OOO 'MinskMilk'", "food");

        ShoppingCart cart = new ShoppingCart(1, 998, false, product);

        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.persist(product);
        entityManager.persist(cart);
        entityManager.flush();
    }
}
