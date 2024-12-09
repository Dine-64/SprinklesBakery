package com.example.sprinklesbakery;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewOrder extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<String> name, email, contactNumber, address, amount, quantity;

    DBHelper dbHelper;

    Button btnOrdDone;

    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        dbHelper = new DBHelper(this);
        name = new ArrayList<>();
        email = new ArrayList<>();
        contactNumber = new ArrayList<>();
        address = new ArrayList<>();
        amount = new ArrayList<>();
        quantity = new ArrayList<>();

        recyclerView = findViewById(R.id.rclViewOrd);
        orderAdapter = new OrderAdapter(this, name, email, contactNumber, address, amount, quantity);
        recyclerView.setAdapter(orderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData() {
        Cursor cursor = dbHelper.getOrderData();
        if (cursor.getCount() == 0) {
            Toast.makeText(ViewOrder.this, "No Order Found", Toast.LENGTH_SHORT).show();
            return;
        }
        while (cursor.moveToNext()) {
            name.add(cursor.getString(0));
            email.add(cursor.getString(1));
            contactNumber.add(cursor.getString(2));
            address.add(cursor.getString(3));
            amount.add(cursor.getString(4));
            quantity.add(cursor.getString(5));

        }

    }

}
