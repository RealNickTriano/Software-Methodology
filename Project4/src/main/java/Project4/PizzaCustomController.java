package Project4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.File;
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
    private ImageView pizzaImage;
    @FXML
    private HBox priceBox;
    @FXML
    private HBox quantityBox;
    @FXML
    private TextField priceText;
    @FXML
    private TextField quantityText;
    @FXML
    private Button addToOrderButton;

    private MainMenuController mainController;

    private ObservableList<Toppings> totalToppingsObservable;
    private ObservableList<Toppings> selectedToppingsObservable;
    private String sizeSelected;
    private Pizza pizza;

    // sizeComboBox.getItems().addAll(Size.Small, Size.Medium, Size.Large);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectedToppingsObservable = FXCollections.observableArrayList();
        totalToppingsObservable = FXCollections.observableArrayList();
        ObservableList<Size> comboList = FXCollections.observableArrayList(
                Size.Small, Size.Medium, Size.Large);
        sizeComboBox.setItems(comboList);
        sizeComboBox.getSelectionModel().selectFirst();
        sizeSelected = sizeComboBox.getSelectionModel().getSelectedItem().toString();


    }

    public void setPizza(Pizza selectedPizza)
    {
        pizza = selectedPizza;
        priceText.setText(String.valueOf(pizza.price()));
    }

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setPepperoniImage() {
        Image image = new Image("file:PepperoniPizza.png");
        pizzaImage.setImage(image);
        // pizzaImage = new ImageView(getClass().getResource("PepperoniPizza.png").toExternalForm());
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
            totalToppingsObservable.remove(toppings.get(i));
        }

        selectedToppingsList.setItems(selectedToppingsObservable);
    }

    @FXML
    protected void handleAddButton()
    {
        if(selectedToppingsList.getItems().size() != 7)
        {
            selectedToppingsObservable.add((Toppings) totalToppingsList.getSelectionModel().getSelectedItem());
            totalToppingsObservable.remove(totalToppingsList.getSelectionModel().getSelectedItem());
            pizza.addTopping((Toppings) totalToppingsList.getSelectionModel().getSelectedItem());
            priceText.setText(String.valueOf(pizza.price()));
        }
        else
            System.out.println("Toppings cannot exceed 7.");
    }

    @FXML
    protected void handleRemoveButton()
    {
        if(checkValidRemove())
        {
            totalToppingsObservable.add((Toppings) selectedToppingsList.getSelectionModel().getSelectedItem());
            selectedToppingsObservable.remove(selectedToppingsList.getSelectionModel().getSelectedItem());
            pizza.removeTopping((Toppings) selectedToppingsList.getSelectionModel().getSelectedItem());
            priceText.setText(String.valueOf(pizza.price()));
        }
        else
            System.out.println("Cannot remove topping.");
    }

    @FXML
    protected void handleAddToOrder()
    {
        // TODO: Closes this window and launches current order view
        // adds pizza(s) to order
    }

    @FXML
    protected void handleComboBox()
    {
        sizeSelected = sizeComboBox.getSelectionModel().getSelectedItem().toString();
        pizza.setSize((Size) sizeComboBox.getSelectionModel().getSelectedItem());
        priceText.setText(String.valueOf(pizza.price()));
    }

    private boolean checkValidRemove()
    {
        if(pizza instanceof Pepperoni)
        {
            if(selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Pepperoni") )
            return false;
        }
        else if(pizza instanceof Deluxe)
        {
            if(selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Pepperoni") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Sausage") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("GreenPepper") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Onion") ||
                    selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Mushroom"))
            return false;
        }
        else if(pizza instanceof Hawaiian)
        {
            if(selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Ham") || selectedToppingsList.getSelectionModel().getSelectedItem()
                    .toString().equalsIgnoreCase("Pineapple") )
            return false;
        }
        return true;
    }


}