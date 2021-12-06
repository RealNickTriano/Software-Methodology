package com.example.project5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Adapter class for recycler view sets view holder and on click listener
 * @author Nicholas Triano, Antonio Ignarra
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Pizza> order;
    private TextView removeText;
    private OnPizzaListener mOnPizzaListener;

    public RecyclerAdapter(ArrayList<Pizza> order, OnPizzaListener OnPizzaListener)
    {
        this.order = order;
        this.mOnPizzaListener = OnPizzaListener;
    }

    public interface OnPizzaListener {
        void onPizzaClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView orderText;
        private TextView priceText;
        OnPizzaListener onPizzaListener;

        public MyViewHolder(final View view, OnPizzaListener onPizzaListener)
        {
            super(view);
            orderText = view.findViewById(R.id.itemTextView);
            priceText = view.findViewById(R.id.priceTextView);
            removeText = view.findViewById(R.id.removeText);
            this.onPizzaListener = onPizzaListener;
            removeText.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPizzaListener.onPizzaClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView, mOnPizzaListener);
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
