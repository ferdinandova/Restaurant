package com.company;

import java.math.BigDecimal;
import java.util.*;

public class Menu {
    private final Set<MealType> meals;
    private final Set<DrinkType> drinks;

    public Menu(Set<MealType> meals, Set<DrinkType> drinks) {
        this.meals = meals;
        this.drinks = drinks;
    }

    public Menu() {
        this.meals = new HashSet<>();
        meals.addAll(Arrays.asList(MealType.values()));
        this.drinks = new HashSet<>();
        drinks.addAll(Arrays.asList(DrinkType.values()));
    }

    public Menu getClientMenu(ClientType clientType) {
        if (clientType == ClientType.STUDENT) {
            return getStudentMenu();
        } else if (clientType == ClientType.VEGAN) {
            return getVeganMenu();
        } else if (clientType == ClientType.BISSNESSMAN) {
            return getBusinessmanMenu();
        }
        throw new InvalidClientTypeException("Invalid client type - " + clientType);
    }

    private Menu getBusinessmanMenu() {
        Set<DrinkType> drinks = new HashSet<>();
        drinks.add(DrinkType.ALCOHOL);

        Set<MealType> meals = new HashSet<>();
        meals.add(MealType.MAIN);
        return new Menu(meals, drinks);
    }

    private Menu getStudentMenu() {
        return this;
    }

    private Menu getVeganMenu() {
        Set<DrinkType> drinks = new HashSet<>();
        drinks.add(DrinkType.NON_ALCOHOL);

        Set<MealType> meals = new HashSet<>();
        meals.add(MealType.SALAD);
        return new Menu(meals, drinks);
    }

    public List<DrinkType> getDrinks() {
        return new ArrayList<>(drinks);
    }

    public List<MealType> getMeals() {
        return new ArrayList<>(meals);
    }

    public BigDecimal getPrice(MealType mealType) {
        if (mealType == MealType.SALAD) {
            return BigDecimal.valueOf(5);
        } else if (mealType == MealType.DESSERT) {
            return BigDecimal.valueOf(4);
        } else if (mealType == MealType.MAIN) {
            return BigDecimal.valueOf(9);
        }
        throw new RuntimeException("Invalid type");
    }

    public BigDecimal getPrice(DrinkType drink) {
        if (drink == DrinkType.ALCOHOL) {
            return BigDecimal.valueOf(5);
        }
        throw new RuntimeException("Invalid type");
    }
}

