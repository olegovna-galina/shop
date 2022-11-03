package com.solutions.shop.repository;

import com.solutions.shop.model.Customer;
import com.solutions.shop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCustomerCreate() {
        User user1 = new User(998,"test-logon", "test-passw");
        entityManager.persist(user1);

        Customer testCustomer1 = new Customer(998, "Customer1",
                "testLastName", "Polesskaya 8");
        entityManager.persist(testCustomer1);

        entityManager.flush();
    }
}
