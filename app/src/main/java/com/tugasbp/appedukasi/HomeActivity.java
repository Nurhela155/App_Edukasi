package com.tugasbp.appedukasi;

import android.content.Intent; // Tambahkan import Intent
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // Pastikan file XML adalah 'home.xml'

        // Temukan ImageView dan tambahkan OnClickListener
        ImageView imageViewButton = findViewById(R.id.image_button_2);
        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan Toast
                Toast.makeText(HomeActivity.this, "Play Button Clicked!", Toast.LENGTH_SHORT).show();

                // Intent untuk berpindah ke RegisterActivity
                Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register);
            }
        });
    }
}
