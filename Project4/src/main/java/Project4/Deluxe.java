package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Deluxe extends Pizza{

    @Override
    public double price() {
        if (this.size == Size.Small) {
            if (this.toppings.size() > Constants.DELUXE_TOPPINGS) {
                return Constants.SMALL_DELUXE + (Constants.ADD_TOPPING * (toppings.size() - Constants.DELUXE_TOPPINGS));
            }
            else {
                return Constants.SMALL_DELUXE;
            }
        }
        else if (this.size == Size.Medium) {
            if (this.toppings.size() > Constants.DELUXE_TOPPINGS) {
                return Constants.SMALL_DELUXE + Constants.SIZE_CHANGE + (Constants.ADD_TOPPING * (toppings.size() - Constants.DELUXE_TOPPINGS));
            }
            else {
                return Constants.SMALL_DELUXE + Constants.SIZE_CHANGE;
            }
        }
        else {
            if (this.toppings.size() > Constants.DELUXE_TOPPINGS) {
                return Constants.SMALL_DELUXE + (2 * Constants.SIZE_CHANGE) + (Constants.ADD_TOPPING * (toppings.size() - Constants.DELUXE_TOPPINGS));
            }
            else {
                return Constants.SMALL_DELUXE + (2 * Constants.SIZE_CHANGE);
            }
        }
    }
}
