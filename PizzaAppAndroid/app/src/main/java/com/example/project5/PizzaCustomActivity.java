package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

/**
 * Activity to display and handle the pizza customization screen
 * contains image of pizza to customize, chip group of toppings,
 * size selection radio group, and price of pizza
 * @author Nicholas Triano, Antonio Ignarra
 */
public class PizzaCustomActivity extends AppCompatActivity {

    private ImageView pizzaImage;
    private String pizzaType;
    private ChipGroup toppingsGroup;
    private RadioGroup sizeRadio;
    private RadioButton smallRadio;
    private RadioButton mediumRadio;
    private RadioButton largeRadio;
    private TextView priceText;

    /**
     * Method called on creation of the activity, sets layout of screen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_custom_acitivity);
        Intent intent = getIntent();
        pizzaType = intent.getStringExtra("image");
        pizzaImage = findViewById(R.id.pizzaImage);
        sizeRadio = findViewById(R.id.sizeRadioGroup);
        toppingsGroup = findViewById(R.id.toppingsChipGroup);
        smallRadio = findViewById(R.id.smallRadioButton);
        mediumRadio = findViewById(R.id.mediumRadioButton);
        largeRadio = findViewById(R.id.largeRadioButton);
        priceText = findViewById(R.id.priceText);
        //pizza = intent.getParcelableExtra("pizza");
        setDefaults(pizzaType);
    }

    /**
     * set the default values of the price, toppings, and image
     * @param pizzaType
     */
    public void setDefaults(String pizzaType)
    {
        smallRadio.setChecked(true);

        if (pizzaType.equals("Pepperoni"))
        {
            pizzaImage.setImageResource(R.drawable.pepperoni);
            toppingsGroup.check(R.id.pepperoniChip);
        }
        else if (pizzaType.equals("Deluxe"))
        {
            pizzaImage.setImageResource(R.drawable.deluxe);
            toppingsGroup.check(R.id.sausageChip);
            toppingsGroup.check(R.id.greenPepperChip);
            toppingsGroup.check(R.id.mushroomChip);
            toppingsGroup.check(R.id.onionChip);
            toppingsGroup.check(R.id.pepperoniChip);
        }
        else if (pizzaType.equals("Hawaiian"))
        {
            pizzaImage.setImageResource(R.drawable.hawaiian);
            toppingsGroup.check(R.id.hamChip);
            toppingsGroup.check(R.id.pineappleChip);
        }

        priceText.setText(String.format("$%.2f", MainActivity.pizza.price()));
    }

    /**
     * handles add to order button, finishes this view shows toast message, adds pizza to order
     * @param view button pressed
     */
    public void handleAddToOrder(View view)
    {
        MainActivity.order.addToOrder(MainActivity.pizza);
        Toast.makeText(getApplicationContext(),
                "Pizza added to order.", Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * handles sets toppings on a chip is clicked, calculates price
     * @param view button pressed
     */
    public void handleChipClick(View view)
    {
        List<Integer> chips = toppingsGroup.getCheckedChipIds();
        MainActivity.pizza.removeAll();
        for (int i = 0; i < chips.size(); i++) {
            Chip chip = toppingsGroup.findViewById(chips.get(i));
            MainActivity.pizza.addTopping(Toppings.valueOf(chip.getText().toString()));
        }
        priceText.setText(String.format("$%.2f", MainActivity.pizza.price()));
    }

    /**
     * handles size of pizza that was selected, recalculates price
     * @param view button pressed
     */
    public void handleSizeSelect(View view)
    {
        RadioButton button = findViewById(sizeRadio.getCheckedRadioButtonId());
        MainActivity.pizza.setSize(Size.valueOf(button.getText().toString()));
        priceText.setText(String.format("$%.2f", MainActivity.pizza.price()));
    }
}