package com.example.phosphorlandapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView btn;
    private EditText inputUsernameRegister, inputEmailRegister, inputPasswordRegister, inputConfirmpassRegister;
    Button buttonforRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView alreadyhave=(TextView) findViewById(R.id.alreadyhave);
        inputUsernameRegister=findViewById(R.id.usernameregister);
        inputEmailRegister=findViewById(R.id.enteremail);
        inputPasswordRegister=findViewById(R.id.passwordregister);
        inputConfirmpassRegister=findViewById(R.id.passwordconfirmation);

        buttonforRegister=findViewById(R.id.registerbutton);
        buttonforRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredentials();
            }
        });

        alreadyhave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void checkCredentials() {
        String username=inputUsernameRegister.getText().toString();
        String email=inputEmailRegister.getText().toString();
        String password=inputPasswordRegister.getText().toString();
        String passwordConfim=inputConfirmpassRegister.getText().toString();

        if (username.isEmpty() || username.length()<7){
            showError(inputUsernameRegister, "Your username is not valid!");
        }
        else if (email.isEmpty() || !email.contains("@")){
            showError(inputEmailRegister, "Your email is not valid!");
        }
        else if (password.isEmpty() || password.length()<7){
            showError(inputPasswordRegister, "Your password must be at least 7 characters!");
        }
        else if (passwordConfim.isEmpty() || !passwordConfim.equals(password)){
            showError(inputConfirmpassRegister, "Your password does not match!");
        }
        else{
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }
    }

    private void showError(EditText inputUsernameRegister, String s) {
        inputUsernameRegister.setError(s);
    }
}