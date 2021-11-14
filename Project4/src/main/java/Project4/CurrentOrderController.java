package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {


    }
    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setTotals()
    {
        if (mainController.order.getPizzaList().isEmpty())
        {
            salesTax = 0.0;
            orderTotal = 0.0;
            subtotal = 0.0;
        }
        else {
            subtotal = 0.0;
            for (int i = 0; i < mainController.order.getPizzaList().size(); i++) {
                subtotal += mainController.order.getPizzaList().get(i).price();
            }

            salesTax = subtotal * 0.0625;
            orderTotal = subtotal + salesTax;
        }
            subtotalTextField.setText(String.format("%.2f", subtotal));
            salesTaxTextField.setText(String.format("%.2f", salesTax));
            orderTotalTextField.setText(String.format("%.2f", orderTotal));
    }
    public void setPhone(String phone) {
        customerPhone.setText(phone);
    }

    public void setOrder(Order order)
    {
            orderObservable = FXCollections.observableArrayList();
            orderObservable.setAll(mainController.order.getPizzaList());
            orderListView.setItems(orderObservable);
    }

    @FXML
    protected void handleRemovePizzaButton()
    {
        mainController.order.removeFromOrder( (Pizza) orderListView.getSelectionModel().getSelectedItem());
        orderObservable.remove(orderListView.getSelectionModel().getSelectedItem());
        setTotals();
    }

    @FXML
    protected void handlePlaceOrderButton()
    {
        mainController.storeOrder.addToStoreOrders(mainController.order);
        mainController.orderStarted = false;
        mainController.phoneEditable = true;

    }
}