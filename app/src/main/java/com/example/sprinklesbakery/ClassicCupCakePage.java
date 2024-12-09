package com.example.sprinklesbakery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClassicCupCakePage extends AppCompatActivity {


    private Button btn1, btn2, btn3, btn4;
    private TextView PriceTextview, PriceTextview2, PriceTextview3, PriceTextview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_cup_cake_page);

        PriceTextview = findViewById(R.id.txtpriceclassic1);
        PriceTextview2 = findViewById(R.id.txtpriceclassic2);
        PriceTextview3 = findViewById(R.id.txtpriceclassic3);
        PriceTextview4 = findViewById(R.id.ttxtpriceclassic4);

        btn1 = findViewById(R.id.btnclassiccakeone);
        btn2 = findViewById(R.id.btnclassiccaketwos);
        btn3 = findViewById(R.id.btnclassiccakethree);
        btn4 = findViewById(R.id.btnclassiccakefour);

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
        Intent intent = new Intent(ClassicCupCakePage.this, ShippingDetails.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}