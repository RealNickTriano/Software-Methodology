package Project4;

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

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
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