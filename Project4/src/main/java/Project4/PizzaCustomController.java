package Project4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private HBox pizzaImageBox;

    private MainMenuController mainController;

    private ObservableList<Toppings> totalToppingsObservable;
    private ObservableList<Toppings> selectedToppingsObservable;

    // sizeComboBox.getItems().addAll(Size.Small, Size.Medium, Size.Large);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectedToppingsObservable = FXCollections.observableArrayList();
        totalToppingsObservable = FXCollections.observableArrayList();
    }

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setPepperoniImage() {
       /** Image image = new Image("PepperoniPizza.jpg");
        ImageView iv = new ImageView();
        iv.setImage(image);
        pizzaImageBox.getChildren().add(iv);**/
    }

    public void setTotalToppingsList(ArrayList<Toppings> toppings)
    {
        for (int i = 0; i < toppings.size(); i++)
        {
            totalToppingsObservable.add(toppings.get(i));
        }

        totalToppingsList.setItems(totalToppingsObservable);
    }

    public void setSelectedToppingsList(ArrayList<Toppings> toppings)
    {

        for (int i = 0; i < toppings.size(); i++)
        {
            selectedToppingsObservable.add(toppings.get(i));
        }

        selectedToppingsList.setItems(selectedToppingsObservable);
    }

    @FXML
    protected void handleAddButton()
    {

    }

    @FXML
    protected void handleRemoveButton()
    {

    }


}