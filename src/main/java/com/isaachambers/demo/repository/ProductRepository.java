package com.isaachambers.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.isaachambers.demo.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByAmountLessThan(double amount);
    @Query(value = "{suppliers: {$elemMatch: {'name':?0}}}")
    List<Product> findBySupplierName(String supplierName);
}
