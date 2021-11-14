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
    private ObservableList<String> comboList = FXCollections.observableArrayList();
    private ObservableList<String> emptyList = FXCollections.observableArrayList();

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setPhoneCombo()
    {

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
        try {
            phoneSelected = phoneCombo.getSelectionModel().getSelectedItem().toString();
        }
        catch (Exception e)
        {
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

    @FXML
    public void setOrderTotal()
    {
        String priceString = String.valueOf(order.getTotal());
        orderTotalTextField.setText(priceString);
    }

    @FXML
    protected void handleCancelOrder()
    {
        for (int i = 0; i < mainController.storeOrder.getStoreOrdersList().size(); i++)
        {
            if(mainController.storeOrder.getStoreOrdersList().get(i).getPhoneNumber().equalsIgnoreCase(phoneSelected))
            {
                order = mainController.storeOrder.getStoreOrdersList().get(i);
            }
        }
        mainController.storeOrder.removeFromStoreOrders(order);
        comboList.remove(phoneSelected);
        phoneCombo.getSelectionModel().selectFirst();
        storeOrdersListView.setItems(emptyList);
        handlePhoneCombo();

    }

    @FXML
    protected void handleExportOrders()
    {
        mainController.storeOrder.export();
    }
}