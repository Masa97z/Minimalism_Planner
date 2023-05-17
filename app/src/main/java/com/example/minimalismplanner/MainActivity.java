package com.example.minimalismplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemSelectedListener);

        // Set the initial fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                new home()).commit();
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button click event
        onBackPressed();
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener =
            view -> {
                Fragment selectedFragment = null;

                // Determine which fragment to show based on the selected menu item
                if (view.getItemId() == R.id.homebtn) {
                    selectedFragment = new home();

                }
                else if(view.getItemId() ==R.id.listbtn) {
                    selectedFragment = new List();
                }
                else if(view.getItemId() == R.id.add) {
                    selectedFragment = new List();
                }
                else {
                        selectedFragment = new List();

                }

                // Replace the current fragment with the selected fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        selectedFragment).commit();

                return true;
            };
}