package com.example.project5;

/**
 * Creates an instance of subclasses based on the chosen flavor
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class PizzaMaker {
    /**
     * Static method used to create instances of Pizza subclasses
     *
     * @param flavor flavor of pizza
     * @return A subclass of pizza based on flavor parameter
     */
    public static Pizza createPizza(String flavor) {

        if (flavor.equalsIgnoreCase("Hawaiian")) {
            // make hawaiian pizza
            Hawaiian pizza = new Hawaiian();
            return pizza;
        } else if (flavor.equalsIgnoreCase("Deluxe")) {
            // make Deluxe pizza
            Deluxe pizza = new Deluxe();
            return pizza;
        } else if (flavor.equalsIgnoreCase("Pepperoni")) {
            // make Pepperoni pizza
            Pepperoni pizza = new Pepperoni();
            return pizza;
        }

        return null;
    }
}
