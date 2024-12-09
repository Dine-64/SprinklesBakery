package com.example.sprinklesbakery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThemedCupCakePage extends AppCompatActivity {


    private Button btn1, btn2, btn3, btn4;
    private TextView PriceTextview, PriceTextview2, PriceTextview3, PriceTextview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themed_cup_cake_page);

        PriceTextview = findViewById(R.id.txtpricethemed1);
        PriceTextview2 = findViewById(R.id.txtpricethemed2);
        PriceTextview3 = findViewById(R.id.txtpricethemed3);
        PriceTextview4 = findViewById(R.id.txtpricethemed4);

        btn1 = findViewById(R.id.btnthemedcakeone);
        btn2 = findViewById(R.id.btnthemedcaketwo);
        btn3 = findViewById(R.id.btnthemedcakethree);
        btn4 = findViewById(R.id.btnthemedcakefour);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = PriceTextview.getText().toString();
                navigateToCart(price);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = PriceTextview2.getText().toString();
                navigateToCart(price);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = PriceTextview3.getText().toString();
                navigateToCart(price);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = PriceTextview4.getText().toString();
                navigateToCart(price);
            }
        });
    }

    private void navigateToCart(String price) {
        Intent intent = new Intent(ThemedCupCakePage.this, ShippingDetails.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}
