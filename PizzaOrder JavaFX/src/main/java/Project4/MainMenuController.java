package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * The Controller for the GUI, handles all GUI events
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class MainMenuController implements Initializable {
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

    private ArrayList<Toppings> allToppings = new ArrayList<>(
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
    protected StoreOrders storeOrder;
    protected ArrayList<Order> storeOrderList;
    protected ObservableList<String> phoneList = FXCollections.observableArrayList();
    protected boolean phoneEditable = true;

    /**
     * Called on start up, initializes needed variables
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        storeOrderList = new ArrayList<>();
        storeOrder = new StoreOrders(storeOrderList);
    }

    /**
     * Handles phone number text field on mouse click.
     * If in the middle of an order the field is not editable.
     */
    @FXML
    public void onMousePressedPhone() {
        if (phoneEditable) {
            phoneNumberField.setEditable(true);
        } else {
            phoneNumberField.setEditable(false);
        }
    }

    /**
     * Handles pepperoni button press, sets a new stage and shows new window.
     * Calls methods in PizzaCustomController class to set up window UI elements.
     */
    @FXML
    public void handlePepperoniButton() {
        Pizza pizza = PizzaMaker.createPizza("Pepperoni");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Pepperoni);
        if (!getPhone()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Must enter a phone number.");
            alert.show();
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
            stage.setResizable(false);
            stage.show();
            PizzaCustomController pizzaView = loader.getController();
            pizzaView.setMainController(this);
            pizzaView.setPizza(pizza);
            pizzaView.setTotalToppingsList(allToppings);
            pizzaView.setSelectedToppingsList(pizza.getToppings());
            pizzaView.setPrice();
            pizzaView.setImage("Pepperoni.jpg");
            if (phoneEditable)
                phoneEditable = false;
            if (!orderStarted) {
                orderStarted = true;
                order = new Order(phoneNumberField.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles deluxe button press, sets a new stage and shows new window.
     * Calls methods in PizzaCustomController class to set up window UI elements.
     */
    @FXML
    public void handleDeluxeButton() {
        Pizza pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Sausage);
        pizza.addTopping(Toppings.GreenPepper);
        pizza.addTopping(Toppings.Mushroom);
        pizza.addTopping(Toppings.Onion);
        pizza.addTopping(Toppings.Pepperoni);
        if (!getPhone()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Must enter a phone number.");
            alert.show();
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
            stage.setResizable(false);
            stage.show();
            PizzaCustomController pizzaView = loader.getController();
            pizzaView.setMainController(this);
            pizzaView.setPizza(pizza);
            pizzaView.setTotalToppingsList(allToppings);
            pizzaView.setSelectedToppingsList(pizza.getToppings());
            pizzaView.setPrice();
            pizzaView.setImage("Deluxe.jpg");
            if (phoneEditable)
                phoneEditable = false;
            if (!orderStarted) {
                orderStarted = true;
                order = new Order(phoneNumberField.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles hawaiian button press, sets a new stage and shows new window.
     * Calls methods in PizzaCustomController class to set up window UI elements.
     */
    @FXML
    public void handleHawaiianButton() {
        Pizza pizza = PizzaMaker.createPizza("Hawaiian");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Pineapple);
        if (!getPhone()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Must enter a phone number.");
            alert.show();
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
            stage.setResizable(false);
            stage.show();
            PizzaCustomController pizzaView = loader.getController();
            pizzaView.setMainController(this);
            pizzaView.setPizza(pizza);
            pizzaView.setTotalToppingsList(allToppings);
            pizzaView.setSelectedToppingsList(pizza.getToppings());
            pizzaView.setPrice();
            pizzaView.setImage("Hawaiian.jpg");
            if (phoneEditable)
                phoneEditable = false;
            if (!orderStarted) {
                orderStarted = true;
                order = new Order(phoneNumberField.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles store orders button press, sets a new stage and shows new window.
     * Calls methods in StoreOrdersController class to set up window UI elements.
     * If no orders have been placed, return early and display message.
     */
    @FXML
    public void handleStoreOrdersButton() {
        if (storeOrderList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Please add an order first.");
            alert.show();
        } else {
            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
                root = loader.load();

                Stage stage = new Stage();
                Scene scene = new Scene(root, 1000, 900);
                stage.setTitle("Store Orders");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

                StoreOrdersController storeOrdersController = loader.getController();
                storeOrdersController.setMainController(this);
                storeOrdersController.setPhoneCombo();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles current orders button press, sets a new stage and shows new window.
     * Calls methods in CurrentOrderController class to set up window UI elements.
     * If an order has not been started, return early and display message.
     */
    @FXML
    public void handleCurrentOrderButton() {
        if (!getPhone()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Must enter a phone number.");
            alert.show();
            return;
        }
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root, 1000, 900);
            stage.setTitle("Current Order");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            CurrentOrderController currentOrderView = loader.getController();
            currentOrderView.setMainController(this);
            if (!orderStarted) {
                orderStarted = true;
                order = new Order(phoneNumberField.getText());
            }
            currentOrderView.setPhone(phone);
            currentOrderView.setOrder();
            currentOrderView.setTotals();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the phone number for the current order for the main controller
     *
     * @return true if the phone number entered is valid, false otherwise
     */
    public boolean getPhone() {
        phone = phoneNumberField.getText();
        if (phone.matches("^[0-9]+$") && phone.length() == Constants.PHONE_LENGTH) {
            // cannot change phone once a valid number is entered and order is started until order is placed
            phoneNumberField.setEditable(false);
            return true;
        }
        return false;
    }

}