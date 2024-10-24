package com.goraaa.test_app.controller;

import com.goraaa.test_app.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/api/v1/carts" )
public class CartController {
    List<Product> productList = new ArrayList<>();

    CartController() {
        productList.add(new Product(1, "Apple", 1000, "Buah yang sangat enak"));
        productList.add(new Product(2, "Durian", 1000, "Buah yang sangat bau"));
    }
    @GetMapping
    public ResponseEntity<List<Product>> getCart() {
         return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
