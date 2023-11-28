package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText email =(EditText) findViewById(R.id.email);
        EditText password = (EditText)  findViewById(R.id.password);
        TextView forgotPass = (TextView) findViewById(R.id.forgotPass);
        TextView createAcc = (TextView) findViewById(R.id.createAcc);
        Button loginButton = (Button) findViewById(R.id.loginButton);

        // When user clicks on Login button:
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if email and password entered are valid, user is notified that login was successful
                if(email.getText().toString().equals("user@example.com") && password.getText().toString().equals("user")) {
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    // if not valid, user is notified that email or password in incorrect
                }else
                    Toast.makeText(MainActivity.this, "EMAIL OR PASSWORD IS INCORRECT", Toast.LENGTH_SHORT).show();
            }
        });

        // When user clicks on "Forgot Password?", screen switches to forgotpass screen
       forgotPass.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, ForgotpassActivity.class);
               startActivity(intent);
           }
       });

       // When the user clicks "Create an Account", screen switches to create_account screen
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(intent);
            }
        });
    }
}
