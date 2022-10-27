package com.example.phosphorlandapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class OrderingActivity extends AppCompatActivity {
private ConstraintLayout constraintLayout2;
private ConstraintLayout constraintLayout11;
private ConstraintLayout constraintLayout12;
private ConstraintLayout constraintLayout4;
private ConstraintLayout constraintLayout5;
private ConstraintLayout constraintLayout3;
private ConstraintLayout constraintLayout7;
private ConstraintLayout constraintLayout6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);

        constraintLayout2=findViewById(R.id.constraintLayout2);
        constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderingActivity.this, PickMirtiloActivity.class));
            }
        });
        constraintLayout4=findViewById(R.id.constraintLayout4);
        constraintLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderingActivity.this, PickFramboesaActivity.class));

            }
        });
        constraintLayout3=findViewById(R.id.constraintLayout3);
        constraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderingActivity.this, OrderOtherActivity.class));
                OrderOtherActivity.tekst="Deliver Amora";
            }
        });
        constraintLayout5=findViewById(R.id.constraintLayout5);
        constraintLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderingActivity.this, OrderOtherActivity.class));
                OrderOtherActivity.tekst="Deliver Groselha";
            }
        });
        constraintLayout6=findViewById(R.id.constraintLayout6);
        constraintLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderingActivity.this, OrderOtherActivity.class));
                OrderOtherActivity.tekst="Deliver Morango";
            }
        });
        constraintLayout7=findViewById(R.id.constraintLayout7);
        constraintLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderingActivity.this, OrderOtherActivity.class));
                OrderOtherActivity.tekst="Deliver Goji";
            }
        });
    }
}