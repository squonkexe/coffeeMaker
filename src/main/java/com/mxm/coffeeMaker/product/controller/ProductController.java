package com.mxm.coffeeMaker.product.controller;

import com.mxm.coffeeMaker.product.controller.request.ProductRequest;
import com.mxm.coffeeMaker.product.repo.ProductService;
import com.mxm.coffeeMaker.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Iterable<Product> getAll() {
        return productService.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductRequest productRequest) {
        Product persitedProduct = productService.persist(productRequest.getName(), productRequest.getPrice());

        return ResponseEntity.status(HttpStatus.CREATED).body(persitedProduct);
    }
}
