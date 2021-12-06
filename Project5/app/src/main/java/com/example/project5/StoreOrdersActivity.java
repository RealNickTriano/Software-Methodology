package com.example.project5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StoreOrdersActivity extends AppCompatActivity {

    private ArrayList<Order> storeOrders;
    private Spinner phoneList;
    private TextView subtotal;
    private TextView tax;
    private TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        subtotal = findViewById(R.id.subtotalPrice);
        tax = findViewById(R.id.taxPrice);
        total = findViewById(R.id.totalPrice);
        phoneList= (Spinner) findViewById(R.id.phoneSpinner);
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
        phoneList.setAdapter(adapter);
        setPrices();
    }

    public void setPrices() {
        for(int i=0; i <storeOrders.size(); i++) {
            if (phoneList.getSelectedItem().toString() == storeOrders.get(i).getPhoneNumber()) {
                subtotal.setText(String.format("$%.2f", storeOrders.get(i).getTotal()));
                tax.setText(String.format("$%.2f", storeOrders.get(i).getTotal() * Constants.TAX_RATE));
                total.setText(String.format("$%.2f", storeOrders.get(i).getTotal() + (MainActivity.order.getTotal() * Constants.TAX_RATE)));
            }
        }
    }
}