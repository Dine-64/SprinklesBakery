package com.example.sprinklesbakery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ValentineCupCakePage extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4;
    private TextView PriceTextview, PriceTextview2, PriceTextview3, PriceTextview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valentine_cup_cake_page);

        PriceTextview = findViewById(R.id.txtpricevalentine1);
        PriceTextview2 = findViewById(R.id.txtpricevalentine2);
        PriceTextview3 = findViewById(R.id.txtpricevalentine3);
        PriceTextview4 = findViewById(R.id.txtpricevalentine4);

        btn1 = findViewById(R.id.btnvalentinecakeone);
        btn2 = findViewById(R.id.btnvalentinecaketwo);
        btn3 = findViewById(R.id.btnvalentinecakethree);
        btn4 = findViewById(R.id.btnvalentinecakefour);

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
        Intent intent = new Intent(ValentineCupCakePage.this, ShippingDetails.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}