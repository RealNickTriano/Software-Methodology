package Project4;

/**
 * Subclass of Pizza contains overridden price method and toString method
 * Instantiated when user orders a Deluxe pizza
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Deluxe extends Pizza{

    /**
     * Method to calculate price of Deluxe pizza based on size and toppings
     * @return price the price of the pizza
     */
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

    /**
     * Creates string from Deluxe object with toppings and size
     * @return formattedString the Deluxe object in string form
     */
    @Override
    public String toString()
    {
        String formattedString;

        formattedString = "Deluxe pizza, ";

        for(int i = 0; i < toppings.size(); i++)
        {
            formattedString = formattedString.concat(toppings.get(i).toString() + ", ");
        }

        formattedString = formattedString.concat(String.format("%s, $" + "%.2f", size, price()));

        return formattedString;
    }
}
