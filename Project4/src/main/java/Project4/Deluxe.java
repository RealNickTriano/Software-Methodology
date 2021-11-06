package Project4;

import java.util.ArrayList;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Deluxe extends Pizza{
    public Deluxe(ArrayList<Toppings> toppings, Size size) {
        super(toppings, size);
    }

    @Override
    public double price() {
        if (this.size == Size.small) {
            if (this.toppings.size() > Constants.DELUXE_TOPPINGS) {
                return Constants.SMALL_DELUXE + (Constants.ADD_TOPPING * (toppings.size() - Constants.DELUXE_TOPPINGS));
            }
            else {
                return Constants.SMALL_DELUXE;
            }
        }
        else if (this.size == Size.medium) {
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
