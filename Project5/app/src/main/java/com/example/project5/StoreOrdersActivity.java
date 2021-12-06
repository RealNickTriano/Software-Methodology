package com.example.project5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StoreOrdersActivity extends AppCompatActivity {

    private ArrayList<Order> storeOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        Spinner s = (Spinner) findViewById(R.id.phoneSpinner);
        storeOrders = MainActivity.storeOrder.getStoreOrdersList();
        int size = storeOrders.size();

        String[] arraySpinner = new String[size];
        int i;
        for (i = 0; i < size; i++) {
            arraySpinner[i] = storeOrders.get(i).getPhoneNumber();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}