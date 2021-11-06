package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class StoreOrders {
    // TODO: An instance of this class keeps the list of orders placed by the user
    private ArrayList<Order>  storeOrdersList;

    public StoreOrders(ArrayList<Order> storeOrdersList) {
        this.storeOrdersList = storeOrdersList;
    }

    // TODO: export() method in this class to save the store orders
    //    // to and external txt file
    public boolean export()
    {
        return false;
    }

    /**
     * Adds an order to the list of all orders in the store
     * @param order the order to add
     * @return true if the order is successfully added, false if not
     */
    public boolean addToStoreOrder(Order order) {
        if (storeOrdersList.size() > 7) {
            return false;
        }
        return storeOrdersList.add(order);
    }

    /**
     * Removes an order to the list of all orders in the store
     * @param order the order to remove
     * @return true if the order is successfully removed, false if not
     */
    public boolean removeFromStoreOrder(Order order) {
        if (storeOrdersList.size() == 0) {
            return false;
        }
        return storeOrdersList.remove(order);
    }
}
