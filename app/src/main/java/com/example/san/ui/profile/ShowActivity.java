//package com.example.san.ui.profile;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.san.R;
//
//public class ShowActivity extends AppCompatActivity {
//
//    private TextView txt_name, txt_email, date_value, mobile_value, txt_address;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_profile);
//
//        init();
//        getIntentMain();
//
//    }
//
//    private void init(){
//        txt_name = findViewById(R.id.txt_name);
//        txt_email = findViewById(R.id.txt_email);
//        date_value = findViewById(R.id.txt_date);
//        mobile_value = findViewById(R.id.txt_mobile);
//        txt_address = findViewById(R.id.txt_address);
//    }
//
//    private void getIntentMain(){
//        Intent i = getIntent();
//        if (i != null){
//            txt_name.setText(i.getStringExtra(Constant.USER_NAME));
//            txt_email.setText(i.getStringExtra(Constant.USER_EMAIL));
//            date_value.setText(i.getStringExtra(Constant.USER_DATE));
//            mobile_value.setText(i.getStringExtra(Constant.USER_MOBILE));
//            txt_address.setText(i.getStringExtra(Constant.USER_ADDRESS));
//        }
//    }
//}