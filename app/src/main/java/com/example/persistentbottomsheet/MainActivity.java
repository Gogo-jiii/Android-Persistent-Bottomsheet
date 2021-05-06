package com.example.persistentbottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    private Button buttonShowBottomSheet;
    private BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior;
    private ConstraintLayout bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShowBottomSheet = findViewById(R.id.buttonShowBottomSheet);
        bottomSheet = findViewById(R.id.bottomsheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        buttonShowBottomSheet.setText("Close");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        buttonShowBottomSheet.setText("Open");
                        break;
                }
            }

            @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        buttonShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(bottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    bottomSheetBehavior.setState(bottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });
    }
}