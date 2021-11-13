package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Pepperoni extends Pizza{

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
