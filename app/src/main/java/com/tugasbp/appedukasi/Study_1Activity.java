package com.tugasbp.appedukasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Study_1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_1);

        // Tombol kembali
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Study_1Activity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        // Tombol next
        ImageButton btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> {
            // Intent untuk berpindah ke aktivitas berikutnya
            Intent intent = new Intent(Study_1Activity.this, Study_2Activity.class); // Ganti dengan activity berikutnya
            startActivity(intent);
            finish(); // Menutup activity saat ini
        });

        // Mengatur teks dengan format tebal untuk deskripsi
        TextView textView2 = findViewById(R.id.textView2);

        String description = "Description\n";
        String boldText = "The tiger is a strong and fast animal with orange fur and black stripes. " +
                "It lives in forests, loves water, and is a great swimmer. " +
                "Known for its strength and bravery, the tiger is called the 'king of the jungle.'";

        SpannableStringBuilder spannable = new SpannableStringBuilder(description + boldText);

        // Menerapkan gaya tebal pada teks "Description"
        spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, description.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Mengatur teks yang diformat ke TextView
        textView2.setText(spannable);
    }
}
