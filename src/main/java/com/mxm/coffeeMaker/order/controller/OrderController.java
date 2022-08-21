package com.mxm.coffeeMaker.order.controller;

import com.mxm.coffeeMaker.order.repo.OrderItemService;
import com.mxm.coffeeMaker.order.repo.OrderService;
import com.mxm.coffeeMaker.order.model.Order;
import com.mxm.coffeeMaker.order.controller.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderItemService orderItemService;
    private final OrderService orderService;

    @GetMapping
    public Iterable<Order> getAll() {
        return orderService.findAll();
    }

    @PostMapping
    public ResponseEntity<Order> create(@Valid @RequestBody OrderRequest orderRequest) {
        Order persitedOrder = orderService.persist(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(persitedOrder);
    }

    @GetMapping("/getPrice/{id}")
    public ResponseEntity<BigDecimal> getPrice(@Valid @PathVariable Long id) {
        BigDecimal price = orderService.getPrice(id);
        return ResponseEntity.status(HttpStatus.OK).body(price);
    }
}
