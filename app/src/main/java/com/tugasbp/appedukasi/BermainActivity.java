package com.tugasbp.appedukasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BermainActivity extends AppCompatActivity {

    private Button btnLion, btnAnt, btnElephant;
    private ImageView imgLion, imgElephant;
    private boolean isLionMatched = false;
    private boolean isElephantMatched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bermain_1);
// Tombol kembali
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(BermainActivity.this, PilihanActivity.class);
            startActivity(intent);
            finish();
        });

        // Initialize buttons and images
        btnLion = findViewById(R.id.btn_lion);
        btnAnt = findViewById(R.id.btn_ant);
        btnElephant = findViewById(R.id.btn_elephant);
        imgLion = findViewById(R.id.imageView7); // Lion Image
        imgElephant = findViewById(R.id.imageView5); // Elephant Image

        // Set long click listeners for buttons
        btnLion.setOnLongClickListener(new MyLongClickListener());
        btnAnt.setOnLongClickListener(new MyLongClickListener());
        btnElephant.setOnLongClickListener(new MyLongClickListener());

        // Set drag listeners for images
        imgLion.setOnDragListener(new MyDragListener("Lion"));
        imgElephant.setOnDragListener(new MyDragListener("Elephant"));

    }

    /**
     * Custom LongClickListener to handle drag operations.
     */
    private class MyLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            if (v != null) {
                // Create a drag shadow for the view
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);

                // Start the drag process
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    v.startDragAndDrop(null, shadowBuilder, v, 0);
                } else {
                    v.startDrag(null, shadowBuilder, v, 0);
                }
                return true;
            }
            return false;
        }
    }

    /**
     * Custom DragListener to handle drop events.
     */
    private class MyDragListener implements View.OnDragListener {
        private final String expectedTag;

        public MyDragListener(String expectedTag) {
            this.expectedTag = expectedTag;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    return true;

                case DragEvent.ACTION_DROP:
                    // Handle the drop event
                    View draggedView = (View) event.getLocalState();
                    if (draggedView instanceof Button) {
                        String buttonText = ((Button) draggedView).getText().toString();

                        if (buttonText.equals("Ant") && expectedTag.equals("Lion")) {
                            // If Ant is dropped on Lion
                            Toast.makeText(BermainActivity.this,
                                    "Ant matched with Lion. Redirecting to Cek_2.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(BermainActivity.this, Cek_2Activity.class);
                            startActivity(intent);
                            finish(); // Close current activity
                        } else if (buttonText.equals(expectedTag)) {
                            // Correct match for Lion or Elephant
                            Toast.makeText(BermainActivity.this,
                                    "Correct! " + buttonText + " matched.",
                                    Toast.LENGTH_SHORT).show();

                            if (expectedTag.equals("Lion")) {
                                isLionMatched = true;
                            } else if (expectedTag.equals("Elephant")) {
                                isElephantMatched = true;
                            }

                            checkCompletion();
                        } else {
                            Toast.makeText(BermainActivity.this,
                                    "Wrong match! Try again.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    return true;

                default:
                    return false;
            }
        }
    }

    /**
     * Check if all matches are completed before navigating to the next activity.
     */
    private void checkCompletion() {
        if (isLionMatched && isElephantMatched) {
            // All matches completed
            Intent intent = new Intent(BermainActivity.this, Cek_1Activity.class);
            startActivity(intent);
            finish(); // Close current activity
        }
    }
}
