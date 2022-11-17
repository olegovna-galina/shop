package com.solutions.shop.DAO;

import com.solutions.shop.model.Customer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class JpaCustomerDao implements Dao<Customer>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Customer> get(Integer id) {
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }

    @Override
    public List<Customer> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM customer e");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    @Transactional
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }
}
