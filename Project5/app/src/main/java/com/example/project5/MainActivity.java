package com.example.project5;

import android.os.Bundle;
import android.provider.ContactsContract;
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


}