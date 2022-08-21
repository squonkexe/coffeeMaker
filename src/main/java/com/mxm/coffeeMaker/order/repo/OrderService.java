package com.mxm.coffeeMaker.order.repo;

import com.mxm.coffeeMaker.order.model.Order;
import com.mxm.coffeeMaker.order.model.OrderItem;
import com.mxm.coffeeMaker.order.model.OrderState;
import com.mxm.coffeeMaker.order.controller.request.OrderRequest;
import com.mxm.coffeeMaker.order.dto.OrderItemDto;
import com.mxm.coffeeMaker.product.model.Product;
import com.mxm.coffeeMaker.product.repo.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order persist(OrderRequest orderRequest) {
        Order order = new Order();
        order.setState(OrderState.CREATED);

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDto orderItemDto : orderRequest.getOrderItems()) {
            Product product = productService.findByName(orderItemDto.getName()).orElseThrow(() -> new NoSuchElementException(orderItemDto.getName()));

            OrderItem orderItem = new OrderItem(product, order);
            orderItem.setAmount(orderItemDto.getAmount());

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        orderRepository.save(order);

        return order;
    }

    public BigDecimal getPrice(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.valueOf(id)));

        List<OrderItem> orderItemList = order.getOrderItems();
        BigDecimal totalAmount = new BigDecimal(0.00);
        for (OrderItem orderItem : orderItemList) {
            BigDecimal priceMultAmount = orderItem.getProductId().getPrice().multiply(new BigDecimal(orderItem.getAmount()));
            totalAmount = totalAmount.add(priceMultAmount);
        }

        return totalAmount;
    }

}
