package com.digitalsound.paginaweb.repositories;

import com.digitalsound.paginaweb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String name);
    boolean existsByName(String name);

    //Spring realizara una consulta SQL similar a: SELECT * FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')
    List<Product> findByNameContaining(@RequestParam("name") String name);
}

