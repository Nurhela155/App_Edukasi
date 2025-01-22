package com.tugasbp.appedukasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPassword;
    private Button buttonLogin;
    private ImageButton imageButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login); // Pastikan file layout benar

        // Inisialisasi komponen
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.Button_login);
        imageButtonLogin = findViewById(R.id.imageButtonLogin); // Tambahkan ID untuk ImageButton di layout XML Anda

        // Listener untuk Button Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("Nurhela") && password.equals("nuy123")) {
                        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent dashboard = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(dashboard);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login failed! Check carefully your Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Listener untuk ImageButton Login
        imageButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Jika ingin kembali ke LoginActivity dari halaman lain
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
