package Project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

    public void handlePepperoniButton()
    {
        Pizza pizza = new Pepperoni();
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Pepperoni);
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
            pizzaView.setPepperoniImage();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void handleDeluxeButton()
    {
        Parent root;
        try {
            root = FXMLLoader.load(RuPizzeriaApplication.class.getResource("PizzaCustomView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 700);
            stage.setTitle("Pizza Customization");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void handleHawaiianButton()
    {
        Parent root;
        try {
            root = FXMLLoader.load(RuPizzeriaApplication.class.getResource("PizzaCustomView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 700);
            stage.setTitle("Pizza Customization");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void handleStoreOrdersButton()
    {

    }

    public void handleCurrentOrderButton()
    {

    }
}