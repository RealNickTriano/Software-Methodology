package com.example.project5;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(), "Pepperoni", Toast.LENGTH_SHORT).show();
    }

    public void handleDeluxeButton(View view)
    {

    }

    public void handleHawaiianButton(View view)
    {

    }

    public void handleCurrentOrderButton(View view)
    {

    }

    public void handleStoreOrdersButton(View view)
    {

    }


}