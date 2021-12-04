package com.example.project5;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity implements RecyclerAdapter.OnPizzaListener {

    private ArrayList<Pizza> order;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        order = MainActivity.order.getPizzaList();
        recyclerView = findViewById(R.id.recyclerView);
        setAdapter();
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
        Toast.makeText(getApplicationContext(), "Order Placed.",
                Toast.LENGTH_SHORT).show();
        // TODO: close activity, lift phone number restriction in main
    }

    @Override
    public void onPizzaClick(int position) {
        MainActivity.order.removeFromOrder(order.get(position));
        setAdapter();
    }
}