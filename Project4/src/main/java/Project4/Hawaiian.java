package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Hawaiian extends Pizza{

    @Override
    public double price() {
        if (this.size == Size.small) {
            if (this.toppings.size() > Constants.HAWAIIAN_TOPPINGS) {
                return Constants.SMALL_HAWAIIAN + (Constants.ADD_TOPPING * (toppings.size() - Constants.HAWAIIAN_TOPPINGS));
            }
            else {
                return Constants.SMALL_HAWAIIAN;
            }
        }
        else if (this.size == Size.medium) {
            if (this.toppings.size() > Constants.HAWAIIAN_TOPPINGS) {
                return Constants.SMALL_HAWAIIAN + Constants.SIZE_CHANGE + (Constants.ADD_TOPPING * (toppings.size() - Constants.HAWAIIAN_TOPPINGS));
            }
            else {
                return Constants.SMALL_HAWAIIAN + Constants.SIZE_CHANGE;
            }
        }
        else {
            if (this.toppings.size() > Constants.DELUXE_TOPPINGS) {
                return Constants.SMALL_HAWAIIAN + (2 * Constants.SIZE_CHANGE) + (Constants.ADD_TOPPING * (toppings.size() - Constants.HAWAIIAN_TOPPINGS));
            }
            else {
                return Constants.SMALL_HAWAIIAN + (2 * Constants.SIZE_CHANGE);
            }
        }
    }
}
