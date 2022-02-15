package com.example.viewbindingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.viewbindingtest.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Integer pos = intent.getIntExtra("position",0);
        binding.tvMain.setText(pos.toString());
    }
}