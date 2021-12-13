package com.company;

import java.math.BigDecimal;
import java.util.*;

public class Restaurant {
    private final String name;
    private final String address;
    private BigDecimal money;
    private Menu menu;
    private final List<Waiter> waiters;

    private Map<MealType, List<Meal>> meals;
    private Map<DrinkType, List<Drink>> drinks;

    public Restaurant(String name, String address, BigDecimal money) {
        this.name = name;
        this.address = address;
        this.money = money;
        this.waiters = new ArrayList<>();
        loadProducts();
    }

    private void loadProducts() {
        this.meals = new HashMap<>();
        meals.put(MealType.SALAD, new ArrayList<>());
        meals.put(MealType.MAIN, new ArrayList<>());
        meals.put(MealType.DESSERT, new ArrayList<>());
        this.drinks = new HashMap<>();
        drinks.put(DrinkType.NON_ALCOHOL, new ArrayList<>());
        drinks.put(DrinkType.ALCOHOL, new ArrayList<>());

        for (int i = 1; i <= 10; i++) {
            meals.get(MealType.SALAD).add(new Meal(MealType.SALAD));
            meals.get(MealType.MAIN).add(new Meal(MealType.MAIN));
            meals.get(MealType.DESSERT).add(new Meal(MealType.DESSERT));
        }

        for (int i = 1; i <= 20; i++) {
            drinks.get(DrinkType.NON_ALCOHOL).add(new Drink(DrinkType.NON_ALCOHOL));
            drinks.get(DrinkType.ALCOHOL).add(new Drink(DrinkType.ALCOHOL));
        }
    }

    public void addMenu(Menu menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Menu getMenu() {
        return menu;
    }

    public Waiter getWaiter() {
        return waiters.get(RandomUtil.getRandomInt(waiters.size()));
    }

    public Menu getClientMenu(ClientType clientType) {
        return menu.getClientMenu(clientType);
    }

    public void order(List<MealType> clientMeals, List<DrinkType> clientDrinks) throws ProductNotAvailableException {
        for (MealType mealType : clientMeals) {
            boolean isEmpty = this.meals.get(mealType).isEmpty();
            if (!isEmpty) {
                List<Meal> mealsList = this.meals.get(mealType);
                mealsList.remove(mealsList.size() - 1);
            } else {
                throw new ProductNotAvailableException(mealType + " is not available.");
            }
        }
        for (DrinkType drinkType : clientDrinks) {
            boolean isEmpty = this.drinks.get(drinkType).isEmpty();
            if (!isEmpty) {
                List<Drink> drinksList = this.drinks.get(drinkType);
                drinksList.remove(drinksList.size() - 1);
            } else {
                throw new ProductNotAvailableException(drinkType + " is not available.");
            }
        }
    }

    public void payBill(BigDecimal bill) {
        if (bill.compareTo(BigDecimal.ZERO) > 0) {
            money = money.add(bill);
        }
    }

    public void addWaiter(Waiter waiter) {
        this.waiters.add(waiter);
    }

    public TreeSet<Waiter> getWaiterOrderByTips() {
        TreeSet<Waiter> waitersSorted = new TreeSet<>(Comparator.comparing(Waiter::getTip));
        waitersSorted.addAll(waiters);
        return waitersSorted;
    }

    public void printAvailableProducts() {
        for (Map.Entry<MealType, List<Meal>> entry : this.meals.entrySet()) {
            System.out.println(entry.getKey().getName() + " count = " + entry.getValue().size());
        }
        for (Map.Entry<DrinkType, List<Drink>> entry : this.drinks.entrySet()) {
            System.out.println(entry.getKey().getName() + " count = " + entry.getValue().size());
        }
    }
}
