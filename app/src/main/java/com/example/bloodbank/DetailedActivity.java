package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bloodbank.databinding.ActivityDetailedBinding;
public class DetailedActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityDetailedBinding binding;
    private CardView card1 , card2,card3,card4,card5,card6 ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");


        }

        card1 = (CardView) findViewById(R.id.listen);
        card2 = (CardView) findViewById(R.id.more);
        card3 = (CardView) findViewById(R.id.cou);
        card4 = (CardView) findViewById(R.id.connect);
        card5 = (CardView) findViewById(R.id.exercice);
        card6 = (CardView) findViewById(R.id.knowledge);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

        Intent i ;

        int viewId = v.getId();

        if (viewId == R.id.listen) {
             i = new Intent(this, audio.class);
            startActivity(i);
        } else if (viewId == R.id.more) {
             i = new Intent(this, read_more.class);
            startActivity(i);
        } else if (viewId == R.id.cou) {
             i = new Intent(this, courses.class);
            startActivity(i);
        } else if (viewId == R.id.exercice) {
            i = new Intent(this, NavigationActivity.class);
            startActivity(i);
        } else if (viewId == R.id.connect) {
             i = new Intent(this, connect.class);
            startActivity(i);
        } else if (viewId == R.id.knowledge) {
             i = new Intent(this, knowledge.class);
            startActivity(i);
        }


    }
}