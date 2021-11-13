package Project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainMenuController {
    @FXML
    private Button pepperoniButton;
    @FXML
    private Button deluxeButton;
    @FXML
    private Button hawaiianButton;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Button storeOrdersButton;
    @FXML
    private Button currentOrderButton;

    private  ArrayList<Toppings> allToppings = new ArrayList<>(
    Arrays.asList(
            Toppings.Chicken,
            Toppings.Beef,
            Toppings.Pepperoni,
            Toppings.GreenPepper,
            Toppings.Mushroom,
            Toppings.Pineapple,
            Toppings.Ham,
            Toppings.Cheese,
            Toppings.Sausage,
            Toppings.Onion,
            Toppings.BlackOlives));

    private String phone;
    protected Order order;
    protected boolean orderStarted = false;
    //public boolean orderStarted = false;

    public void handlePepperoniButton()
    {
        Pizza pizza = new Pepperoni();
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Pepperoni);
        if (!getPhone()) {
            System.out.println("Must enter a phone number.");
            return;
        }
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaCustomView.fxml"));
            root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 700);
            stage.setTitle("Pizza Customization");
            stage.setScene(scene);
            stage.show();

            PizzaCustomController pizzaView = loader.getController();
            pizzaView.setMainController(this);
            pizzaView.setPizza(pizza);
            pizzaView.setTotalToppingsList(allToppings);
            pizzaView.setSelectedToppingsList(pizza.getToppings());
            // pizzaView.setPepperoniImage();
            if(!orderStarted)
            {
                orderStarted = true;
                order = new Order(phoneNumberField.getText());
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void handleDeluxeButton()
    {
        Pizza pizza = new Deluxe();
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Sausage);
        pizza.addTopping(Toppings.GreenPepper);
        pizza.addTopping(Toppings.Mushroom);
        pizza.addTopping(Toppings.Onion);
        pizza.addTopping(Toppings.Pepperoni);
        if (!getPhone()) {
            System.out.println("Must enter a phone number.");
            return;
        }
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaCustomView.fxml"));
            root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 700);
            stage.setTitle("Pizza Customization");
            stage.setScene(scene);
            stage.show();

            PizzaCustomController pizzaView = loader.getController();
            pizzaView.setMainController(this);
            pizzaView.setPizza(pizza);
            pizzaView.setTotalToppingsList(allToppings);
            pizzaView.setSelectedToppingsList(pizza.getToppings());
            if(!orderStarted)
            {
                orderStarted = true;
                order = new Order(phoneNumberField.getText());
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void handleHawaiianButton()
    {
        Pizza pizza = new Hawaiian();
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Pineapple);
        if (!getPhone()) {
            System.out.println("Must enter a phone number.");
            return;
        }
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaCustomView.fxml"));
            root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 700);
            stage.setTitle("Pizza Customization");
            stage.setScene(scene);
            stage.show();

            PizzaCustomController pizzaView = loader.getController();
            pizzaView.setMainController(this);
            pizzaView.setPizza(pizza);
            pizzaView.setTotalToppingsList(allToppings);
            pizzaView.setSelectedToppingsList(pizza.getToppings());
            if(!orderStarted)
            {
                orderStarted = true;
                order = new Order(phoneNumberField.getText());
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void handleStoreOrdersButton()
    {

    }

    public void handleCurrentOrderButton() {
        if (!getPhone()) {
            System.out.println("Must enter a phone number.");
            return;
        }
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
            root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root, 1000, 900);
            stage.setTitle("Pizza Customization");
            stage.setScene(scene);
            stage.show();

            CurrentOrderController currentOrderView = loader.getController();
            currentOrderView.setMainController(this);
            currentOrderView.setPhone(phone);
            currentOrderView.setOrder(order);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the phone number for the current order for the main controller
     * @return true if the phone number entered is valid, false otherwise
     */
    public boolean getPhone()
    {
        phone = phoneNumberField.getText();
        if (phone.matches("^[0-9]+$") && phone.length() == 10){
            // cannot change phone once a valid number is entered and order is started until order is placed
            phoneNumberField.setEditable(false);
            return true;
        }
        return false;
    }

}