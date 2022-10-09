package com.solutions.shop;

import com.solutions.shop.hibernateUtil.HibernateUtil;
import com.solutions.shop.model.User;

import org.hibernate.*;
import org.junit.jupiter.api.*;

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
    public void testCreate() {
        System.out.println("Running testCreate...");

        session.beginTransaction();

        User user = new User(99,"test-logon", "test-passw");
        Integer id = (Integer) session.save(user);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }
}
