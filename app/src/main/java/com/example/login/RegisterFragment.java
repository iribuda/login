package com.example.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login.databinding.FragmentRegisterBinding;
//import com.example.test.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
//import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

//public class RegisterFragment extends BaseFragment<FragmentRegisterBinding> {
//
//    private static Prefs prefs;
//    private static PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
//    private static FirebaseAuth mAuth;
//    private static FirebaseUser user;
//    CountryCodePicker ccp;
//
//    @Override
//    public FragmentRegisterBinding bind(){
//        return FragmentRegisterBinding.inflate(getLayoutInflater());
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
//        super.onViewCreated(view, savedInstanceState);
//        init();
//        initListener();
//        createCallback();
//    }
//
//    public void init(){
//        prefs = new Prefs(requireContext());
//        mAuth = FirebaseAuth.getInstance();
//    }
//
//    public void initListener(){
//        binding.login.setOnClickListener(view -> {
//            String countryCodeWithPlus = binding.ccp.getSelectedCountryCodeWithPlus();
//            String phone = binding.number.getText().toString().trim();
//            if (countryCodeWithPlus == null && countryCodeWithPlus.equalsIgnoreCase("")){
//                ccp.setNumberAutoFormattingEnabled(true);
//                if (TextUtils.isEmpty(phone)){
//                    binding.number.setError("Поле пустое");
//                }
//                else{
//                    register(countryCodeWithPlus + phone);
//                    Log.e("TAG", "initListener: " + countryCodeWithPlus + phone);
//                    binding.login.setVisibility(View.GONE);
//                    binding.okay.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//    }
//
//
//    public void createCallback() {
//        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//            @Override
//            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                signInWithPhoneAuthCredential(phoneAuthCredential);
//            }
//
//            @Override
//            public void onVerificationFailed(@NonNull FirebaseException e) {
//                Log.w(TAG, "onVerificationFailed", e);
//                if (e instanceOf FirebaseAuthInvalidCredentialException){
//                    Log.e(TAG, "Invalid request");
//                }
//                else if (e instanceof FirebaseTooManyRequestsException) {
//                    Log.e(TAG, "The SMS quota for the project has been exceeded");
//                }
//            }
//
//            @Override
//            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider
//                    .ForceResendingToken forceResendingToken) {
//                super.onCodeSent(s, forceResendingToken);
//                binding.okay.setOnClickListener(view -> {
//                    initcode(s);
//                });
//            }
//
//            private void initcode(String s) {
//                String code = binding.code.getText().toString().trim();
//                if (TextUtils.isEmpty(code)) {
//                    binding.code.setError("The field is empty");
//                } else {
//                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(s, code);
//                    signInWithPhoneAuthCredential(credential);
//                }
//            }
//        };
//    }
//
//    private void register(String phoneNumber) {
//        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
//                .setPhoneNumber(phoneNumber)
//                .setTimeout(60L, TimeUnit.SECONDS)
//                .setActivity(requireActivity())
//                .setCallbacks(mCallbacks)
//                .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//
//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            Log.d("TAG", "signInWithCredential:success");
//                            user = task.getResult().getUser();
//
//                            prefs.isRegisterPageShow();
//
//                            Log.e("TAG", "onComplete: ");
//                            Navigation.findNavController(requireView().navigate(R.id.onBoardFragment));
//                        }
//                        else{
//                            binding.code.setError("Incorrect code");
//                            Log.w("TAG", "signInWithCredintial:failure", task.getException());
//                            if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
//
//                            }
//                        }
//                    }
//                })
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//}