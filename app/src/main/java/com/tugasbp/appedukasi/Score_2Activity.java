package com.tugasbp.appedukasi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Score_2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_2 );

        // Tombol kembali ke dashboard
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            // Intent untuk kembali ke Dashboard
            Intent intent = new Intent(Score_2Activity.this, DashboardActivity.class);
            startActivity(intent);
            finish(); // Menutup activity saat ini
        });

        // Tombol "Try Again"
        Button btnTryAgain = findViewById(R.id.btn_tryagain);
        btnTryAgain.setOnClickListener(v -> {
            // Restart activity ini
            Intent intent = new Intent(Score_2Activity.this, BermainActivity.class);
            startActivity(intent);
            finish();
        });

        // Tombol "Next"
        Button btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> {
            // Intent untuk ke halaman berikutnya (Level selanjutnya)
            Intent intent = new Intent(Score_2Activity.this, LevelsActivity.class);
            startActivity(intent);
        });
    }
}

