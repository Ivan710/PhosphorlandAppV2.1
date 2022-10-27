package com.example.phosphorlandapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class OrderOtherActivity extends AppCompatActivity {
    TextView textView;
    private ConstraintLayout constraintLayout5555;
    public static String tekst;
    int minteger = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_other);
        constraintLayout5555=findViewById(R.id.ConstraintLayout);
        constraintLayout5555.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderOtherActivity.this, OrderingActivity.class));
            }
        });


        textView=(TextView)findViewById(R.id.title);
        textView.setText(tekst);
    }
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        if (minteger <= 0)
            minteger = 0;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number + " kg");
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)

                    break;
            case R.id.radio_ninjas:
                if (checked)
                    break;
        }
    }
}