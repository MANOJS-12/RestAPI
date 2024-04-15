package com.java.sports.service;

import com.java.sports.model.Product;
import com.java.sports.model.Store;
import com.java.sports.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, org.springframework.data.domain.Sort.by(sortBy));
        Page<Store> stores = storeRepository.findAll(pageable);
        return stores.getContent();
    }

    @Override
    public Store getStoreById(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        return store.orElse(null);
    }

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store updateStore(Long id, Store store) {
        Optional<Store> existingStore = storeRepository.findById(id);
        if (existingStore.isPresent()) {
            Store updatedStore = existingStore.get();
            updatedStore.setName(store.getName());
            updatedStore.setDescription(store.getDescription());
            updatedStore.setAddress(store.getAddress());
            updatedStore.setProduct(store.getProduct());
            return storeRepository.save(updatedStore);
        }
        return null;
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    @Override
    public List<Store> getStoresByProduct(Product product, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, org.springframework.data.domain.Sort.by(sortBy));
        Page<Store> stores = storeRepository.findByProduct(product, pageable);
        return stores.getContent();
    }
}
