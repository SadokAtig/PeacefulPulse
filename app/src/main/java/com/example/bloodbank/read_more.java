package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class read_more extends AppCompatActivity {
    TextView web ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);

    web = findViewById(R.id.weblink);
    web.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gotourl("https://www.lemonde.fr/sante-mentale/");
        }
    });



    }

    void gotourl(String s){
        try {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"no web site",Toast.LENGTH_SHORT).show();
        }

    }
}