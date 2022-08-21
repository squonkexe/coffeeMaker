package com.mxm.coffeeMaker.order.controller.request;

import com.mxm.coffeeMaker.order.dto.OrderItemDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class OrderRequest {

    @NotNull
    @NotEmpty
    List<OrderItemDto> orderItems;
}
