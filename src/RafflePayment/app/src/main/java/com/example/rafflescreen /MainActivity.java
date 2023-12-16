package com.example.rafflescreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    private PaymentSheet.CustomerConfiguration customerConfig;
    private String paymentIntentClientSecret;
    private PaymentSheet paymentSheet;

    Random random = new Random();
    boolean raffle1entered = false;
    boolean raffle2entered = false;
    boolean raffle3entered = false;

    private static final String STRIPE_PUBLISHABLE_KEY = "pk_test_51OJgWyJkxsEIdX6o7Mar2oj9sxYNCGg3rqyJvo0eOipwRdE2es0WBrxY4QvfDam1d3TnyLsUtTLIKl9OJ8BJoQu500kHW7eERW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Stripe SDK with your publishable key
        PaymentConfiguration.init(getApplicationContext(), STRIPE_PUBLISHABLE_KEY);
        // Initialize paymentSheet when the activity is created
        paymentSheet = new PaymentSheet(this, this::onPaymentSheetResult);

        TextView countdownText = findViewById(R.id.countdown_text);
        Button shoe1Bttn = findViewById(R.id.shoe1Bttn);
        Button shoe2Bttn = findViewById(R.id.shoe2Bttn);
        Button shoe3Bttn = findViewById(R.id.shoe3Bttn);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String targetDateString = "2023-12-15 18:40:30";
        Date targetDate;

        try {
            targetDate = sdf.parse(targetDateString);

            long currentTime = System.currentTimeMillis();
            assert targetDate != null;
            long targetTime = targetDate.getTime();
            long timeDifference = targetTime - currentTime;

            CountDownTimer timer = new CountDownTimer(timeDifference, 1000) {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTick(long millisUntilFinished) {
                    String formattedTime = formatTime(millisUntilFinished);
                    countdownText.setText("Time left: " + formattedTime);
                }

                @SuppressLint("SetTextI18n")
                @Override
                public void onFinish() {
                    shoe1Bttn.setEnabled(false);
                    shoe2Bttn.setEnabled(false);
                    shoe3Bttn.setEnabled(false);
                    countdownText.setText("Raffle Closed");

                    if (raffle1entered || raffle2entered || raffle3entered) {
                        raffleResults();
                    }
                }
            };

            timer.start();

        } catch (ParseException e) {
            e.printStackTrace();
        }

        shoe1Bttn.setOnClickListener(view -> handleRaffleEntry(shoe1Bttn, raffle1entered, "Raffle 1"));

        shoe2Bttn.setOnClickListener(v -> handleRaffleEntry(shoe2Bttn, raffle2entered, "Raffle 2"));

        shoe3Bttn.setOnClickListener(v -> handleRaffleEntry(shoe3Bttn, raffle3entered, "Raffle 3"));
    }

    private void handleRaffleEntry(Button button, boolean entered, String raffleName) {
        if (entered) {
            Toast.makeText(MainActivity.this, "You've already entered in " + raffleName + ".", Toast.LENGTH_SHORT).show();
        } else {
            setRaffleEntered(button, raffleName);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setRaffleEntered(Button button, String raffleName) {
        Toast.makeText(MainActivity.this, raffleName + " entered.", Toast.LENGTH_SHORT).show();
        button.setText("Entered");

        // Update the corresponding raffle flag
        switch (raffleName) {
            case "Raffle 1":
                raffle1entered = true;
                break;
            case "Raffle 2":
                raffle2entered = true;
                break;
            case "Raffle 3":
                raffle3entered = true;
                break;
        }
    }


    private void raffleResults() {
        int userEntry = getUserEntry(random);
        int winningNum = getWinningNum(random);

        if (winningNum == userEntry) {
            Toast.makeText(MainActivity.this, "Congratulations! You won!", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_win);
            Button winButton = findViewById(R.id.winButton);
            winButton.setVisibility(View.VISIBLE);

            winButton.setOnClickListener(view -> {
                // Fetch payment information and trigger payment when the win button is clicked
                if (paymentIntentClientSecret != null) {
                    paymentSheet.presentWithPaymentIntent(paymentIntentClientSecret, new PaymentSheet.Configuration("Example, Inc.", customerConfig));

                    // Fetch payment information
                    fetchPaymentApi();
                }

                // Move the openPaymentSheet() call here
                openPaymentSheet();
            });
        } else {
            Toast.makeText(MainActivity.this, "Sorry, maybe next time!", Toast.LENGTH_SHORT).show();
        }
    }



    public static int getUserEntry(Random random) {
        return 0;
    }
    // Generates a random winning number. I just changed the bounds to 1 so that it can always produce a winner to test payment
    public static int getWinningNum(Random random) {
        return 0;
    }



    private void openPaymentSheet() {
        if (paymentSheet != null) {
            if (paymentIntentClientSecret != null) {
                // Call openPaymentSheet when the payment button is clicked
                paymentSheet.presentWithPaymentIntent(paymentIntentClientSecret, new PaymentSheet.Configuration("Your Company", customerConfig));
                fetchPaymentApi();
            } else {
                // Fetch payment information if paymentIntentClientSecret is null
                fetchPaymentApi();
            }
        } else {
            Log.e("MainActivity", "paymentSheet is null");
            // Handle the error or show a toast to inform the user
            Toast.makeText(this, "Payment sheet initialization failed", Toast.LENGTH_SHORT).show();
        }
    }
    private void fetchPaymentApi() {
        // Replace the URL with your actual API endpoint
        String url = "https://us-central1-sneaker-5d3ae.cloudfunctions.net/Sneaker?amt=50";

        // Perform a network request to fetch payment
        // information
        // Use Volley, Retrofit, or any other networking library of your choice

        // Example using Volley
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONObject result = new JSONObject(response);
                        customerConfig = new PaymentSheet.CustomerConfiguration(
                                result.getString("customer"),
                                result.getString("ephemeralKey")
                        );
                        paymentIntentClientSecret = result.getString("paymentIntent");
                        PaymentConfiguration.init(getApplicationContext(), result.getString("publishableKey"));

                        // Present the PaymentSheet with fetched data
                        paymentSheet.presentWithPaymentIntent(paymentIntentClientSecret, new PaymentSheet.Configuration("Your Company", customerConfig));

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Failed to parse payment information", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    error.printStackTrace();
                    Toast.makeText(this, "Failed to fetch payment information", Toast.LENGTH_SHORT).show();
                });

        queue.add(stringRequest);
    }

    private void onPaymentSheetResult(final PaymentSheetResult paymentSheetResult) {
        // Handle the result of the PaymentSheet
        if (paymentSheetResult instanceof PaymentSheetResult.Canceled) {
            Toast.makeText(this, "Payment canceled", Toast.LENGTH_SHORT).show();
        } else if (paymentSheetResult instanceof PaymentSheetResult.Failed) {
            Toast.makeText(this, "Payment failed", Toast.LENGTH_SHORT).show();
        } else if (paymentSheetResult instanceof PaymentSheetResult.Completed) {
            // Payment successful, you can handle additional actions here if needed
            Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show();
        }
    }

    // Other methods and classes as needed

    // Formats time in 00:00:00
    private String formatTime(long millis) {
        long seconds = millis / 1000 % 60;
        long minutes = millis / (60 * 1000) % 60;
        long hours = millis / (60 * 60 * 1000);

        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
    }
}
