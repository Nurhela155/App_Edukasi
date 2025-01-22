package com.tugasbp.appedukasi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // Tombol Setting
        ImageButton btnSetting = findViewById(R.id.setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman setting
                Intent intent = new Intent(DashboardActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        // Tombol Profile
        ImageButton btnProfile = findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman profile
                Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Tombol Ready
        Button btnReady = findViewById(R.id.btn_ready);
        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman Pilihan
                Intent intent = new Intent(DashboardActivity.this, PilihanActivity.class);
                startActivity(intent);
            }
        });

        // Tombol About
        Button btnAbout = findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman About
                Intent intent = new Intent(DashboardActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        // Tombol Levels
        Button btnLevels = findViewById(R.id.btn_levels);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman Levels
                Intent intent = new Intent(DashboardActivity.this, LevelsActivity.class);
                startActivity(intent);
            }
        });

        // Tombol Quit
        Button btnQuit = findViewById(R.id.btn_quit);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dialog konfirmasi keluar
                new AlertDialog.Builder(DashboardActivity.this)
                        .setTitle("EXIT ")
                        .setMessage("Are you sure you want to exit the application?")
                        .setPositiveButton("YES", (dialog, which) -> {
                            finishAffinity(); // Menutup semua aktivitas
                            System.exit(0);   // Menghentikan proses aplikasi
                        })
                        .setNegativeButton("NO", null)
                        .show();
            }
        });
    }
}
