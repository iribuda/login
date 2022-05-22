package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.login.databinding.LoginTabFragmentBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTabFragment extends BaseFragment<LoginTabFragmentBinding>{

    private FirebaseAuth mAuth;

    @Override
    public LoginTabFragmentBinding bind() {
        return LoginTabFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSignIn();
            }
        });
    }

    public void onClickSignIn(){
        if (!TextUtils.isEmpty(binding.email.getText().toString()) && !TextUtils.isEmpty(binding.password.getText().toString())){
            mAuth.signInWithEmailAndPassword(binding.email.getText().toString(), binding.password.getText().toString()).addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(requireActivity(), "User SignIn Successfull", Toast.LENGTH_SHORT).show();
                        onClickStart();
                    }
                    else{
                        Toast.makeText(requireActivity(), "User SignIn Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void onClickStart(){
        Intent i = new Intent(requireActivity(), MainActivity.class);
        startActivity(i);
    }
}
