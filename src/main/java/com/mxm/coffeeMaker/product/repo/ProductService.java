package com.mxm.coffeeMaker.product.repo;


import com.mxm.coffeeMaker.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Product persist(String name, BigDecimal price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productRepository.save(product);
        return product;
    }
}
