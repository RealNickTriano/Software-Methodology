package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Pepperoni extends Pizza{

    @Override
    public double price() {
        if (this.size == Size.small) {
            if (this.toppings.size() > Constants.PEPPERONI_TOPPINGS) {
                return Constants.SMALL_PEPPERONI + (Constants.ADD_TOPPING * (toppings.size() - Constants.PEPPERONI_TOPPINGS));
            }
            else {
                return Constants.SMALL_PEPPERONI;
            }
        }
        else if (this.size == Size.medium) {
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
}
