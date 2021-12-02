package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.ChipGroup;

public class PizzaCustomActivity extends AppCompatActivity {

    private ImageView pizzaImage;
    private String pizzaType;
    private ChipGroup toppingsGroup;
    private RadioButton smallRadio;
    private RadioButton mediumRadio;
    private RadioButton largeRadio;
    private TextView priceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_custom_acitivity);
        Intent intent = getIntent();
        pizzaType = intent.getStringExtra("image");
        pizzaImage = findViewById(R.id.pizzaImage);
        toppingsGroup = findViewById(R.id.toppingsChipGroup);
        smallRadio = findViewById(R.id.smallRadioButton);
        mediumRadio = findViewById(R.id.mediumRadioButton);
        largeRadio = findViewById(R.id.largeRadioButton);
        priceText = findViewById(R.id.priceText);
        //pizza = intent.getParcelableExtra("pizza");
        setDefaults(pizzaType);
    }

    public void setDefaults(String pizzaType)
    {
        smallRadio.setChecked(true);

        if (pizzaType.equals("Pepperoni"))
        {
            pizzaImage.setImageResource(R.drawable.pepperoni);
            toppingsGroup.check(R.id.pepperoniChip);
            toppingsGroup.check(R.id.cheeseChip);
        }
        else if (pizzaType.equals("Deluxe"))
        {
            pizzaImage.setImageResource(R.drawable.deluxe);
            toppingsGroup.check(R.id.cheeseChip);
            toppingsGroup.check(R.id.sausageChip);
            toppingsGroup.check(R.id.greenPepperChip);
            toppingsGroup.check(R.id.mushroomChip);
            toppingsGroup.check(R.id.onionChip);
            toppingsGroup.check(R.id.pepperoniChip);
        }
        else if (pizzaType.equals("Hawaiian"))
        {
            pizzaImage.setImageResource(R.drawable.hawaiian);
            toppingsGroup.check(R.id.cheeseChip);
            toppingsGroup.check(R.id.hamChip);
            toppingsGroup.check(R.id.pineappleChip);
        }

        priceText.setText(String.valueOf(MainActivity.pizza.price()));
    }

    public void handleAddToOrder(View view)
    {
        MainActivity.order.addToOrder(MainActivity.pizza);
        Toast.makeText(getApplicationContext(),
                "Pizza added to order.", Toast.LENGTH_SHORT).show();
        finish();
    }

}