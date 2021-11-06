package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public abstract class Pizza {
    protected  ArrayList<Toppings> toppings = new ArrayList<Toppings>();
    protected Size size;
    public abstract double price();

    public Pizza(ArrayList<Toppings> toppings, Size size) {
        this.toppings = toppings;
        this.size = size;
    }

    /**
     * Sets the size of a pizza
     * @param size the new size of the pizza
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Allows other classes to access the size of a pizza
     * @return the size of the pizza
     */
    public Size getSize() {
        return this.size;
    }

    public ArrayList<Toppings> getToppings()
    {
        return toppings;
    }

    /**
     * Adds a topping to the pizza
     * @param topping the topping to add
     * @return true if topping is successfully added, false if not
     */
    public boolean addTopping(Toppings topping) {
        if (toppings.size() > 7) {
            return false;
        }
        return toppings.add(topping);
    }

    /**
     * Removes a topping from the pizza
     * @param topping the topping to remove
     * @return true if topping is successfully removed, false if not
     */
    public boolean removeTopping(Toppings topping) {
        if (toppings.size() == 0) {
            return false;
        }
        return toppings.remove(topping);
    }
}


