package com.example.prac4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.prac4.databinding.ActivityMain2Binding;
import com.example.prac4.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());


        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        if (name != null) {
            binding.textView1.setText(name);
        }
        if (surname != null) {
            binding.textView2.setText(surname);
        }


        binding.button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            mStartForResult.launch(intent);
        });

        setContentView(binding.getRoot());
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    String day = intent.getStringExtra("day");
                    String time = intent.getStringExtra("time");
                    String comment = intent.getStringExtra("comment");
                    Toast.makeText(MainActivity2.this, "Successfully registered for: " + day + " " + time, Toast.LENGTH_SHORT).show();
                }
            }
    );
}