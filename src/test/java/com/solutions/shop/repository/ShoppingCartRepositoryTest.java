package com.solutions.shop.repository;

import com.solutions.shop.model.Customer;
import com.solutions.shop.model.Product;
import com.solutions.shop.model.ShoppingCart;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.solutions.shop.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ShoppingCartRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    User user1 = new User(998,"test-logon", "test-pass");

    Customer testCustomer1 = new Customer(998, user1,"Customer1",
            "testLastName", "Kovalevskaya 8");

    Product product = new Product(500, "Eis 50 Cent",
            "milk ice cream covered with chocolate",
            new BigDecimal("2.50"), "OOO 'MinskMilk'", "food");

    Product product2 = new Product(501, "Eis Kashtan",
            "milk ice cream",
            new BigDecimal("2.55"), "OOO 'MinskMilk'", "food");

    @Test
    public void testShoppingCartCreate() {
        Set setProducts = new HashSet();
        setProducts.add(product);
        setProducts.add(product2);
        ShoppingCart cart = new ShoppingCart(1, 998, false,
                testCustomer1, setProducts);

        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.persist(product);
        entityManager.persist(product2);
        entityManager.persist(cart);
        entityManager.flush();
        System.out.println(cart);
    }

    @Test
    public void testShoppingCartRead() {
        Set setProducts = new HashSet();
        setProducts.add(product);
        ShoppingCart cart = new ShoppingCart(1, 998, false,
                testCustomer1, setProducts);

        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.persist(product);
        entityManager.persist(cart);
        entityManager.flush();

        ShoppingCart resultCart = entityManager.find(ShoppingCart.class, 1);
        Assertions.assertNotNull(resultCart);
        System.out.println(resultCart);
    }

    @Test
    public void testShoppingCartUpdate() {
        Set setProducts = new HashSet();
        setProducts.add(product);
        setProducts.add(product2);
        ShoppingCart cart = new ShoppingCart(1, 998, false,
                testCustomer1, setProducts);

        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.persist(product);
        entityManager.persist(product2);
        entityManager.persist(cart);
        entityManager.flush();

        setProducts.remove(product);
        cart.setProducts(setProducts);
        cart.setConfirmed(true);
        //entityManager.refresh(cart);
        System.out.println(cart);
    }

    @Test
    public void testShoppingCartDelete() {
        Set setProducts = new HashSet();
        setProducts.add(product);
        ShoppingCart cart = new ShoppingCart(1, 998, false,
                testCustomer1, setProducts);

        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.persist(product);
        entityManager.persist(cart);
        entityManager.flush();

        entityManager.remove(cart); // ?? I don't see Delete-Operation
    }
}
