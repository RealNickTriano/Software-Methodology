package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button pepperoniButton;
    private Button deluxeButton;
    private Button hawaiianButton;
    private Button storeOrdersButton;
    private Button currentOrderButton;
    private ContactsContract.CommonDataKinds.Phone phoneNumber;
    protected Order order;
    protected StoreOrders storeOrder;
    protected ArrayList<Order> storeOrderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handlePepperoniButton(View view)
    {

        Pizza pizza = PizzaMaker.createPizza("Pepperoni");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Pepperoni);
        pizza.addTopping(Toppings.Cheese);
        Intent intent = new Intent(this, PizzaCustomActivity.class);
        intent.putExtra("image", "Pepperoni");
        //intent.putExtra("pizza", pizza);
        startActivity(intent);
    }

    public void handleDeluxeButton(View view)
    {
        Pizza pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Sausage);
        pizza.addTopping(Toppings.GreenPepper);
        pizza.addTopping(Toppings.Mushroom);
        pizza.addTopping(Toppings.Onion);
        pizza.addTopping(Toppings.Pepperoni);
        pizza.addTopping(Toppings.Cheese);
        Intent intent = new Intent(this, PizzaCustomActivity.class);
        intent.putExtra("image", "Deluxe");
        intent.putExtra("pizza", (Parcelable) pizza);
        startActivity(intent);
    }

    public void handleHawaiianButton(View view)
    {
        Pizza pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(Size.Small);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Pineapple);
        pizza.addTopping(Toppings.Cheese);
        Intent intent = new Intent(this, PizzaCustomActivity.class);
        intent.putExtra("image", "Hawaiian");
        startActivity(intent);
    }

    public void handleCurrentOrderButton(View view)
    {

    }

    public void handleStoreOrdersButton(View view)
    {

    }


}