package com.mxm.coffeeMaker.order.repo;


import com.mxm.coffeeMaker.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
