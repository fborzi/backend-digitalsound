package com.digitalsound.paginaweb.controllers;


import com.digitalsound.paginaweb.dto.Message;
import com.digitalsound.paginaweb.dto.ProductDto;
import com.digitalsound.paginaweb.models.Product;
import com.digitalsound.paginaweb.services.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> list(){
        List<Product> list = productService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Product> getById(@PathVariable ("id") int id){
        if(!productService.existsById(id)){
            return new ResponseEntity(new Message("El producto no existe"), HttpStatus.NOT_FOUND);
        }
        Product product = productService.getOne(id).get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/details-name/{name}")
    public ResponseEntity<Product> getByName(@PathVariable ("name") String name){
        List<Product> products = productService.findByName(name);
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto){
        if(StringUtils.isBlank(productDto.getName())){
            return new ResponseEntity(new Message("El nombre del producto es requerido"), HttpStatus.BAD_REQUEST);
        }
        if(productDto.getPrice() == null || productDto.getPrice() <= 0){
            return new ResponseEntity(new Message("El precio del producto es requerido"), HttpStatus.BAD_REQUEST);
        }
        if(productService.existsByName(productDto.getName())){
            return new ResponseEntity(new Message("El producto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Product product = new Product(
                productDto.getCategory(),
                productDto.getSubcategory(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getImage(),
                productDto.getStock(),
                productDto.isActive());
        productService.save(product);
        return new ResponseEntity(new Message("Producto creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") Integer id, @RequestBody ProductDto productDto){
        if(!productService.existsById(id)){
            return new ResponseEntity(new Message("El producto no existe"), HttpStatus.NOT_FOUND);
        }
        if(productService.existsByName(productDto.getName()) && productService.getByName(productDto.getName()).get().getId() != id){
            return new ResponseEntity(new Message("El producto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(productDto.getName())){
            return new ResponseEntity(new Message("El nombre del producto es requerido"), HttpStatus.BAD_REQUEST);
        }
        if(productDto.getPrice() == null || productDto.getPrice() < 0){
            return new ResponseEntity(new Message("El precio debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        }

        Product product = productService.getOne(id).get();
        //product.setCategory(productDto.getCategory());
        //product.setSubCategory(productDto.getSubCategory());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        //product.setProductImage(productDto.getProductImage());
        product.setStock(productDto.getStock());
        product.setActive(productDto.isActive());
        productService.save(product);
        return new ResponseEntity(new Message("Producto actualizado"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Integer id){
        if(!productService.existsById(id)){
            return new ResponseEntity(new Message("El producto no existe"), HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity(new Message("Producto eliminado"), HttpStatus.OK);
    }

}
