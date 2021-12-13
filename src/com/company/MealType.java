package com.company;

import java.math.BigDecimal;

public enum MealType {
    MAIN("MAIN",BigDecimal.valueOf(9)),
    DESSERT("DESSERT",BigDecimal.valueOf(4)),
    SALAD("SALAD", BigDecimal.valueOf(5));

    private final String name;
    private final BigDecimal price;

    MealType(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
