package com.example.sprinklesbakery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private Context context;
    private ArrayList<String> name, email, contactNumber, address, amount, quantity;

    public OrderAdapter(Context context, ArrayList<String> name, ArrayList<String> email, ArrayList<String> contactNumber, ArrayList<String> address, ArrayList<String> amount, ArrayList<String> quantity) {
        this.context = context;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.amount = amount;
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_orderadded, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.name.setText(name.get(position));
        holder.email.setText(email.get(position));
        holder.contactNumber.setText(contactNumber.get(position));
        holder.address.setText(address.get(position));
        holder.amount.setText(amount.get(position));
        holder.quantity.setText(quantity.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView name, email, address, contactNumber, amount, quantity;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameOrder);
            email = itemView.findViewById(R.id.emailOrder);
            address = itemView.findViewById(R.id.addressOrder);
            contactNumber = itemView.findViewById(R.id.conNoOrder);
            amount = itemView.findViewById(R.id.amountOrder);
            quantity = itemView.findViewById(R.id.quantityOrder);
        }
    }
}
