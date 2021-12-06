package com.example.project5;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreOrdersActivity extends AppCompatActivity implements RecyclerAdapter.OnPizzaListener {

    private ArrayList<Order> storeOrders;
    private Spinner phoneList;
    private TextView subtotal;
    private TextView tax;
    private TextView total;
    private Button cancelOrderButton;
    private RecyclerView recyclerView;
    private TextView removeText;
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private Order currentOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        subtotal = findViewById(R.id.subtotalPrice);
        tax = findViewById(R.id.taxPrice);
        total = findViewById(R.id.totalPrice);
        phoneList= (Spinner) findViewById(R.id.phoneSpinner);
        recyclerView = findViewById(R.id.recyclerViewStore);

        setSpinner();
        setRecyclerAdapter();
        setPrices();
    }

    private void setSpinner() {

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

    public void setOrder()
    {
        pizzas = new ArrayList<Pizza>();
        for(int i=0; i <storeOrders.size(); i++) {
            if (phoneList.getSelectedItem().toString() == storeOrders.get(i).getPhoneNumber()) {
                pizzas = storeOrders.get(i).getPizzaList();
                currentOrder = storeOrders.get(i);
            }
        }
    }

    private void setRecyclerAdapter() {
        setOrder();
        RecyclerAdapter adapter = new RecyclerAdapter(pizzas, this);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onPizzaClick(int position) {
        MainActivity.order.removeFromOrder(pizzas.get(position));
        setPrices();
        setRecyclerAdapter();
    }

    public void handleCancelOrder(View view)
    {
        MainActivity.storeOrder.removeFromStoreOrders(currentOrder);
        setSpinner();
        setRecyclerAdapter();
    }
}