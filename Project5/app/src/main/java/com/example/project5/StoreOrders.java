package com.example.project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
     * Saves the store orders to an external text file
     *
     * @return true on success, false on failure
     */
    public boolean export() {
        File file = new File("store_orders.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        int i, j;
        // iterate over each order
        for (i = 0; i < storeOrdersList.size(); i++) {
            Order currentOrder = storeOrdersList.get(i);
            String phone = currentOrder.getPhoneNumber();
            pw.print("Customer phone: " + phone + "\n");
            ArrayList<Pizza> pizzaList = currentOrder.getPizzaList();
            for (j = 0; j < pizzaList.size(); j++) {
                pw.print(pizzaList.get(j).toString() + "\n");
            }
            double total = currentOrder.getTotal();
            pw.print("Order total: $" + total + "\n");
            pw.print("*******************************\n");
        }
        pw.close();
        return true;
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
