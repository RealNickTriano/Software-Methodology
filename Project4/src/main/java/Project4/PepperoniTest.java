package Project4;


import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class PepperoniTest {

    @Test
    public void testPepperoni()
    {
        Pizza pizza = PizzaMaker.createPizza("Pepperoni");
        pizza.addTopping(Toppings.Pepperoni);

        // test case #1, Small pizza with no added toppings should be 8.99
        pizza.setSize(Size.Small);
        Assertions.assertTrue(pizza.price() == 8.99);

        // test case #2, Adding toppings added should increase the price by 1.49 each topping
        pizza.addTopping(Toppings.Beef);
        pizza.addTopping(Toppings.Sausage);
        Assertions.assertTrue(pizza.price() == 11.97);

        // test case #3, Removing toppings added should decrease the price by 1.49 each topping
        pizza.removeTopping(Toppings.Beef);
        pizza.removeTopping(Toppings.Sausage);
        Assertions.assertTrue(pizza.price() == 8.99);

        // test case #4, Medium with no extra toppings should be 10.99
        pizza.setSize(Size.Medium);
        Assertions.assertTrue(pizza.price() == 10.99);

        // test case #5, Large with no extra toppings should be 12.99
        pizza.setSize(Size.Large);
        Assertions.assertTrue(pizza.price() == 12.99);

        // test case #6, Cannot add more than 7 toppings, price should stay the same after attempting to add more
        pizza.addTopping(Toppings.GreenPepper);
        pizza.addTopping(Toppings.Beef);
        pizza.addTopping(Toppings.BlackOlives);
        pizza.addTopping(Toppings.Sausage);
        pizza.addTopping(Toppings.Mushroom);
        pizza.addTopping(Toppings.Pineapple);
        double oldPrice = pizza.price();
        pizza.addTopping(Toppings.Chicken);
        Assertions.assertTrue(pizza.price() == oldPrice);

        // test case #7, going from large to small should reduce price by 4$
        pizza.setSize(Size.Small);
        Assertions.assertTrue((oldPrice - 4) == pizza.price());
        oldPrice = pizza.price();

        // test case #8, going from small to medium should increase price by 2$
        pizza.setSize(Size.Medium);
        Assertions.assertTrue(pizza.price() - 2 == oldPrice);
        

    }
}
