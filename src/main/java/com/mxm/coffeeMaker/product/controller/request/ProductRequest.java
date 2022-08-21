package com.mxm.coffeeMaker.product.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private String name;

    @NotNull
    @DecimalMin("0.00")
    @Digits(integer = 2, fraction = 2)
    private BigDecimal price;
}
