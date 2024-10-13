package com.example.finalproject_test;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalproject_test.screenfragment.ViewPageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainScreen extends AppCompatActivity {

    private ViewPager2 vp;
    private BottomNavigationView bnv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vp=findViewById(R.id.view_page);
        bnv=findViewById(R.id.menu_bar);

        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
               bnv.getMenu().getItem(position).setChecked(true);
            }
        });

        ViewPageAdapter vpa = new ViewPageAdapter(this);
        vp.setAdapter(vpa);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch(position){
                    case 0:
                        bnv.getMenu().findItem(R.id.menu_home).setCheckable(true);
                        break;
                    case 1:
                        bnv.getMenu().findItem(R.id.menu_cup).setCheckable(true);
                        break;
                    case 2:
                        bnv.getMenu().findItem(R.id.menu_bookmark).setCheckable(true);
                        break;
                    case 3:
                        bnv.getMenu().findItem(R.id.menu_user).setCheckable(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_home) {
                    vp.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.menu_cup) {
                    vp.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.menu_bookmark) {
                    vp.setCurrentItem(2);
                    return true;
                }
                else if (item.getItemId() == R.id.menu_user) {
                    vp.setCurrentItem(3);
                    return true;
                }
                return false;
            }
        });




    }
}

