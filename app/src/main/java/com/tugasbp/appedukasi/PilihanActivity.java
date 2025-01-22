package com.tugasbp.appedukasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PilihanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilihan);

        // Tombol keluar
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke dashboard
                Intent intent = new Intent(PilihanActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish(); // Menutup activity saat ini
            }
        });

        // Tombol Play
        Button btnPlay = findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman Play
                Intent intent = new Intent(PilihanActivity.this, BermainActivity.class);
                startActivity(intent);
            }
        });

        // Tombol Study
        Button btnStudy = findViewById(R.id.btn_study);
        btnStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman Study
                Intent intent = new Intent(PilihanActivity.this, Study_1Activity.class);
                startActivity(intent);
            }
        });
    }
}


