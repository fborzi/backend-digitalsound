package com.digitalsound.paginaweb.services;

import com.digitalsound.paginaweb.models.Product;
import com.digitalsound.paginaweb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Optional<Product> getOne(Integer id) {
        return productRepository.findById(id);
    }

    public Optional<Product> getByName(String name) {
        return productRepository.findByName(name);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public void update(Integer id, Product product) {
        productRepository.save(product);
    }

    public boolean existsById(Integer id) {
        return productRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
