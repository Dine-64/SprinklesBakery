package com.example.sprinklesbakery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Order extends AppCompatActivity {

    private TextView nameTextView, emailTextView, addressTextView, contactNoTextView, amountTextView, quantityTextView;

    private Button ConfirmOrderButton;
    private DBHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        nameTextView = findViewById(R.id.txtNameView);
        emailTextView = findViewById(R.id.txtEmailView);
        contactNoTextView = findViewById(R.id.txtMobileNoView);
        addressTextView = findViewById(R.id.txtAddressView);
        amountTextView = findViewById(R.id.txtAmountView);
        quantityTextView = findViewById(R.id.txtQtView);
        ConfirmOrderButton = findViewById(R.id.btnconfirmOrd);
        databaseHelper = new DBHelper(this);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String email = intent.getStringExtra("email");
            String contactNumber = intent.getStringExtra("contactNumber");
            String address = intent.getStringExtra("address");
            String amount = intent.getStringExtra("amount");
            String quantity = intent.getStringExtra("quantity");

            nameTextView.setText(name);
            emailTextView.setText(email);
            contactNoTextView.setText(contactNumber);
            addressTextView.setText(address);
            amountTextView.setText(amount);
            quantityTextView.setText(quantity);

            ConfirmOrderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = nameTextView.getText().toString();
                    String email = emailTextView.getText().toString();
                    String contactNumber = contactNoTextView.getText().toString();
                    String address = addressTextView.getText().toString();
                    String amount = amountTextView.getText().toString();
                    String quantity = quantityTextView.getText().toString();

                    if (name.isEmpty() || email.isEmpty() || contactNumber.isEmpty() || address.isEmpty() || amount.isEmpty() || quantity.isEmpty()) {
                        Toast.makeText(Order.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean isInserted = databaseHelper.insertOrder(name, email, contactNumber, address, amount, quantity);
                        if (isInserted) {
                            Toast.makeText(Order.this, "Successfully placed the order", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(Order.this, OurCategory.class);
                            startActivity(homeIntent);
                            finish();

                        } else {
                            Toast.makeText(Order.this, "Failed to place orders", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            });
        }
    }
}
