package com.goraaa.test_app.controller;

import com.goraaa.test_app.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    List<Product> productList = new ArrayList<>();

    ProductController() {
        productList.add(new Product(1, "Apple", 1000, "Buah yang sangat enak"));
        productList.add(new Product(2, "Durian", 1000, "Buah yang sangat bau"));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = null;
        for (Product item : productList) {
            if (item.getId() == id) {
                product = item;
                break;
            }
        }
        if (product == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
