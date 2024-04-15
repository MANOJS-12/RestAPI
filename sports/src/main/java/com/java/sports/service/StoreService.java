package com.java.sports.service;

import java.util.List;
import com.java.sports.model.Product;
import com.java.sports.model.Store;


public interface StoreService {
    List<Store> getAllStores(int page, int size, String sortBy);

    Store getStoreById(Long id);

    Store createStore(Store store);

    Store updateStore(Long id, Store store);

    void deleteStore(Long id);

    List<Store> getStoresByProduct(Product product, int page, int size, String sortBy);
}