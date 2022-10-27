package com.example.phosphorlandapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderOtherActivity extends AppCompatActivity {
    TextView textView;
    public static String tekst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_other);

        textView=(TextView)findViewById(R.id.title);
        textView.setText(tekst);
    }
}