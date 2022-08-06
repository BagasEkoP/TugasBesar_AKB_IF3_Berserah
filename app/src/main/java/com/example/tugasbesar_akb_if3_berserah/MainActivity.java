package com.example.tugasbesar_akb_if3_berserah;

//Tanggal Pengerjaan    : 5 Agustus 2022
//NIM   : 10119107
//Nama  : Bagas Eko Pambudi
//NIM   : 10119093
//Nama  : Rafli Solihudin
//NIM   : 10119095
//Nama  : Ariq Alhafizh
//NIM   : 10119086
//Nama  : Seldi Syahrizal
//Kelas : IF-3

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfilFragment()).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_profil:
                        selectedFragment = new ProfilFragment();
                        break;
                    case R.id.nav_wisata:
                        selectedFragment = new WisataFragment();
                        break;
                    case R.id.nav_tempatmaps:
                        selectedFragment = new MapsFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;

            }
        });
    }
}