package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The Controller for the Store orders GUI, handles store orders GUI events
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class StoreOrdersController {

    @FXML
    private ListView storeOrdersListView;
    @FXML
    private Button exportOrdersButton;
    @FXML
    private Button cancelOrderButton;
    @FXML
    private ComboBox phoneCombo;
    @FXML
    private TextField orderTotalTextField;

    private MainMenuController mainController;
    private String phoneSelected;
    private ObservableList<Pizza> pizzaObservableList;
    private Order order;
    private ObservableList<String> comboList = FXCollections.observableArrayList();
    private ObservableList<String> emptyList = FXCollections.observableArrayList();

    /**
     * Helper method to set the main controller to access data items in MainMenuController
     *
     * @param controller the controller for the main menu
     */
    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    /**
     * Helper method to set combo box for all phone numbers which ordered pizza
     */
    public void setPhoneCombo() {

        for (int i = 0; i < mainController.storeOrder.getStoreOrdersList().size(); i++) {
            comboList.add(mainController.storeOrder.getStoreOrdersList().get(i).getPhoneNumber());
        }
        phoneCombo.setItems(comboList);
        phoneCombo.getSelectionModel().selectFirst();
        phoneSelected = phoneCombo.getSelectionModel().getSelectedItem().toString();
    }

    /**
     * Handles selection of combo box with phone numbers. Displays Order and price corresponding with the phone number.
     */
    @FXML
    protected void handlePhoneCombo() {
        try {
            phoneSelected = phoneCombo.getSelectionModel().getSelectedItem().toString();
        } catch (Exception e) {
            orderTotalTextField.setText("0.00");
            return;
        }
        pizzaObservableList = FXCollections.observableArrayList();

        for (int i = 0; i < mainController.storeOrder.getStoreOrdersList().size(); i++) {
            if (mainController.storeOrder.getStoreOrdersList().get(i).getPhoneNumber().equalsIgnoreCase(phoneSelected)) {
                order = mainController.storeOrder.getStoreOrdersList().get(i);
            }
        }
        pizzaObservableList.setAll(order.getPizzaList());
        storeOrdersListView.setItems(pizzaObservableList);
        setOrderTotal();

    }

    /**
     * Helper method to set the order total.
     */
    public void setOrderTotal() {
        String priceString = String.valueOf(order.getTotal());
        orderTotalTextField.setText(priceString);
    }

    /**
     * Handles cancel order button press. Removes order from store orders list and phone number from combo box.
     * Resets order total to 0
     */
    @FXML
    protected void handleCancelOrder() {
        for (int i = 0; i < mainController.storeOrder.getStoreOrdersList().size(); i++) {
            if (mainController.storeOrder.getStoreOrdersList().get(i).getPhoneNumber().equalsIgnoreCase(phoneSelected)) {
                order = mainController.storeOrder.getStoreOrdersList().get(i);
            }
        }
        mainController.storeOrder.removeFromStoreOrders(order);
        comboList.remove(phoneSelected);
        phoneCombo.getSelectionModel().selectFirst();
        storeOrdersListView.setItems(emptyList);
        handlePhoneCombo();

    }

    /**
     * Handles export order button press. Calls export method which generates a text file of all the store orders.
     */
    @FXML
    protected void handleExportOrders() {
        mainController.storeOrder.export();
        Stage stage = (Stage) exportOrdersButton.getScene().getWindow();
        System.out.println("Export done.");
        stage.close();
    }
}