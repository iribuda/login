package com.example.san.ui.intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import androidx.appcompat.app.AppCompatActivity;

import com.example.san.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        binding.letterS.startAnimation(fadeIn);
        binding.letterA.startAnimation(fadeIn);
        binding.letterN.startAnimation(fadeIn);
        fadeIn.setDuration(1200);
        fadeIn.setFillAfter(true);

        Thread splashScreenStarter = new Thread(){
            @Override
            public void run() {
                try{
                    int delay = 0;
                    while (delay < 2000){
                        sleep(150);
                        delay = delay + 100;
                    }
                    Intent intent = new Intent(SplashActivity.this, OnboardActivity.class);
                    startActivity(intent);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    finish();
                }
            }
        };
        splashScreenStarter.start();
    }
}