package Project4;

import java.util.ArrayList;

/**
 * Subclass of Pizza contains overridden price method and toString method
 * Instantiated when user orders a Pepperoni pizza
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Pepperoni extends Pizza{

    /**
     * Method to calculate price of Pepperoni pizza based on size and toppings
     * @return price the price of the pizza
     */
    @Override
    public double price() {
        if (this.size == Size.Small) {
            if (this.toppings.size() > Constants.PEPPERONI_TOPPINGS) {
                return Constants.SMALL_PEPPERONI + (Constants.ADD_TOPPING * (toppings.size() - Constants.PEPPERONI_TOPPINGS));
            }
            else {
                return Constants.SMALL_PEPPERONI;
            }
        }
        else if (this.size == Size.Medium) {
            if (this.toppings.size() > Constants.PEPPERONI_TOPPINGS) {
                return Constants.SMALL_PEPPERONI + Constants.SIZE_CHANGE + (Constants.ADD_TOPPING * (toppings.size() - Constants.PEPPERONI_TOPPINGS));
            }
            else {
                return Constants.SMALL_PEPPERONI + Constants.SIZE_CHANGE;
            }
        }
        else {
            if (this.toppings.size() > Constants.PEPPERONI_TOPPINGS) {
                return Constants.SMALL_PEPPERONI + (2 * Constants.SIZE_CHANGE) + (Constants.ADD_TOPPING * (toppings.size() - Constants.PEPPERONI_TOPPINGS));
            }
            else {
                return Constants.SMALL_PEPPERONI + (2 * Constants.SIZE_CHANGE);
            }
        }
    }

    /**
     * Creates string from Pepperoni object with toppings and size
     * @return formattedString the Pepperoni object in string form
     */
    @Override
    public String toString()
    {
        String formattedString;

        formattedString = "Pepperoni pizza, ";

        for(int i = 0; i < toppings.size(); i++)
        {
            formattedString = formattedString.concat(toppings.get(i).toString() + ", ");
        }

        formattedString = formattedString.concat(String.format("%s, $" + "%.2f", size, price()));

        return formattedString;
    }
}
