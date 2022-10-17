package com.example.phosphorlandapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText inputUsername, inputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);
        inputUsername=findViewById(R.id.username);
        inputPassword=findViewById(R.id.password);

        TextView noacc=(TextView) findViewById(R.id.noaccount);

        noacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        //admin
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkCredentials();
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, OrderingActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void checkCredentials() {
        String username=inputUsername.getText().toString();
        String password=inputPassword.getText().toString();

        if (username.isEmpty() || username.length()<7){
            showError(inputUsername, "Your username is not valid!");
        }
        else if (password.isEmpty() || password.length()<7){
            showError(inputPassword, "Your password must be at least 7 characters!");
        }
        else{
            startActivity(new Intent(LoginActivity.this, OrderingActivity.class));
        }
    }

    private void showError(EditText inputUsernameRegister, String s) {
        inputUsernameRegister.setError(s);
    }
}