package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

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

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setPhoneCombo()
    {
        ObservableList<String> comboList = FXCollections.observableArrayList();
        for (int i = 0; i < mainController.storeOrder.getStoreOrdersList().size(); i++)
        {
            comboList.add(mainController.storeOrder.getStoreOrdersList().get(i).getPhoneNumber());
        }
        phoneCombo.setItems(comboList);
        phoneCombo.getSelectionModel().selectFirst();
        phoneSelected = phoneCombo.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    protected void handlePhoneCombo()
    {
        phoneSelected = phoneCombo.getSelectionModel().getSelectedItem().toString();
        pizzaObservableList = FXCollections.observableArrayList();

        for (int i = 0; i < mainController.storeOrder.getStoreOrdersList().size(); i++)
        {
            if(mainController.storeOrder.getStoreOrdersList().get(i).getPhoneNumber().equalsIgnoreCase(phoneSelected))
            {
                order = mainController.storeOrder.getStoreOrdersList().get(i);
            }
        }
        pizzaObservableList.setAll(order.getPizzaList());
        storeOrdersListView.setItems(pizzaObservableList);
        setOrderTotal();
    }

    @FXML
    public void setOrderTotal()
    {
        String priceString = String.valueOf(order.getTotal());
        orderTotalTextField.setText(priceString);
    }

    @FXML
    protected void handleCancelOrder()
    {

    }

    @FXML
    protected void handleExportOrders()
    {

    }
}