package org.meicode.rafflescreennew.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import org.meicode.rafflescreennew.R;
import org.meicode.rafflescreennew.utils.model.ShoeItem;

public class DetailedActivity extends AppCompatActivity {

    private ImageView shoeImageView;
    private TextView shoeNameTV, shoeBrandNameTV, shoePriceTV;
    private AppCompatButton addToCartBtn;
    private ShoeItem shoe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        shoe = getIntent().getParcelableExtra("shoeItem");
        if (shoe != null) {
            setDataToWidgets();
        }

        initializeVariables();
    }
    private void setDataToWidgets() {
        shoeNameTV.setText(shoe.getShoeName());
        shoeBrandNameTV.setText(shoe.getShoeBrandName());
        shoePriceTV.setText(String.valueOf(shoe.getShoePrice()));
        shoeImageView.setImageResource(shoe.getShoeImage());

    }

    private void initializeVariables(){
        shoeImageView = findViewById(R.id.detailActivityShoeIV);
        shoeNameTV = findViewById(R.id.detailActivityShoeNameTv);
        shoeBrandNameTV = findViewById(R.id.detailActivityShoeBrandNameTv);
        shoePriceTV = findViewById(R.id.detailActivityShoePriceTv);
        addToCartBtn = findViewById(R.id.detailActivityAddToCartBtn);

    }
}
