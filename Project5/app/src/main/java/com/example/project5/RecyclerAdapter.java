package com.example.project5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Pizza> order;

    public RecyclerAdapter(ArrayList<Pizza> order)
    {
        this.order = order;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView orderText;
        private TextView priceText;

        public MyViewHolder(final View view)
        {
            super(view);
            orderText = view.findViewById(R.id.itemTextView);
            priceText = view.findViewById(R.id.priceTextView);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String pizza = order.get(position).toString();
        holder.orderText.setText(pizza);
        String price = String.format("$%.2f", order.get(position).price());
        holder.priceText.setText(price);

    }

    @Override
    public int getItemCount() {
        return order.size();
    }
}
