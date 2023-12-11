package org.meicode.rafflescreennew;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import org.meicode.rafflescreennew.databinding.ActivityMainBinding;
import org.meicode.rafflescreennew.utils.adapter.ShowItemAdapter;
import org.meicode.rafflescreennew.utils.model.ShoeCart;
import org.meicode.rafflescreennew.utils.model.ShoeItem;
import org.meicode.rafflescreennew.view.CartActivity;
import org.meicode.rafflescreennew.view.DetailedActivity;
import org.meicode.rafflescreennew.viewmodel.CartViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ShowItemAdapter.ShoeClickedListeners {

    private RecyclerView recyclerView;
    private List<ShoeItem> shoeItemList;
    private ShowItemAdapter adapter;
    private CartViewModel viewModel;
    private List<ShoeCart> shoeCartList;
    private CoordinatorLayout coordinatorLayout;
    private ImageView cartImageView;

    private ActivityMainBinding binding;

    private EditText editTextEmail, editTextPassword;
    private Button loginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //original code

        setContentView(R.layout.activity_main_screen1);
        //setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        setContentView(R.layout.fragment_home);


        mAuth = FirebaseAuth.getInstance();
//        editTextEmail = findViewById(R.id.email);
//        editTextPassword = findViewById(R.id.password);
//        loginButton = findViewById(R.id.loginButton);


// Set up RecyclerView and adapter
        recyclerView = binding.mainRecyclerView; // Use binding object to reference views
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        adapter = new ShowItemAdapter(this);
        recyclerView.setAdapter(adapter);

        cartImageView = binding.cartIv; // Use binding object to reference views
        coordinatorLayout = binding.coordinatorLayout; // Use binding object to reference views

        initializeVariables();
        setUpList();

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);

        // Set up RecyclerView and adapter
        //recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        adapter.setShoeItemList(shoeItemList);
        recyclerView.setAdapter(adapter);

        cartImageView.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();

        viewModel.getAllCartItems().observe(this, shoeCarts -> shoeCartList.addAll(shoeCarts));
    }

    // sets up items to be displayed on the device
    private void setUpList() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy", Locale.US);
        Date releaseDate1 = parseDate("25/11/23", dateFormat);
        Date releaseDate2 = parseDate("29/11/23", dateFormat);
        Date releaseDate3 = parseDate("09/12/23", dateFormat);
        Date releaseDate4 = parseDate("11/12/23", dateFormat);
        Date releaseDate5 = parseDate("30/12/23", dateFormat);

        shoeItemList.add(new ShoeItem("New Balance 2002r Protection Pack Purple", "Nike", R.drawable.__ccb10249_2702_4b4f_87d2_de9809363657_540x, 130, releaseDate1));
        shoeItemList.add(new ShoeItem("Travis Scott 1 Fragment", "Jordan", R.drawable.ipad_travis_scott_x_fragment_x_air_jordan_1_high_og_military_blue, 160, releaseDate2));
        shoeItemList.add(new ShoeItem("Travis Scott Air Jordan 1 Mocha", "Jordan", R.drawable.travis_scott_x_air_jordan_1_retro_high_og, 160, releaseDate3));
        shoeItemList.add(new ShoeItem("Nike Air Force 1 Blue Void", "Nike", R.drawable._2nikmrfrc107lv8fmns_sail_blue_void, 90, releaseDate4));
        shoeItemList.add(new ShoeItem("Nike Low Blazers Black and White Sail", "Nike", R.drawable._1nikmblzrlw77vntmns_black_white_sail, 90, releaseDate5));
    }

    private Date parseDate(String dateString, SimpleDateFormat dateFormat) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Return null in case of parsing failure
        }
    }

    private void initializeVariables() {

        cartImageView = findViewById(R.id.cartIv);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        shoeCartList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        shoeItemList = new ArrayList<>();
        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        adapter = new ShowItemAdapter(this);
    }

    @Override
    public void onCardClicked(ShoeItem shoe) {

        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra("shoeItem", shoe);
        startActivity(intent);
    }

    //was originally override
    //@Override
    public void onAddToCartBtnClicked(ShoeItem shoeItem) {
        ShoeCart shoeCart = new ShoeCart();
        shoeCart.setShoeName(shoeItem.getShoeName());
        shoeCart.setShoeBrandName(shoeItem.getShoeBrandName());
        shoeCart.setShoePrice(shoeItem.getShoePrice());
        shoeCart.setShoeImage(shoeItem.getShoeImage());

        final int[] quantity = {1};
        final int[] id = new int[1];

        if (!shoeCartList.isEmpty()) {
            for (int i = 0; i < shoeCartList.size(); i++)  {
                if (shoeCart.getShoeName().equals(shoeCartList.get(i).getShoeName())) {
                    quantity[0] = shoeCartList.get(i).getQuantity();
                    quantity[0]++;
                    id[0] = shoeCartList.get(i).getId();
                }
            }
        }

       // Log.d("TAG", "onAddToCartBtnClicked: " + quantity[0]);

        if (quantity[0] == 1) {
            shoeCart.setQuantity(quantity[0]);
            shoeCart.setTotalItemPrice(quantity[0] * shoeCart.getShoePrice());
            viewModel.insertCartItem(shoeCart);
        } else {
            viewModel.updateQuantity(id[0], quantity[0]);
            viewModel.updatePrice(id[0], quantity[0] * shoeCart.getShoePrice());
        }

        makeSnackBar();
    }

    private void makeSnackBar() {
        Snackbar.make(coordinatorLayout, "Item Added To Cart", Snackbar.LENGTH_SHORT)
                .setAction("Go to Cart", view -> startActivity(new Intent(MainActivity.this, CartActivity.class))).show();
    }
}


/*binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);// not working
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
*/
