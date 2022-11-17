package com.solutions.shop.DAO;

import com.solutions.shop.DAO.JpaCustomerDao;
import com.solutions.shop.model.Customer;
import com.solutions.shop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class CustomerDaoTest {

    private JpaCustomerDao jpaCustomerDao = new JpaCustomerDao();

    /* New User and Customer for all Tests */
    User user1 = new User(998,"test-logon", "test-passw");
    Customer testCustomer1 = new Customer(998, user1,"Customer1",
            "testLastName", "Polesskaya 8");

    @Test
    public void testCustomerCreate() {
        jpaCustomerDao.save(testCustomer1);
    }
}
