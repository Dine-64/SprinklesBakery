package com.example.sprinklesbakery;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sprinklesbakery.databinding.ActivityShippingDetailsBinding;


public class ShippingDetails extends AppCompatActivity {

    private EditText nameEditText, emailEditText, contactNumberEditText, addressEditText, quantityEditText;
    private Button submitBtnCart;

    private TextView amountTextView;
    private String name, email, contactNumber, address, amount, quantity;

    ActivityShippingDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShippingDetailsBinding .inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        amountTextView = binding.txtAmountViewCart;
        Intent intent = getIntent();
        String price = intent.getStringExtra("price");

        amountTextView.setText("Amount : " + price);
        nameEditText = findViewById(R.id.txtEname);
        emailEditText = findViewById(R.id.txtEtEmail);
        contactNumberEditText = findViewById(R.id.txtEMobileNo);
        addressEditText = findViewById(R.id.txtEAddress);
        quantityEditText = findViewById(R.id.txtQtCart);
        submitBtnCart = findViewById(R.id.btnSubmitCart);

        submitBtnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEditText.getText().toString();
                email = emailEditText.getText().toString();
                contactNumber = contactNumberEditText.getText().toString();
                address = addressEditText.getText().toString();
                amount = amountTextView.getText().toString();
                quantity = quantityEditText.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(contactNumber) || TextUtils.isEmpty(address) || TextUtils.isEmpty(amount) || TextUtils.isEmpty(quantity)) {
                    Toast.makeText(ShippingDetails.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (isValidEmail(email)) {
                        Intent intent = new Intent(ShippingDetails.this, Order.class);
                        intent.putExtra("name", name);
                        intent.putExtra("email", email);
                        intent.putExtra("contactNumber", contactNumber);
                        intent.putExtra("address", address);
                        intent.putExtra("amount", amount);
                        intent.putExtra("quantity", quantity);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ShippingDetails.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}

