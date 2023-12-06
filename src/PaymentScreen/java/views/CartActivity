package com.codingstuff.shoeapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.codingstuff.shoeapp.R;
import com.codingstuff.shoeapp.utils.adapter.CartAdapter;
import com.codingstuff.shoeapp.utils.model.ShoeCart;
import com.codingstuff.shoeapp.viewmodel.CartViewModel;

import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.CartClickedListeners {

    // Variable declarations for UI components and view model
    private RecyclerView recyclerView;
    private CartViewModel cartViewModel;
    private TextView totalCartPriceTv, textView;
    private AppCompatButton checkoutBtn;
    private CardView cardView;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize UI components
        initializeVariables();

        // Retrieve and check if the paymentSuccess flag is passed from the previous activity
        boolean paymentSuccess = getIntent().getBooleanExtra("paymentSuccess", false);
        Log.d("CartActivity", "Payment success: " + paymentSuccess);

        // If payment is successful, show the order confirmation view
        if (paymentSuccess) {
            // Hide checkout elements and show confirmation
            textView.setVisibility(View.INVISIBLE);
            checkoutBtn.setVisibility(View.INVISIBLE);
            totalCartPriceTv.setVisibility(View.INVISIBLE);
          recyclerView.setVisibility(View.INVISIBLE); // To hide the cart list
            cardView.setVisibility(View.VISIBLE); // Show the order confirmation card
        } else {
            // If payment is not successful, display the cart items
            cartViewModel.getAllCartItems().observe(this, new Observer<List<ShoeCart>>() {
                @Override
                public void onChanged(List<ShoeCart> shoeCarts) {
                    double price = 0;
                    cartAdapter.setShoeCartList(shoeCarts);
                    for (int i = 0; i < shoeCarts.size(); i++) {
                        price += shoeCarts.get(i).getTotalItemPrice();
                    }
                    totalCartPriceTv.setText(String.valueOf(price));
                }
            });
        }
        // Set an OnClickListener for the checkout button
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the OrderConfirmationActivity (i.e payment screen)
                Intent intent = new Intent(CartActivity.this, OrderConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to initialize UI components
    private void initializeVariables() {
        cartAdapter = new CartAdapter(this);
        textView = findViewById(R.id.textView2);
        cardView = findViewById(R.id.cartActivityCardView);
        totalCartPriceTv = findViewById(R.id.cartActivityTotalPriceTv);
        checkoutBtn = findViewById(R.id.cartActivityCheckoutBtn);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);
    }

    @Override
    public void onDeleteClicked(ShoeCart shoeCart) {
        cartViewModel.deleteCartItem(shoeCart);
    }

    @Override
    public void onPlusClicked(ShoeCart shoeCart) {
        int quantity = shoeCart.getQuantity() + 1;
        cartViewModel.updateQuantity(shoeCart.getId(), quantity);
        cartViewModel.updatePrice(shoeCart.getId(), quantity * shoeCart.getShoePrice());
        cartAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMinusClicked(ShoeCart shoeCart) {
        int quantity = shoeCart.getQuantity() - 1;
        if (quantity != 0) {
            cartViewModel.updateQuantity(shoeCart.getId(), quantity);
            cartViewModel.updatePrice(shoeCart.getId(), quantity * shoeCart.getShoePrice());
            cartAdapter.notifyDataSetChanged();
        } else {
            cartViewModel.deleteCartItem(shoeCart);
        }
    }
}
