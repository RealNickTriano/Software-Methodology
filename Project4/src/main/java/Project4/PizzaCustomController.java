package Project4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The Controller for the pizza customization GUI, handles pizza customization GUI events
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class PizzaCustomController implements Initializable {
    @FXML
    private ListView totalToppingsList;
    @FXML
    private ListView selectedToppingsList;
    @FXML
    private ComboBox sizeComboBox;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private ImageView pizzaImage;
    @FXML
    private HBox priceBox;
    @FXML
    private TextField priceText;
    @FXML
    private ComboBox quantityBox;
    @FXML
    private Button addToOrderButton;


    private MainMenuController mainController;

    private ObservableList<Toppings> totalToppingsObservable;
    private ObservableList<Toppings> selectedToppingsObservable;
    private String sizeSelected;
    private Pizza pizza;
    private int quantity;

    /**
     * Called on start up, initializes needed variables
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectedToppingsObservable = FXCollections.observableArrayList();
        totalToppingsObservable = FXCollections.observableArrayList();
        ObservableList<Size> comboList = FXCollections.observableArrayList(
                Size.Small, Size.Medium, Size.Large);
        sizeComboBox.setItems(comboList);
        sizeComboBox.getSelectionModel().selectFirst();
        sizeSelected = sizeComboBox.getSelectionModel().getSelectedItem().toString();
        quantityBox.getItems().addAll("0", "1", "2", "3", "4", "5");
        quantityBox.getSelectionModel().selectFirst();

    }

    /**
     * Helper method to set the main controller to access data items in MainMenuController
     *
     * @param controller the controller for the main menu
     */
    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    /**
     * Helper method to set the pizza selected in main menu
     *
     * @param selectedPizza pizza selected in main menu
     */
    public void setPizza(Pizza selectedPizza) {
        pizza = selectedPizza;
        priceText.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Helper method to set price textField initially
     */
    public void setPrice() {
        priceText.setText("0.00");
    }

    /**
     * Helper method to set the correct image in PizzaCustomView based on button pressed in main menu.
     *
     * @param imageFile string of the image file needed to display
     */
    public void setImage(String imageFile) {
        Image image = new Image(imageFile);
        pizzaImage.setImage(image);
        pizzaImage.setCache(true);
    }

    /**
     * Helper method to set the total toppings list view in PizzaCustomView
     *
     * @param toppings arraylist of toppings to show in the list view
     */
    public void setTotalToppingsList(ArrayList<Toppings> toppings) {
        for (int i = 0; i < toppings.size(); i++) {
            totalToppingsObservable.add(toppings.get(i));
        }

        totalToppingsList.setItems(totalToppingsObservable);
    }

    /**
     * Helper method to set the selected toppings list view in PizzaCustomView
     *
     * @param toppings arraylist of toppings to show in the list view
     */
    public void setSelectedToppingsList(ArrayList<Toppings> toppings) {

        for (int i = 0; i < toppings.size(); i++) {
            selectedToppingsObservable.add(toppings.get(i));
            totalToppingsObservable.remove(toppings.get(i));
        }

        selectedToppingsList.setItems(selectedToppingsObservable);
    }

    /**
     * Handles add topping button press, adds topping to selected list view and removes from total toppings list view.
     * Constraint is set to 7 toppings max selected.
     */
    @FXML
    protected void handleAddButton() {
        if (totalToppingsList.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Must select a topping to add.");
            alert.show();
            return;
        }
        if (selectedToppingsList.getItems().size() < 7) {
            pizza.addTopping((Toppings) totalToppingsList.getSelectionModel().getSelectedItem());
            selectedToppingsObservable.add((Toppings) totalToppingsList.getSelectionModel().getSelectedItem());
            totalToppingsObservable.remove(totalToppingsList.getSelectionModel().getSelectedItem());
            priceText.setText(String.format("%.2f", pizza.price()));
            handleChoiceBox();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Toppings cannot exceed 7.");
            alert.show();
        }
    }

    /**
     * Handles remove topping button press, removes topping from selected list view and adds to total toppings list view.
     * Calls checkValidRemove() method, removing default toppings is rejected.
     */
    @FXML
    protected void handleRemoveButton() {
        if (checkValidRemove()) {
            totalToppingsObservable.add((Toppings) selectedToppingsList.getSelectionModel().getSelectedItem());
            pizza.removeTopping((Toppings) selectedToppingsList.getSelectionModel().getSelectedItem());
            selectedToppingsObservable.remove(selectedToppingsList.getSelectionModel().getSelectedItem());
            priceText.setText(String.format("%.2f", pizza.price()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Cannot remove topping.");
            alert.show();
        }
    }

    /**
     * Handles add to order button press. Adds pizza to order and closes window
     */
    @FXML
    protected void handleAddToOrder() {
        while (quantity > 0) {
            mainController.order.addToOrder(pizza);
            quantity--;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setContentText("Successfully added to order.");
        alert.show();
        Stage stage = (Stage) addToOrderButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Handles selection of size combo box item and sets the price accordingly based on quantity
     */
    @FXML
    protected void handleComboBox() {
        sizeSelected = sizeComboBox.getSelectionModel().getSelectedItem().toString();
        pizza.setSize((Size) sizeComboBox.getSelectionModel().getSelectedItem());
        priceText.setText(String.format("%.2f", pizza.price()));
        handleChoiceBox();
    }

    /**
     * Handles selection of quantity combo box item and sets price accordingly
     */
    @FXML
    protected void handleChoiceBox() {
        quantity = Integer.parseInt(quantityBox.getSelectionModel().getSelectedItem().toString());
        priceText.setText(String.format("%.2f", (pizza.price() * quantity)));
    }

    /**
     * Helper method for handleRemoveButton(). checks invalid removal of default toppings
     *
     * @return true if there is no violation, false if there is a violation
     */
    private boolean checkValidRemove() {
        if (selectedToppingsList.getSelectionModel().getSelectedItem() == null) {
            return false;
        }
        if (pizza instanceof Pepperoni) {
            if (selectedToppingsList.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Pepperoni")) {
                return false;
            }
        } else if (pizza instanceof Deluxe) {
            if (selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Pepperoni") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                            .toString().equalsIgnoreCase("Sausage") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                            .toString().equalsIgnoreCase("GreenPepper") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                            .toString().equalsIgnoreCase("Onion") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                            .toString().equalsIgnoreCase("Mushroom"))
                return false;
        } else if (pizza instanceof Hawaiian) {
            if (selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Ham") || selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Pineapple")) {
                return false;
            }
        }
        return true;
    }


}