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
    private ArrayList<Pizza> orderList;

    public Order(String phoneNumber, ArrayList<Pizza> orderList) {
        this.phoneNumber = phoneNumber;
        this.orderList = orderList;
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
    public ArrayList<Pizza> getOrderList() {
        return orderList;
    }

    /**
     * Adds a Pizza to the customer's order
     * @param pizza the pizza to add
     * @return true if pizza is successfully added, false if not
     */
    public boolean addToOrder(Pizza pizza) {
        if (orderList.size() > 7) {
            return false;
        }
        return orderList.add(pizza);
    }

    /**
     * Removes a pizza from the customer's order
     * @param pizza the pizza to remove
     * @return true if pizza is successfully removed, false if not
     */
    public boolean removeFromOrder(Pizza pizza) {
        if (orderList.size() == 0) {
            return false;
        }
        return orderList.remove(pizza);
    }
}
