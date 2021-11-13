package Project4;

import java.util.ArrayList;

/**
 *
 * @author Nicholas Triano, Antonio Ignarra
 */

public class Order {
    //TODO: An instance of this class has a unique phone number and keeps the list of instances
    // of Pizza class
    private String phoneNumber;
    private ArrayList<Pizza> pizzaList;

    public Order(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.pizzaList = new ArrayList<>();
    }

    /**
     * Sets the phone number for the order
     * @param phoneNumber the customer's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Allows other classes to access the customer's phone number
     * @return the customer's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Allows other classes to access the customer's order list
     * @return the customer's order list
     */
    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    /**
     * Adds a Pizza to the customer's order
     * @param pizza the pizza to add
     * @return true if pizza is successfully added, false if not
     */
    public boolean addToOrder(Pizza pizza) {
        return pizzaList.add(pizza);
    }

    /**
     * Removes a pizza from the customer's order
     * @param pizza the pizza to remove
     * @return true if pizza is successfully removed, false if not
     */
    public boolean removeFromOrder(Pizza pizza) {
        return pizzaList.remove(pizza);
    }


}
