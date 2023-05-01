package com.example.myquiz3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class finalscore extends AppCompatActivity {
    TextView congo;
    TextView name;
    TextView score;
    Button start, finish;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String Name = getIntent().getStringExtra("Name");
        String finalscore = getIntent().getStringExtra("Score");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalscore);

        congo = findViewById(R.id.cong);
        name = findViewById(R.id.ValueName);
        score = findViewById(R.id.finalscore);
        start = findViewById(R.id.startagain);
        finish = findViewById(R.id.finish);

        congo.setText("Congrats!!");
        name.setText(Name);
        score.setText(finalscore +"/5");

        start.setOnClickListener(v -> {
            finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        finish.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        }

}