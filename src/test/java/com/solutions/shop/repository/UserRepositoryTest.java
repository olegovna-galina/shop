package com.solutions.shop.repository;

import com.solutions.shop.model.Customer;
import com.solutions.shop.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    /* New User for all Tests */
    User user1 = new User(998,"test-logon", "test-passw");
    
    @Test
    public void testUserCreate() {
        entityManager.persist(user1);
        entityManager.flush();
        System.out.println(user1);
    }

    @Test
    public void testUserRead() {
        entityManager.persist(user1);
        entityManager.flush();

        User result = entityManager.find(User.class, 998);
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testUserUpdate() {
        entityManager.persist(user1);
        entityManager.flush();

        user1.setPassword("newPassword");
        System.out.println(user1);
    }

    @Test
    public void testUserDelete() {
        Customer testCustomer1 = new Customer(998, user1,"Customer1",
                "testLastName", "Polesskaya 8");
        entityManager.persist(user1);
        entityManager.persist(testCustomer1);
        entityManager.flush();
        entityManager.clear(); // all previously managed entities are now detached

        User same = entityManager.find(User.class, 998);
        entityManager.remove(same); // ?? I don't see Delete-Operation
    }
}
