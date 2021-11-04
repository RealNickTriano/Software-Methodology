package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public abstract class Pizza {
    protected  ArrayList<Toppings> toppings = new ArrayList<Toppings>();
    protected Size size;
    public abstract double price();
}
