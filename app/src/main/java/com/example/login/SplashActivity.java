package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.login.databinding.ActivityLoginBinding;
import com.example.login.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.letterS.animate().translationY(-1600).setDuration(1000).setStartDelay(0);
        binding.letterA.animate().translationY(-1600).setDuration(1000).setStartDelay(1000);
        binding.letterN.animate().translationY(-1600).setDuration(1000).setStartDelay(2000);


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