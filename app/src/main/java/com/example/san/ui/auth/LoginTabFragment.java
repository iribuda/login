package com.example.san.ui.auth;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.san.MainActivity;
import com.example.san.databinding.LoginTabFragmentBinding;
import com.example.san.utils.BaseFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTabFragment extends BaseFragment<LoginTabFragmentBinding> {

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
                        Toast.makeText(requireActivity(), "Вы успешно вошли", Toast.LENGTH_SHORT).show();
                        onClickStart();
                    }
                    else{
                        Toast.makeText(requireActivity(), "Аутентификация не удалась", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener( e->
                    Log.w(TAG, e.getMessage())

            );
        } else {
            Toast.makeText(requireActivity(), "Ошибка", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickStart(){
        Intent i = new Intent(requireActivity(), MainActivity.class);
        startActivity(i);
    }
}
