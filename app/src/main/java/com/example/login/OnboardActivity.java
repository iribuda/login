package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.login.databinding.ActivityOnboardBinding;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class OnboardActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    ActivityOnboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = OnboardLastFragment.newInstance(getDataForBoarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnboardActivity.this, LoginActivity.class));
            }
        });
    }

    private ArrayList<PaperOnboardingPage> getDataForBoarding() {
        PaperOnboardingPage src1 = new PaperOnboardingPage("Бронируйте", "All hotels and hostels are sorted by hostility ratings",
                Color.parseColor("#ffffff"), R.drawable.refund_bro, R.drawable.logo);
        PaperOnboardingPage src2 = new PaperOnboardingPage("Покупайте", "All hotels and hostels are sorted by hostility ratings",
                Color.parseColor("#ffffff"), R.drawable.successful_purchase_bro, R.drawable.logo);
        PaperOnboardingPage src3 = new PaperOnboardingPage("Отслеживайте", "All hotels and hostels are sorted by hostility ratings",
                Color.parseColor("#ffffff"), R.drawable.confirmed_bro, R.drawable.logo);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(src1);
        elements.add(src2);
        elements.add(src3);
        return elements;
    }


}