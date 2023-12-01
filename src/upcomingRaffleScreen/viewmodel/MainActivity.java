package org.meicode.rafflescreennew;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.meicode.rafflescreennew.databinding.ActivityMainBinding;
import org.meicode.rafflescreennew.utils.adapter.ShowItemAdapter;
import org.meicode.rafflescreennew.utils.model.ShoeItem;
import org.meicode.rafflescreennew.view.DetailedActivity;

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

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        setUpList();

        adapter.setShoeItemList(shoeItemList);
        recyclerView.setAdapter(adapter);

       /* binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        */
    }


    //sets up items to be displayed on the device
    private void setUpList(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy", Locale.US);
        Date releaseDate1 = parseDate("25/11/23", dateFormat);
        Date releaseDate2 = parseDate("29/11/23", dateFormat);
        Date releaseDate3 = parseDate("09/12/23", dateFormat);
        Date releaseDate4 = parseDate("11/12/23", dateFormat);
        Date releaseDate5 = parseDate("30/12/23", dateFormat);



        shoeItemList.add(new ShoeItem("New Balance 2002r Protection Pack Purple", "Nike", R.drawable.__ccb10249_2702_4b4f_87d2_de9809363657_540x, 130, releaseDate1));
       shoeItemList.add(new ShoeItem("Travis Scott 1 Fragment", "Jordan", R.drawable.ipad_travis_scott_x_fragment_x_air_jordan_1_high_og_military_blue, 160,releaseDate2));
       shoeItemList.add(new ShoeItem("Travis Scott Air Jordan 1 Mocha", "Jordan", R.drawable.travis_scott_x_air_jordan_1_retro_high_og, 160,releaseDate3));
        shoeItemList.add(new ShoeItem("Nike Air Force 1 Blue Void", "Nike", R.drawable._2nikmrfrc107lv8fmns_sail_blue_void, 90,releaseDate4 ));
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
    private void initializeVariables(){

        shoeItemList = new ArrayList<>();
        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1 ));

        adapter = new ShowItemAdapter(this);
    }

    @Override
    public void onCardClicked(ShoeItem shoe) {

        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra("shoeItem", shoe);
        startActivity(intent);
    }

}


