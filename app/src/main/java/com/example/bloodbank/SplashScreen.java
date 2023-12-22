package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView welcome , titl , selgon ;
    RelativeLayout relativeLayout;
    Animation txtAnimation , LayoutAnimation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        txtAnimation = AnimationUtils.loadAnimation(SplashScreen.this ,R.anim.fall_down);
        LayoutAnimation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bottom_to_top);
        welcome = findViewById(R.id.welcome);
        titl = findViewById(R.id.titl);
        relativeLayout = findViewById(R.id.RelMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(LayoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        welcome.setVisibility(View.VISIBLE);
                        titl.setVisibility(View.VISIBLE);

                        welcome.setAnimation(txtAnimation);
                        titl.setAnimation(txtAnimation);
                    }
                },500);
            }
        },1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        },9500);




    }
}