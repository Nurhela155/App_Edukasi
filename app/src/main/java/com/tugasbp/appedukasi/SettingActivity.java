package com.tugasbp.appedukasi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    private static final String TAG = "SettingActivity";

    private ImageButton btnBack;
    private Button btnAudioOn, btnAudioOff, btnMusicOn, btnMusicOff;
    private boolean isAudioOn = true;
    private boolean isMusicOn = true;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting); // Pastikan nama file layout benar
        Log.d(TAG, "Layout setting.xml berhasil di-load.");

        // Inisialisasi tombol berdasarkan ID dari XML
        btnBack = findViewById(R.id.btn_back);
        btnAudioOff = findViewById(R.id.audio_off);
        btnAudioOn = findViewById(R.id.audio_on);
        btnMusicOn = findViewById(R.id.music_on);
        btnMusicOff = findViewById(R.id.music_off);

        // Debug untuk memastikan tombol tidak null
        Log.d(TAG, "btnBack: " + (btnBack != null));
        Log.d(TAG, "btnAudioOff: " + (btnAudioOff != null));
        Log.d(TAG, "btnAudioOn: " + (btnAudioOn != null));
        Log.d(TAG, "btnMusicOn: " + (btnMusicOn != null));
        Log.d(TAG, "btnMusicOff: " + (btnMusicOff != null));

        // Inisialisasi MediaPlayer untuk musik latar
        mediaPlayer = MediaPlayer.create(this, R.raw.backround_music);
        if (mediaPlayer == null) {
            Log.e(TAG, "MediaPlayer gagal diinisialisasi. Pastikan file musik ada di res/raw.");
        } else {
            mediaPlayer.setLooping(true);
            Log.d(TAG, "MediaPlayer berhasil diinisialisasi.");
            if (isMusicOn) {
                mediaPlayer.start();
                Log.d(TAG, "Musik mulai diputar.");
            }
        }

        // Tombol Kembali: Menuju Dashboard
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Tombol Kembali diklik. Menuju DashboardActivity.");
                Intent intent = new Intent(SettingActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Tombol Audio ON
        btnAudioOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAudioOn = true;
                updateButtonVisibility(btnAudioOn, btnAudioOff);
                Log.d(TAG, "Audio dihidupkan.");
            }
        });

        // Tombol Audio OFF
        btnAudioOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAudioOn = false;
                updateButtonVisibility(btnAudioOff, btnAudioOn);
                Log.d(TAG, "Audio dimatikan.");
            }
        });

        // Tombol Musik ON
        btnMusicOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMusicOn = true;
                updateButtonVisibility(btnMusicOn, btnMusicOff);
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    Log.d(TAG, "Musik mulai diputar.");
                }
            }
        });

        // Tombol Musik OFF
        btnMusicOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMusicOn = false;
                updateButtonVisibility(btnMusicOff, btnMusicOn);
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    Log.d(TAG, "Musik dihentikan.");
                }
            }
        });

        // Perbarui visibilitas awal tombol
        updateButtonVisibility(isAudioOn ? btnAudioOn : btnAudioOff, isAudioOn ? btnAudioOff : btnAudioOn);
        updateButtonVisibility(isMusicOn ? btnMusicOn : btnMusicOff, isMusicOn ? btnMusicOff : btnMusicOn);
    }

    private void updateButtonVisibility(Button buttonToShow, Button buttonToHide) {
        if (buttonToShow != null && buttonToHide != null) {
            buttonToShow.setVisibility(View.VISIBLE);
            buttonToHide.setVisibility(View.GONE);
            Log.d(TAG, "Visibilitas tombol diubah: " + buttonToShow.getId() + " (VISIBLE), " + buttonToHide.getId() + " (GONE)");
        } else {
            Log.e(TAG, "updateButtonVisibility: Salah satu tombol null.");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            Log.d(TAG, "MediaPlayer dijeda di onPause.");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                Log.d(TAG, "MediaPlayer dihentikan di onDestroy.");
            }
            mediaPlayer.release();
            mediaPlayer = null;
            Log.d(TAG, "MediaPlayer dirilis di onDestroy.");
        }
    }
}
