package Project4;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
// TODO: create an instance of subclasses based on the chosen flavor
public class PizzaMaker {
    public static Pizza createPizza(String flavor){
        // TODO: write the code for creating different instances of subtypes of pizza

        if (flavor.equalsIgnoreCase("Hawaiian"))
        {
            // make hawaiian pizza
            Hawaiian pizza = new Hawaiian()
        }
        else if (flavor.equalsIgnoreCase("Deluxe"))
        {
            // make Deluxe pizza
        }
        else if (flavor.equalsIgnoreCase("Pepperoni"))
        {
            // make Pepperoni pizza
        }

        return newPizza;
    }
}
