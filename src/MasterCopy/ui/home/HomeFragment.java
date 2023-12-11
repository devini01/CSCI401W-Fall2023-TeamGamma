package org.meicode.rafflescreennew.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.meicode.rafflescreennew.R;
import org.meicode.rafflescreennew.databinding.FragmentHomeBinding;
public class HomeFragment extends Fragment { //This class is necessary for the BottomNavView to work (Was a template that was used)

    private FragmentHomeBinding binding;

        //temp code

    private HomeViewModel homeViewModel;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button loginButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //HomeViewModel homeViewModel =
          //      new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Reference views from fragment_home.xml
        editTextEmail = root.findViewById(R.id.email);
        editTextPassword = root.findViewById(R.id.password);
        loginButton = root.findViewById(R.id.loginButton);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
