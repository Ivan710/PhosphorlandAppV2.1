package com.example.phosphorlandapp2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Collections;;

public class PickMirtiloActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout5555;
    Boolean isPickUp;
    Boolean isDelivery;
    TextView textView;
    boolean[] selectedVariety;
    ArrayList<Integer> langList = new ArrayList<>();
    int minteger = 0;
    String[] langArray = {"Aurora"," Bluecrop", "Bluejay", "Brigitta", "Camélia", "Chandler", "Darrow", "Draper", "Duke", "Eliot", "Reka", "Goldtraube", "Legacy", "Liberty", "Nelson", "O’Neal", "Ozarkblue", "Spartan", "Star"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_mirtilo);

        constraintLayout5555=findViewById(R.id.ConstraintLayout);
        constraintLayout5555.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PickMirtiloActivity.this, OrderingActivity.class));
            }
        });
        Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PickMirtiloActivity.this, DeliveryActivity.class));
            }
        });

        // assign variable
        textView = findViewById(R.id.textView);

        // initialize selected language array
        selectedVariety = new boolean[langArray.length];

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(PickMirtiloActivity.this);

                // set title
                builder.setTitle("Select Variety");

                // set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(langArray, selectedVariety, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // check condition
                        if (b) {
                            // when checkbox selected
                            // Add position  in lang list
                            langList.add(i);
                            // Sort array list
                            Collections.sort(langList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            langList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        // use for loop
                        for (int j = 0; j < langList.size(); j++) {
                            // concat array value
                            stringBuilder.append(langArray[langList.get(j)]);
                            // check condition
                            if (j != langList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(", ");
                            }
                        }
                        // set text on textView
                        textView.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // use for loop
                        for (int j = 0; j < selectedVariety.length; j++) {
                            // remove all selection
                            selectedVariety[j] = false;
                            // clear language list
                            langList.clear();
                            // clear text view value
                            textView.setText("");
                        }
                    }
                });
                // show dialog
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
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    isPickUp=true;
                    isDelivery=false;
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    isPickUp=false;
                    isDelivery=true;
                    break;
        }
    }
    public void finishButton(View view)
    {
        if (isPickUp && minteger>0)
            startActivity(new Intent(PickMirtiloActivity.this, PickUpActivity.class));
        if (isDelivery && minteger>0)
            startActivity((new Intent(PickMirtiloActivity.this, DeliveryActivity.class)));

    }

}

