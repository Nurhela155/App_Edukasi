package com.tugasbp.appedukasi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);

        // Tombol kembali
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(LevelsActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        // Listener untuk tombol kembali
        btnBack.setOnClickListener(v -> {
            // Navigasi ke halaman sebelumnya
            finish(); // Menutup Activity ini dan kembali ke Activity sebelumnya
        });

        // Tambahkan listener untuk setiap level jika diperlukan
        setupLevelListeners();
    }

    private void setupLevelListeners() {
        // Contoh: Tambahkan logika untuk level 1 jika dibutuhkan
        View level1 = findViewById(R.id.baris_1);
        level1.setOnClickListener(v -> {
            // Navigasi ke halaman level 1
            Intent intent = new Intent(LevelsActivity.this, LevelsActivity.class);
            startActivity(intent);
        });

        // Tambahkan logika navigasi untuk level lainnya jika diperlukan
    }
}