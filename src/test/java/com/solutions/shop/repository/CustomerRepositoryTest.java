package com.solutions.shop.repository;

import com.solutions.shop.model.Customer;
import com.solutions.shop.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    /* New User and Customer for all Tests */
    User user1 = new User(998,"test-logon", "test-passw");

    Customer testCustomer1 = new Customer(998, user1,"Customer1",
            "testLastName", "Polesskaya 8");

    @Test
    public void testCustomerCreate() {
        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.flush();
    }

    @Test
    public void testCustomerRead() {
        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.flush();

        Customer result = entityManager.find(Customer.class, 998);
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testCustomerUpdate() {
        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.flush();

        testCustomer1.setFirstName("NewFirstName");
        testCustomer1.setLastName("NewLastName");
        testCustomer1.setAddress("Polesskaya 88");
        System.out.println(testCustomer1);
    }

    @Test
    public void testCustomerDelete() {
        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.flush();

        entityManager.remove(testCustomer1); // ?? I don't see Delete-Operation
    }
}
