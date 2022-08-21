package com.mxm.coffeeMaker.order.repo;


import com.mxm.coffeeMaker.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<Order, Long> {
}
