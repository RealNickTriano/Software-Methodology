package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button pepperoniButton;
    private Button deluxeButton;
    private Button hawaiianButton;
    private Button storeOrdersButton;
    private Button currentOrderButton;
    private EditText phoneNumber;
    public static Order order;
    public static StoreOrders storeOrder;
    protected ArrayList<Order> storeOrderList;
    public static Pizza pizza;
    public boolean orderStarted = false;
    private String phone;
    protected boolean phoneEditable = true;

    public static Bundle mainBundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = findViewById(R.id.editTextPhone);

    }

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

    public void handlePepperoniButton(View view)
    {
        pizza = PizzaMaker.createPizza("Pepperoni");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Pepperoni);
        pizza.addTopping(Toppings.Cheese);
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

    public void handleDeluxeButton(View view)
    {
        pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Sausage);
        pizza.addTopping(Toppings.GreenPepper);
        pizza.addTopping(Toppings.Mushroom);
        pizza.addTopping(Toppings.Onion);
        pizza.addTopping(Toppings.Pepperoni);
        pizza.addTopping(Toppings.Cheese);
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

    public void handleHawaiianButton(View view)
    {
        pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Pineapple);
        pizza.addTopping(Toppings.Cheese);
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

    public void handleCurrentOrderButton(View view)
    {
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        startActivity(intent);

    }

    public void handleStoreOrdersButton(View view)
    {

    }

    public boolean getPhone() {
        phone = phoneNumber.getText().toString();
        if (phone.matches("^[0-9]+$") && phone.length() == Constants.PHONE_LENGTH) {
            // cannot change phone once a valid number is entered and order is started until order is placed
            phoneNumber.setEnabled(false);
            return true;
        }
        return false;
    }

}