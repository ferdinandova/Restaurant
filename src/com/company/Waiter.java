package com.company;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Waiter {
    private final String name;
    private BigDecimal tip;
    private final Restaurant restaurant;
    Map <Client,BigDecimal> clients;

    public Waiter(String name, Restaurant restaurant) {
        this.name = name;
        this.tip = BigDecimal.ZERO;
        this.restaurant = restaurant;
        this.clients = new HashMap<>();
    }

    public void order(Client client, List<MealType> meals, List<DrinkType> drinks) throws ProductNotAvailableException {
        restaurant.order(meals, drinks);
        BigDecimal bill = BigDecimal.valueOf(0);
        for(MealType type: meals) {
            bill = bill.add(type.getPrice());
        }
        for(DrinkType type: drinks) {
            bill = bill.add(type.getPrice());
        }
        if (clients.get(client) == null) {
            clients.put(client, bill);
        } else {
            BigDecimal currentBill = clients.get(client);
            clients.put(client, bill.add(currentBill));
        }
    }
    public String getName() {
        return name;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Menu getMenuByClientType(ClientType clientType) {
        return restaurant.getClientMenu(clientType);
    }

    public BigDecimal getBill(Client client) {
        return clients.get(client);
    }

    public void payBill(BigDecimal bill, Client client) {

        BigDecimal clientBill =  clients.get(client);
        BigDecimal tip = bill.subtract(clientBill);
        this.tip = this.tip.add(tip);
        restaurant.payBill(bill.subtract(tip));
        clients.remove(client);

    }

    @Override
    public String toString() {
        return name + " - " + tip + "; ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return name.equals(waiter.name) && tip.equals(waiter.tip) && restaurant.equals(waiter.restaurant) && Objects.equals(clients, waiter.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tip, restaurant, clients);
    }
}
