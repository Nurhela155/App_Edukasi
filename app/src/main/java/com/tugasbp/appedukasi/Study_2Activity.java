package com.tugasbp.appedukasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Study_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_2);

        // Tombol kembali
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Study_2Activity.this, Study_1Activity.class);
            startActivity(intent);
            finish();
        });

        // Mengatur teks dengan format tebal untuk deskripsi
        TextView textView2 = findViewById(R.id.textView2);

        String description = "Description\n";
        String boldText = "The mouse deer is a small, agile animal with brown fur and white spots." +
                "It lives in the forest, moves quickly, and is famous for its intelligence." +
                "Famous in folklore for his wit and cunning.'";

        SpannableStringBuilder spannable = new SpannableStringBuilder(description + boldText);

        // Menerapkan gaya tebal pada teks "Description"
        spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, description.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Mengatur teks yang diformat ke TextView
        textView2.setText(spannable);
    }
}
