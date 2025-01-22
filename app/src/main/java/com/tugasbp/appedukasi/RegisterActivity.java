package com.tugasbp.appedukasi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editEmail;
    private EditText editPassword;
    private Button buttonRegister;
    private ImageButton imageButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        // Inisialisasi elemen UI
        editUsername = findViewById(R.id.editUsername);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonRegister = findViewById(R.id.Button_register);
        imageButtonLogin = findViewById(R.id.imageButtonLogin);

        // Tombol Register
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(RegisterActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("Nurhela") && email.equals("nur@gmail.com") && password.equals("nuy123")) {
                        Toast.makeText(RegisterActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();

                        // Pindah ke LoginActivity
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish(); // Menutup RegisterActivity
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register failed! Check your details", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /// Listener untuk ImageButton Login
        imageButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Jika ingin kembali ke LoginActivity dari halaman lain
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
