package com.solutions.shop;

import com.solutions.shop.hibernateUtil.HibernateUtil;
import com.solutions.shop.model.User;

import org.hibernate.*;
import org.junit.jupiter.api.*;

import org.springframework.security.test.context.support.WithMockUser;

public class HibernateUtilUserTest {

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    @WithMockUser(username = "mock_user", password = "mock_psw") // see test application.properties
    public void testCreate() {
        System.out.println("Running testCreate...");

        session.beginTransaction();

        User user = new User(99,"test-logon", "test-passw");
        Integer id = (Integer) session.save(user);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    @WithMockUser(username = "mock_user", password = "mock_psw")
    public void testDelete() {
        System.out.println("Running testDelete...");

        Integer id = 99;
        User user = session.find(User.class, id);

        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();

        User deletedUser = session.find(User.class, id);

        Assertions.assertNull(deletedUser);
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed");
    }
}
