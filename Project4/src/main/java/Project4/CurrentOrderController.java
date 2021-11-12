package Project4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setPhone(String phone) {
        customerPhone.setText(phone);
    }

    @FXML
    protected void handleRemovePizzaButton()
    {

    }

    @FXML
    protected void handlePlaceOrderButton()
    {

    }
}