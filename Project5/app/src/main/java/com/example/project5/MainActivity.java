package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Activity to display and handle Main menu
 * Navigates to other menus through buttons
 * @author Nicholas Triano, Antonio Ignarra
 */
public class MainActivity extends AppCompatActivity {

    private Button pepperoniButton;
    private Button deluxeButton;
    private Button hawaiianButton;
    private Button storeOrdersButton;
    private Button currentOrderButton;
    private static EditText phoneNumber;
    public static Order order;
    public static StoreOrders storeOrder;
    protected ArrayList<Order> storeOrderList = new ArrayList<Order>();
    public static Pizza pizza;
    public boolean orderStarted = false;
    private String phone;
    protected static boolean phoneEditable = true;

    public static Bundle mainBundle = new Bundle();

    /**
     * Method called on creation of the activity, sets layout of screen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = findViewById(R.id.editTextPhone);
        storeOrder = new StoreOrders(storeOrderList);
    }

    /**
     * Called when activity comes back into foreground
     */
    @Override
    public void onResume()
    {
        super.onResume();

        if (phoneEditable)
        {
            phoneNumber.setEnabled(true);
        }
        else
        {
            phoneNumber.setEnabled(false);
        }
    }

    /**
     * handles click of pepperoni button, launches new activity to customize pizza
     * @param view button pressed
     */
    public void handlePepperoniButton(View view)
    {
        pizza = PizzaMaker.createPizza("Pepperoni");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Pepperoni);
        //pizza.addTopping(Toppings.Cheese);
        if (!getPhone())
        {
            Toast.makeText(getApplicationContext(), "Must enter a phone number.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, PizzaCustomActivity.class);
        intent.putExtra("image", "Pepperoni");
        if (phoneEditable) {
            phoneEditable = false;
        }
        if(!orderStarted)
        {
            orderStarted = true;
            order = new Order(phoneNumber.getText().toString());
        }
        startActivity(intent);
    }

    /**
     * handles click of deluxe button, launches new activity to customize pizza
     * @param view button pressed
     */
    public void handleDeluxeButton(View view)
    {
        pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Sausage);
        pizza.addTopping(Toppings.GreenPepper);
        pizza.addTopping(Toppings.Mushroom);
        pizza.addTopping(Toppings.Onion);
        pizza.addTopping(Toppings.Pepperoni);
        //pizza.addTopping(Toppings.Cheese);
        if (!getPhone())
        {
            Toast.makeText(getApplicationContext(), "Must enter a phone number.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, PizzaCustomActivity.class);
        intent.putExtra("image", "Deluxe");
        if (phoneEditable) {
            phoneEditable = false;
        }
        if(!orderStarted)
        {
            orderStarted = true;
            order = new Order(phoneNumber.getText().toString());
        }
        startActivity(intent);
    }

    /**
     * handles click of hawaiian button, launches new activity to customize pizza
     * @param view button pressed
     */
    public void handleHawaiianButton(View view)
    {
        pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Pineapple);
        //pizza.addTopping(Toppings.Cheese);
        if (!getPhone())
        {
            Toast.makeText(getApplicationContext(), "Must enter a phone number.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, PizzaCustomActivity.class);
        intent.putExtra("image", "Hawaiian");
        if (phoneEditable) {
            phoneEditable = false;
        }
        if(!orderStarted)
        {
            orderStarted = true;
            order = new Order(phoneNumber.getText().toString());
        }
        startActivity(intent);
    }

    /**
     * handles click of current order button, launches new activity to the current order
     * @param view button pressed
     */
    public void handleCurrentOrderButton(View view)
    {
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        String p = phoneNumber.getText().toString();
        intent.putExtra("phone_number", p);
        startActivity(intent);

    }

    /**
     * handles click of store order button, launches new activity to the store orders
     * @param view button pressed
     */
    public void handleStoreOrdersButton(View view)
    {
        // TODO: launch new intent, with all the store orders
        // not sure how to display different phone numbers yet
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        startActivity(intent);
    }

    /**
     * helper method to check for correct phone number input
     * @return true on success, false on error
     */
    public boolean getPhone() {
        phone = phoneNumber.getText().toString();
        if (phone.matches("^[0-9]+$") && phone.length() == Constants.PHONE_LENGTH) {
            // cannot change phone once a valid number is entered and order is started until order is placed
            phoneNumber.setEnabled(false);
            return true;
        }
        return false;
    }

    /**
     * helper method to reset the phone input
     */
    public static void setPhoneEditable() {
        phoneEditable = true;
        phoneNumber.setText("");
    }

}