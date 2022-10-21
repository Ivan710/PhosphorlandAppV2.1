package com.example.phosphorlandapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {
private TextView addToCartBtn;
private TextView feeTxt, numberOrderTxt;
private ImageView plusBtn, minusBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        initVieW();
    }

    private void initVieW() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        feeTxt=findViewById(R.id.priceTxt);
    }
}