package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The Controller for the current orders GUI, handles current orders GUI events
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class CurrentOrderController {

    @FXML
    private ListView orderListView;
    @FXML
    private Button removePizzaButton;
    @FXML
    private Button placeOrderButton;
    @FXML
    private TextField subtotalTextField;
    @FXML
    private TextField salesTaxTextField;
    @FXML
    private TextField orderTotalTextField;
    @FXML
    private TextField customerPhone;

    private MainMenuController mainController;
    private ObservableList<Pizza> orderObservable;
    private Double subtotal = 0.0;
    private Double salesTax = 0.0;
    private Double orderTotal = 0.0;

    /**
     * Helper method to set the main controller to access data items in MainMenuController
     *
     * @param controller the controller for the main menu
     */
    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    /**
     * Helper method to set the sales tax, order total, and subtotal of the current order
     * Updates text fields and numbers are set to 2 decimal places
     */
    public void setTotals() {
        if (mainController.order.getPizzaList().isEmpty()) {
            salesTax = 0.0;
            orderTotal = 0.0;
            subtotal = 0.0;
        } else {
            subtotal = 0.0;
            for (int i = 0; i < mainController.order.getPizzaList().size(); i++) {
                subtotal += mainController.order.getPizzaList().get(i).price();
            }

            salesTax = subtotal * Constants.TAX_RATE;
            orderTotal = subtotal + salesTax;
        }
        subtotalTextField.setText(String.format("%.2f", subtotal));
        salesTaxTextField.setText(String.format("%.2f", salesTax));
        orderTotalTextField.setText(String.format("%.2f", orderTotal));
    }

    /**
     * Helper method to set the phone number text field-
     *
     * @param phone customer's phone number
     */
    public void setPhone(String phone) {
        customerPhone.setText(phone);
    }

    /**
     * Sets the order list view to display the pizzas in the Order
     */
    public void setOrder() {
        orderObservable = FXCollections.observableArrayList();
        orderObservable.setAll(mainController.order.getPizzaList());
        orderListView.setItems(orderObservable);
    }

    /**
     * Handles remove button press. Removes pizza from list view and recalculates totals.
     */
    @FXML
    protected void handleRemovePizzaButton() {
        mainController.order.removeFromOrder((Pizza) orderListView.getSelectionModel().getSelectedItem());
        orderObservable.remove(orderListView.getSelectionModel().getSelectedItem());
        setTotals();
    }

    /**
     * Handles place order button. Adds order to list of store orders, sets phone text field to editable, closes window.
     */
    @FXML
    protected void handlePlaceOrderButton() {
        mainController.storeOrder.addToStoreOrders(mainController.order);
        mainController.orderStarted = false;
        mainController.phoneEditable = true;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setContentText("Order placed!");
        alert.show();
        Stage stage = (Stage) placeOrderButton.getScene().getWindow();
        stage.close();
    }
}