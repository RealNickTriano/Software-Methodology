package Project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
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

    public void handlePepperoniButton()
    {
        Parent root;
        try {
            root = FXMLLoader.load(RuPizzeriaApplication.class.getResource("PizzaCustomView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 700);
            stage.setTitle("RU Pizza");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void handleDeluxeButton()
    {

    }

    public void handleHawaiianButton()
    {

    }

    public void handleStoreOrdersButton()
    {

    }

    public void handleCurrentOrderButton()
    {

    }
}