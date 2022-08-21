package com.mxm.coffeeMaker.order.repo;

import com.mxm.coffeeMaker.order.model.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItem persist(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public Iterable<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }
}
