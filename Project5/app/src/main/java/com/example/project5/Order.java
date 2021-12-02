package com.example.project5;

import java.util.ArrayList;

/**
 * Used to create an Order containing customer phone number and an arraylist of pizzas
 * An instance of this class has a unique phone number and keeps the list of instances of Pizza class
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Order {

    private String phoneNumber;
    private ArrayList<Pizza> pizzaList;

    /**
     * Constructor for Order class, creates a new Order object with given parameters
     *
     * @param phoneNumber the phone number of the customer
     */
    public Order(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.pizzaList = new ArrayList<>();
    }

    /**
     * Sets the phone number for the order
     *
     * @param phoneNumber the customer's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Allows other classes to access the customer's phone number
     *
     * @return the customer's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Allows other classes to access the customer's order list
     *
     * @return the customer's order list
     */
    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    /**
     * Adds a Pizza to the customer's order
     *
     * @param pizza the pizza to add
     * @return true if pizza is successfully added, false if not
     */
    public boolean addToOrder(Pizza pizza) {
        return pizzaList.add(pizza);
    }

    /**
     * Removes a pizza from the customer's order
     *
     * @param pizza the pizza to remove
     * @return true if pizza is successfully removed, false if not
     */
    public boolean removeFromOrder(Pizza pizza) {
        return pizzaList.remove(pizza);
    }

    /**
     * Allows other classes to get the total of an order
     *
     * @return the total cost of the order
     */
    public double getTotal() {
        double total = 0;
        int i;
        for (i = 0; i < pizzaList.size(); i++) {
            total += pizzaList.get(i).price();
        }
        total += total * Constants.TAX_RATE;
        return Math.round(total * 100.0) / 100.0;
    }


}
