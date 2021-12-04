package com.example.project5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity implements RecyclerAdapter.OnPizzaListener {

    private ArrayList<Pizza> order;
    private RecyclerView recyclerView;
    private TextView subtotalPrice;
    private TextView taxPrice;
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        order = MainActivity.order.getPizzaList();
        recyclerView = findViewById(R.id.recyclerView);
        subtotalPrice = findViewById(R.id.subtotalPriceLabel);
        taxPrice = findViewById(R.id.salesTaxPriceLabel);
        totalPrice = findViewById(R.id.totalPriceLabel);
        setPrices();
        setAdapter();
    }

    private void setPrices() {
        subtotalPrice.setText(String.format("$%.2f", MainActivity.order.getTotal()));
        taxPrice.setText(String.format("$%.2f", MainActivity.order.getTotal() * Constants.TAX_RATE));
        totalPrice.setText(String.format("$%.2f", MainActivity.order.getTotal() + (MainActivity.order.getTotal() * Constants.TAX_RATE)));
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(order, this);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    public void handlePlaceOrder(View vew)
    {
        MainActivity.storeOrder.addToStoreOrders(MainActivity.order);
        // TODO: close activity, lift phone number restriction in main
    }

    @Override
    public void onPizzaClick(int position) {
        MainActivity.order.removeFromOrder(order.get(position));
        setPrices();
        setAdapter();
    }
}