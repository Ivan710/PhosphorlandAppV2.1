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
        constraintLayout11=findViewById(R.id.constraintLayout11);
        constraintLayout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintLayout11.setBackgroundColor(Color.GRAY);
            }
        });
        constraintLayout12=findViewById(R.id.constraintLayout12);
        constraintLayout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintLayout12.setBackgroundColor(Color.GRAY);
            }
        });
    }
}