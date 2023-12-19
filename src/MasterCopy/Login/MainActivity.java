package org.meicode.rafflescreennew;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import org.meicode.rafflescreennew.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    EditText editTextEmail, editTextPassword;
    Button loginButton; // Initializes the login button
    FirebaseAuth mAuth; // Creates an object to reference the database


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance(); // Get an instance of the database

        editTextEmail = findViewById(R.id.email); // Email and password are initialized from the @email and @password in the activity_home.xml
        editTextPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton); // Login button from the activity_home

        loginButton.setOnClickListener(v -> { // Receives the input from the @email and @password in the activity_home.xml
            String email, password;
            email = String.valueOf(editTextEmail.getText());
            password = String.valueOf(editTextPassword.getText());

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        //This is where it is important to change the class to whatever the raffle screen is
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), AdapterClass.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        TextView forgotPass = findViewById(R.id.forgotPass);
        TextView createAcc = findViewById(R.id.createAcc);
        // When user clicks on "Forgot Password?", screen switches to forgotpass screen
        forgotPass.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForgotpassActivity.class);
            startActivity(intent);
        });

        // When the user clicks "Create an Account", screen switches to create_account screen
        createAcc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateAccount.class);
            startActivity(intent);
        });
    }}
