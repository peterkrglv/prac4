package com.example.prac4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.prac4.databinding.ActivityMain3Binding;
import com.example.prac4.databinding.ActivityMainBinding;

public class MainActivity3 extends AppCompatActivity {
    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("day", binding.editText1.getText().toString());
            intent.putExtra("time", binding.editText2.getText().toString());
            intent.putExtra("comment", binding.editText3.getText().toString());
            setResult(RESULT_OK, intent);
            finish();

        });

        setContentView(binding.getRoot());
    }
}