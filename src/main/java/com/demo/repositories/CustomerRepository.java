package com.demo.repositories;


import com.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<List<Customer>> findByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE from Customer WHERE name = ?1")
    void deleteByName(String name);
}
