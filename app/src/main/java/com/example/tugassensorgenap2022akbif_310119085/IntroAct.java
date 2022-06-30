package com.example.tugassensorgenap2022akbif_310119085;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
//10119085,Arif Abdan Syakur,IF-3
public class IntroAct extends AppCompatActivity {

    private ViewPager screenPager;
    IntroAdapter introAdapter;
    Button selanjutnya;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();

        tabLayout = findViewById(R.id.tablayout);


        List<ScreenItem> list = new ArrayList<>();
        list.add(new ScreenItem("Selamat Datang!", "Selamat datang di aplikasi FavRest","Swipe Untuk Selanjutnya ===>"));
        list.add(new ScreenItem("Apa Itu FavRest?", "FavRest adalah aplikasi yang dibuat untuk menunjukkan tempat makan favorit.","Swipe Untuk Selanjutnya ===>"));
        list.add(new ScreenItem("Mudah untuk Dipakai!", "Sangat mudah dipakai oleh user", "Silahkan Tekan Tombol Dibawah"));

        screenPager = findViewById(R.id.viewpager);
        introAdapter = new IntroAdapter(this, list);
        screenPager.setAdapter(introAdapter);

        tabLayout.setupWithViewPager(screenPager);

        selanjutnya = findViewById(R.id.selanjutnya);
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroAct.this, home.class);
                startActivity(intent);
            }
        });

    }

}