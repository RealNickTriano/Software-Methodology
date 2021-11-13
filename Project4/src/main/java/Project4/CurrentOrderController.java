package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

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

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setPhone(String phone) {
        customerPhone.setText(phone);
    }

    public void setOrder(Order order)
    {
        orderObservable = FXCollections.observableArrayList();
        orderObservable.setAll(order.getPizzaList());
        orderListView.setItems(orderObservable);
    }

    @FXML
    protected void handleRemovePizzaButton()
    {

    }

    @FXML
    protected void handlePlaceOrderButton()
    {
        mainController.orderStarted = false;
    }
}