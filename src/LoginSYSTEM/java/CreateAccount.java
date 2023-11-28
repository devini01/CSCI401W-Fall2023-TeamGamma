package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Patterns;



public class CreateAccount extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        EditText email = (EditText) findViewById(R.id.email);
        EditText createPass1 = (EditText) findViewById(R.id.createPass1);
        EditText createPass2 = (EditText)  findViewById(R.id.createPass2);
        TextView alreadyHaveAcc = (TextView) findViewById(R.id.alreadyHaveAcc);
        TextView createButton = (TextView) findViewById(R.id.createButton);

        // When user clicks on "Create Account":
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if entered passwords match and email is valid, account is created
                if(createPass1.getText().toString().equals(createPass2.getText().toString()) && validateEmail(email)) {
                    Toast.makeText(CreateAccount.this, "Account Created. Please Login.", Toast.LENGTH_SHORT).show();
                    // user is then redirected to main
                    Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                    startActivity(intent);
                        // if passwords do not match and/or email is invalid, user is notified
                }else
                    Toast.makeText(CreateAccount.this, "Account Creation Failed. Please Check Fields.", Toast.LENGTH_SHORT).show();
                }
        });

        // When user clicks on "Already Have an Account?", screen switches to main screen
        alreadyHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Checks whether or not user's email is in a valid format
    private boolean validateEmail(EditText email) {
        String emailInput = email.getText().toString();

        // if email is in valid format, email is accepted
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;

            // if email is in an invalid format, user is notified
        } else {
            Toast.makeText(this, "Invalid Email.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
