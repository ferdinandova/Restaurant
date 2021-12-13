package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Speedy", "Sofia", BigDecimal.valueOf(1000));
        restaurant.addMenu(new Menu());

        //create waiters
        Waiter waiter1=new Waiter("Ivan Ivanov", restaurant);
        Waiter waiter2=new Waiter("Ani Todorova", restaurant);
        Waiter waiter3=new Waiter("Toni Petrov", restaurant);
        Waiter waiter4=new Waiter("Georgi Popov", restaurant);
        Waiter waiter5=new Waiter("Neli Stoyanova", restaurant);

        //add waiters in restaurant
        restaurant.addWaiter(waiter1);
        restaurant.addWaiter(waiter2);
        restaurant.addWaiter(waiter3);
        restaurant.addWaiter(waiter4);
        restaurant.addWaiter(waiter5);


        //create clients
        Client client1 = new Client("Petya Ilieva", restaurant, ClientType.STUDENT);
        Client client2 = new Client("Polina Vasileva", restaurant, ClientType.VEGAN);
        Client client3 = new Client("Vasil Iliev", restaurant, ClientType.STUDENT);
        Client client4 = new Client("Boris Kostov", restaurant, ClientType.BISSNESSMAN);
        Client client5 = new Client("Kristiyan Georgiev", restaurant, ClientType.VEGAN);
        Client client6 = new Client("Elena Popova", restaurant, ClientType.STUDENT);
        Client client7 = new Client("Galiya Todorova", restaurant, ClientType.VEGAN);
        Client client8 = new Client("Milena Ivanova", restaurant, ClientType.VEGAN);
        Client client9 = new Client("Tsvetomira Toteva", restaurant, ClientType.BISSNESSMAN);
        Client client10 = new Client("Angel Angelov", restaurant, ClientType.BISSNESSMAN);


        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
        clients.add(client7);
        clients.add(client8);
        clients.add(client9);
        clients.add(client10);

        System.out.println("Money in the restaurant at the start of the day: " + restaurant.getMoney());

        for (int i = 0; i < 100; i++) {
            for(Client client : clients) {
                try {
                    client.makeOrder();
                    client.getBill();
                    client.payBill();
                } catch (ProductNotAvailableException | NotEnoughMoneyException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("Money in the restaurant at the end of the day: " + restaurant.getMoney());
        System.out.println("Waiters ordered by tips: " + restaurant.getWaiterOrderByTips());

        restaurant.printAvailableProducts();
    }
}
