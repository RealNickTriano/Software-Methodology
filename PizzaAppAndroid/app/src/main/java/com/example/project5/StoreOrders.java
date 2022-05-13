package com.example.project5;

import java.util.ArrayList;

/**
 * Used to create a Store Order containing an arraylist of Orders
 * An instance of this class keeps the list of orders placed by the user
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class StoreOrders {
    private ArrayList<Order> storeOrdersList;

    /**
     * Constructor for StoreOrders class, creates a new StoreOrder object with given parameters
     *
     * @param storeOrdersList the arraylist of Orders
     */
    public StoreOrders(ArrayList<Order> storeOrdersList) {
        this.storeOrdersList = storeOrdersList;
    }

    /**
     * Adds an order to the list of all orders in the store
     *
     * @param order the order to add
     * @return true if the order is successfully added, false if not
     */
    public boolean addToStoreOrders(Order order) {
        return storeOrdersList.add(order);
    }

    /**
     * Removes an order to the list of all orders in the store
     *
     * @param order the order to remove
     * @return true if the order is successfully removed, false if not
     */
    public boolean removeFromStoreOrders(Order order) {
        return storeOrdersList.remove(order);
    }

    /**
     * Allows other classes to access the list of store orders
     *
     * @return the list of store orders
     */
    public ArrayList<Order> getStoreOrdersList() {
        return storeOrdersList;
    }

    /**
     * Allows other classes to access the size of store orders
     *
     * @return the size of the array list of orders
     */
    public int getSize() { return storeOrdersList.size();}
}
