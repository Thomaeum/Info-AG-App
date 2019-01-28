package net.InformatikAG.info_agapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivityCoordinator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_coordinator);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProjectsFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.navigation_kalender:
                            selectedFragment = new CalenderFragment();
                            break;
                        case R.id.navigation_projekts:
                            selectedFragment = new ProjectsFragment();
                            break;
                        case R.id.navigation_coordinators:
                            selectedFragment = new CoordinatorsFragment();
                            break;
                        case R.id.navigation_cloud:
                            selectedFragment = new CloudFragment();
                            break;
                        case R.id.navigation_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}
