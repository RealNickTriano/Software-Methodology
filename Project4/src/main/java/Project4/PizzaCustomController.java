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
import javafx.stage.Stage;

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
    private TextField priceText;
    @FXML
    private ComboBox quantityBox;
    @FXML
    private Button addToOrderButton;


    private MainMenuController mainController;

    private ObservableList<Toppings> totalToppingsObservable;
    private ObservableList<Toppings> selectedToppingsObservable;
    private String sizeSelected;
    private Pizza pizza;
    private int quantity;

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
        quantityBox.getItems().addAll("0", "1","2", "3", "4", "5");
        quantityBox.getSelectionModel().selectFirst();

    }

    public void setPizza(Pizza selectedPizza)
    {
        pizza = selectedPizza;
        priceText.setText(String.valueOf(pizza.price()));
    }

    public void setPrice()
    {
        priceText.setText("0.00");
    }

    public void setMainController(MainMenuController controller) {
        mainController = controller; //now you can reference any private data items through mainController
    }

    public void setImage(String imageFile) {
        Image image = new Image(imageFile);
        pizzaImage.setImage(image);
        pizzaImage.setCache(true);
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
        if (totalToppingsList.getSelectionModel().getSelectedItem() == null)
        {
            System.out.println("Must select topping to add.");
            return;
        }
        if(selectedToppingsList.getItems().size() < 7)
        {
            pizza.addTopping((Toppings) totalToppingsList.getSelectionModel().getSelectedItem());
            selectedToppingsObservable.add((Toppings) totalToppingsList.getSelectionModel().getSelectedItem());
            totalToppingsObservable.remove(totalToppingsList.getSelectionModel().getSelectedItem());
            priceText.setText(String.valueOf(pizza.price()));
            handleChoiceBox();
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
            pizza.removeTopping((Toppings) selectedToppingsList.getSelectionModel().getSelectedItem());
            selectedToppingsObservable.remove(selectedToppingsList.getSelectionModel().getSelectedItem());
            priceText.setText(String.valueOf(pizza.price()));
        }
        else
            System.out.println("Cannot remove topping.");
    }

    @FXML
    protected void handleAddToOrder()
    {
        // add pizza to order
        // Order must only be tracked through main menu controller to be maintained thru
        // window closes and transfer info between windows
        //System.out.println("adding to order");
        while(quantity > 0) {
            mainController.order.addToOrder(pizza);
            quantity--;
        }
        System.out.println("added to order.");
        Stage stage = (Stage) addToOrderButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void handleComboBox()
    {
        sizeSelected = sizeComboBox.getSelectionModel().getSelectedItem().toString();
        pizza.setSize((Size) sizeComboBox.getSelectionModel().getSelectedItem());
        priceText.setText(String.valueOf(pizza.price()));
        handleChoiceBox();
    }

    @FXML
    protected void handleChoiceBox()
    {
        quantity = Integer.parseInt(quantityBox.getSelectionModel().getSelectedItem().toString());
        priceText.setText(String.valueOf(pizza.price() * quantity));
    }

    private boolean checkValidRemove()
    {
        if (selectedToppingsList.getSelectionModel().getSelectedItem() == null)
        {
            return false;
        }
        if(pizza instanceof Pepperoni)
        {
            if (selectedToppingsList.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Pepperoni")) {
                return false;
            }
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
                    .toString().equalsIgnoreCase("Pineapple")) {
                return false;
            }
        }
        return true;
    }


}