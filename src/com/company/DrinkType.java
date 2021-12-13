package com.company;

import java.math.BigDecimal;

public enum DrinkType {
    NON_ALCOHOL("NON_ALCOHOL", BigDecimal.valueOf(4)),
    ALCOHOL("ALCOHOL", BigDecimal.valueOf(4));

    private final String name;
    private final BigDecimal price;

    DrinkType(String name, BigDecimal price) {
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
