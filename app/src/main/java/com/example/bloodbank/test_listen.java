package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class test_listen extends AppCompatActivity {
     TextView title , desc;
     ImageView imageView ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        title = findViewById(R.id.videoTitle);
        desc = findViewById(R.id.detailDesc);
        imageView = findViewById(R.id.detailImage);


        title.setText(getIntent().getExtras().getString("title"));
        desc.setText(getIntent().getExtras().getString("desc"));
        int i = getIntent().getIntExtra("image" , 0);
        imageView.setImageResource(i);
    }
}