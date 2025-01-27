package com.dhernandez.nicestart;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.dhernandez.nicestart.ui.main.SectionsPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBn extends AppCompatActivity {


    private SectionsPagerAdapter sectionsPagerAdapter;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bn);

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());



        ViewPager viewpager = findViewById(R.id.viewpager);
        viewpager.setAdapter(sectionsPagerAdapter);

        BottomNavigationView mybottomNavView = findViewById(R.id.bottomNavigationView);
        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.heart){
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                    viewpager.setCurrentItem(0);

                }else if(item.getItemId()==R.id.search){
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                    viewpager.setCurrentItem(1);
                }else if(item.getItemId()==R.id.heart2){
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                    viewpager.setCurrentItem(2);
                }else if(item.getItemId()==R.id.search2){
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                    viewpager.setCurrentItem(3);
                }
                return false;
            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mybottomNavView.getMenu().getItem(0).setChecked(false);
                    mybottomNavView.getMenu().getItem(position).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





    }

}