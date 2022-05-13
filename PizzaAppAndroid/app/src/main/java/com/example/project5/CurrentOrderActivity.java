package com.example.project5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Activity to display and handle the current order screen
 * Contains recycler view to display pizzas in the order,
 * Customer phone number, and price information of order
 * @author Nicholas Triano, Antonio Ignarra
 */
public class CurrentOrderActivity extends AppCompatActivity implements RecyclerAdapter.OnPizzaListener {

    private ArrayList<Pizza> order;
    private RecyclerView recyclerView;
    private TextView subtotalPrice;
    private TextView taxPrice;
    private TextView totalPrice;
    private TextView phone;

    /**
     * Method called on creation of the activity, sets layout of screen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        order = MainActivity.order.getPizzaList();
        recyclerView = findViewById(R.id.recyclerView);
        subtotalPrice = findViewById(R.id.subtotalPriceLabel);
        taxPrice = findViewById(R.id.salesTaxPriceLabel);
        totalPrice = findViewById(R.id.totalPriceLabel);
        phone = findViewById(R.id.phoneNumberText);
        Bundle b = getIntent().getExtras();
        String phoneReceiver = b.getString("phone_number");
        phone.setText(phoneReceiver);
        setPrices();
        setAdapter();
    }

    /**
     * sets the price texts for the current order
     */
    private void setPrices() {
        subtotalPrice.setText(String.format("$%.2f", MainActivity.order.getTotal()));
        taxPrice.setText(String.format("$%.2f", MainActivity.order.getTotal() * Constants.TAX_RATE));
        totalPrice.setText(String.format("$%.2f", MainActivity.order.getTotal() + (MainActivity.order.getTotal() * Constants.TAX_RATE)));
    }

    /**
     * Sets the adapter for the recycler view
     */
    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(order, this);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    /**
     * method called when place order button is pressed
     * @param vew button that was pressed
     */
    public void handlePlaceOrder(View vew)
    {
        MainActivity.storeOrder.addToStoreOrders(MainActivity.order);
        MainActivity.phoneEditable = true;
        MainActivity.orderStarted = false;
        Toast.makeText(getApplicationContext(),
                "Order added to store orders.", Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * method called when remove button is clicked, removes pizza from order list
     * @param position
     */
    @Override
    public void onPizzaClick(int position) {
        MainActivity.order.removeFromOrder(order.get(position));
        setPrices();
        setAdapter();
    }
}