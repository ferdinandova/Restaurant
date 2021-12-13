package com.company;

import java.math.BigDecimal;

public class Meal {
    private String name;
    private BigDecimal price;
    private int size;
    private final MealType type;

    public Meal (MealType type) {

        this.type = type;
    }

    public void setPrice(MealType type) {
        if(type == MealType.MAIN) {
            price = BigDecimal.valueOf(9);
            this.size = RandomUtil.getRandomInt(400,800);
        } else if (type == MealType.SALAD) {
            price = BigDecimal.valueOf(5);
            this.size = RandomUtil.getRandomInt(300,600);
        } else if(type == MealType.DESSERT) {
            price = BigDecimal.valueOf(4);
            this.size = RandomUtil.getRandomInt(200,300);
        } else {
            throw new RuntimeException("Invalid product type.");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public MealType getType() {
        return type;
    }
}
