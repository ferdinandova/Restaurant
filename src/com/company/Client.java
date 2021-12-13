package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    private final String name;
    private BigDecimal money;
    private Restaurant restaurant;
    private final ClientType type;
    private Waiter waiter;
    private BigDecimal bill;

    public Client(String name, Restaurant restaurant, ClientType type) {
        this.name = name;
        this.restaurant = restaurant;
        this.type = type;
        setMoney();
    }

    private void setMoney() {
        if (type == ClientType.STUDENT) {
            money = BigDecimal.valueOf(1000);
        } else if (type == ClientType.BISSNESSMAN) {
            money = BigDecimal.valueOf(5000);
        } else if (type == ClientType.VEGAN) {
            money = BigDecimal.valueOf(3000);
        } else {
            throw new RuntimeException("Invalid client type.");
        }
    }

    public Client(String name, BigDecimal money, ClientType type) {
        this.name = name;
        this.money = money;
        this.type = type;
    }

    public void makeOrder() throws ProductNotAvailableException, NotEnoughMoneyException {
        List<MealType> meals = new ArrayList<>();
        List<DrinkType> drinks = new ArrayList<>();
        Menu menu = restaurant.getMenu().getClientMenu(type);
        meals.add(menu.getMeals().get(RandomUtil.getRandomInt(menu.getMeals().size())));
        drinks.add(menu.getDrinks().get(RandomUtil.getRandomInt(menu.getDrinks().size())));

        BigDecimal totalAmount = BigDecimal.valueOf(0);
        for (MealType type : meals) {
            totalAmount = totalAmount.add(type.getPrice());
        }
        for (DrinkType type : drinks) {
            totalAmount = totalAmount.add(type.getPrice());
        }

        if (totalAmount.compareTo(money.multiply(BigDecimal.valueOf(0.9))) > 0) {
            throw new NotEnoughMoneyException("Your money are not enough.");
        }
        if (waiter == null) {
            waiter = restaurant.getWaiter();
        }
        waiter.order(this, meals, drinks);
    }

    public void getBill() {
        this.bill = waiter.getBill(this);
    }

    public void payBill() {
        int tipRandom = new Random().nextInt(11);
        BigDecimal moneyToGive;
        if (tipRandom > 8) {
            moneyToGive = bill;
        } else {
            int randomPercent = new Random().nextInt(5) + 5;
            BigDecimal tip = bill.multiply(BigDecimal.valueOf((double) randomPercent / 100));
            moneyToGive = tip.add(bill);
        }
        money = money.subtract(moneyToGive);
        waiter.payBill(moneyToGive, this);
        waiter = null;
    }


    public String getName() {
        return name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public ClientType getType() {
        return type;
    }


}
