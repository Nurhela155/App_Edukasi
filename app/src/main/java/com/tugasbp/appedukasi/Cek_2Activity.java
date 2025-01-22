package com.tugasbp.appedukasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class Cek_2Activity extends AppCompatActivity {

    private ImageButton btnBack;
    private TextView btnAnt, textViewElephant, textViewLion;
    private ImageView imgLion, imgElephant;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cek_2);

        // Initialize components
        btnBack = findViewById(R.id.btn_back);
        btnAnt = findViewById(R.id.textView_ant);
        textViewElephant = findViewById(R.id.textView_elephant);
        textViewLion = findViewById(R.id.btn_lion);
        imgLion = findViewById(R.id.imageView7);
        imgElephant = findViewById(R.id.imageView5);
        btnCheck = findViewById(R.id.btn_chek);

        // Back button listener
        btnBack.setOnClickListener(v -> {
            // Navigate back to the dashboard or previous screen
            finish();
        });

        // TextView button listeners
        btnAnt.setOnClickListener(v ->
                Toast.makeText(Cek_2Activity.this, "Ant button clicked", Toast.LENGTH_SHORT).show()
        );

        textViewElephant.setOnClickListener(v ->
                Toast.makeText(Cek_2Activity.this, "Elephant selected", Toast.LENGTH_SHORT).show()
        );

        textViewLion.setOnClickListener(v ->
                Toast.makeText(Cek_2Activity.this, "Lion selected", Toast.LENGTH_SHORT).show()
        );

        // Check button listener
        btnCheck.setOnClickListener(v -> {
            // Navigasi ke halaman Score_1
            Intent intent = new Intent(Cek_2Activity.this, Score_2Activity.class);
            startActivity(intent);
        });
    }
}

