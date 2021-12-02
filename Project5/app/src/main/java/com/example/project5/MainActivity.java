package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
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
    protected Order order;
    protected StoreOrders storeOrder;
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
        //intent.putExtra("pizza", pizza);
        //mainBundle.putParcelable("pizza", (Parcelable) pizza);
        if (phoneEditable)
            phoneEditable = false;
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
        intent.putExtra("pizza", (Parcelable) pizza);
        if (phoneEditable)
            phoneEditable = false;
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
        if (phoneEditable)
            phoneEditable = false;
        if(!orderStarted)
        {
            orderStarted = true;
            order = new Order(phoneNumber.getText().toString());
        }
        startActivity(intent);
    }

    public void handleCurrentOrderButton(View view)
    {

    }

    public void handleStoreOrdersButton(View view)
    {

    }

    public void addToOrder(Pizza pizza)
    {
        order.addToOrder(pizza);
    }

    public boolean getPhone() {
        phone = phoneNumber.getText().toString();
        if (phone.matches("^[0-9]+$") && phone.length() == Constants.PHONE_LENGTH) {
            // cannot change phone once a valid number is entered and order is started until order is placed
            phoneNumber.setInputType(InputType.TYPE_CLASS_PHONE);
            return true;
        }
        return false;
    }


}