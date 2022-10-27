package com.example.phosphorlandapp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class PickFramboesaActivity extends AppCompatActivity {
    TextView textView;
    private ConstraintLayout layout584;
    boolean[] selectedVariety;
    ArrayList<Integer> langList = new ArrayList<>();
    String[] langArray = {"Chadmor", "Chemaines", "Otávia", "Paris", "Polka", "Tadmor", "Tulameen"};
    int minteger = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_framboesa);

        layout584 = findViewById(R.id.ConstraintLayout);
        layout584.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PickFramboesaActivity.this, OrderingActivity.class));
            }
        });

        textView = findViewById(R.id.textView);


        selectedVariety = new boolean[langArray.length];

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(PickFramboesaActivity.this);


                builder.setTitle("Select Variety");


                builder.setCancelable(false);

                builder.setMultiChoiceItems(langArray, selectedVariety, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        if (b) {

                            langList.add(i);

                            Collections.sort(langList);
                        } else {

                            langList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        StringBuilder stringBuilder = new StringBuilder();

                        for (int j = 0; j < langList.size(); j++) {

                            stringBuilder.append(langArray[langList.get(j)]);

                            if (j != langList.size() - 1) {

                                stringBuilder.append(", ");
                            }
                        }

                        textView.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        for (int j = 0; j < selectedVariety.length; j++) {

                            selectedVariety[j] = false;

                            langList.clear();

                            textView.setText("");
                        }
                    }
                });
                builder.show();
            }
        });
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


        switch (view.getId()) {
            case R.id.radio_pirates:
                if (checked)

                    break;
            case R.id.radio_ninjas:
                if (checked)

                    break;
        }
    }
}