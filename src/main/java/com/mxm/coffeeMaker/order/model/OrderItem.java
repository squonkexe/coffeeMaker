package com.mxm.coffeeMaker.order.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mxm.coffeeMaker.product.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {

     @Id
     @GeneratedValue
     @Column(name = "id")
     private long id;

     @ManyToOne
     @JoinColumn(name = "productId", nullable = false)
     private Product productId;

     @Column(name = "amount", nullable = false)
     private int amount;

     @JsonBackReference
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "orderId", nullable = false)
     private Order orderId;

     public OrderItem(Product product, Order order) {
          productId = product;
          orderId = order;
     }
}
