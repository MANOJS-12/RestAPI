package com.java.sports.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.java.sports.model.Product;
import com.java.sports.model.Store;



public interface StoreRepository extends JpaRepository<Store, Long> {
    Page<Store> findByProduct(Product product, Pageable pageable);

}