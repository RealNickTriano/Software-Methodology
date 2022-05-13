package Project4;

/**
 * Subclass of Pizza contains overridden price method and toString method
 * Instantiated when user orders a Hawaiian pizza
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Hawaiian extends Pizza{

    /**
     * Method to calculate price of Hawaiian pizza based on size and toppings
     * @return price the price of the pizza
     */
    @Override
    public double price() {
        if (this.size == Size.Small) {
            if (this.toppings.size() > Constants.HAWAIIAN_TOPPINGS) {
                return Constants.SMALL_HAWAIIAN + (Constants.ADD_TOPPING * (toppings.size() - Constants.HAWAIIAN_TOPPINGS));
            }
            else {
                return Constants.SMALL_HAWAIIAN;
            }
        }
        else if (this.size == Size.Medium) {
            if (this.toppings.size() > Constants.HAWAIIAN_TOPPINGS) {
                return Constants.SMALL_HAWAIIAN + Constants.SIZE_CHANGE + (Constants.ADD_TOPPING * (toppings.size() - Constants.HAWAIIAN_TOPPINGS));
            }
            else {
                return Constants.SMALL_HAWAIIAN + Constants.SIZE_CHANGE;
            }
        }
        else {
            if (this.toppings.size() > Constants.HAWAIIAN_TOPPINGS) {
                return Constants.SMALL_HAWAIIAN + (2 * Constants.SIZE_CHANGE) + (Constants.ADD_TOPPING * (toppings.size() - Constants.HAWAIIAN_TOPPINGS));
            }
            else {
                return Constants.SMALL_HAWAIIAN + (2 * Constants.SIZE_CHANGE);
            }
        }
    }

    /**
     * Creates string from Hawaiian object with toppings and size
     * @return formattedString the Hawaiian object in string form
     */
    @Override
    public String toString()
    {
        String formattedString;

        formattedString = "Hawaiian pizza, ";

        for(int i = 0; i < toppings.size(); i++)
        {
            formattedString = formattedString.concat(toppings.get(i).toString() + ", ");
        }

        formattedString = formattedString.concat(String.format("%s, $" + "%.2f", size, price()));

        return formattedString;
    }
}
