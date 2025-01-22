package com.tugasbp.appedukasi;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about); // Pastikan nama file XML adalah activity_about.xml

        // Inisialisasi tombol kembali
        ImageButton btnBack = findViewById(R.id.btn_back);

        // Listener untuk tombol kembali
        btnBack.setOnClickListener(v -> {
            // Kembali ke halaman sebelumnya
            finish(); // Menutup Activity ini dan kembali ke Activity sebelumnya
        });

        // Tambahkan logika lainnya jika diperlukan
    }
}
