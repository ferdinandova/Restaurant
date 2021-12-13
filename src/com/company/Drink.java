package com.company;

import java.math.BigDecimal;

public class Drink {
    private String name;
    private BigDecimal price;
    private DrinkType type;

    public Drink (DrinkType type) {
       setType(type);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }
}
