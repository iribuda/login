package com.example.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ramotion.paperonboarding.PaperOnboardingFragment;

public class OnboardLastFragment extends PaperOnboardingFragment {

    public OnboardLastFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View parentView = super.onCreateView(inflater, container, savedInstanceState);
        Button skipTextview = parentView.findViewById(R.id.continue_btn);
        skipTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireActivity(), LoginActivity.class));
            }
        });
        ((ViewGroup)parentView).addView(skipTextview);
        return parentView;
    }
}