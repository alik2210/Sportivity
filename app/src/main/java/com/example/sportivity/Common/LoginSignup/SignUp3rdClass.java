package com.example.sportivity.Common.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportivity.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class SignUp3rdClass extends AppCompatActivity {
    ScrollView scrollView;
    TextInputLayout phoneNumber;
    Button regBut;
    CountryCodePicker countryCodePicker;
    //Get complete phone number
FirebaseDatabase rootNode;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up3rd_class);

        //Hooks
        phoneNumber = findViewById(R.id.signup_phone_number);
        regBut = findViewById(R.id.signup_next_button);
        countryCodePicker = findViewById(R.id.country_code_picker);
        scrollView = findViewById(R.id.scrolllview_Otp);




//        regBut.setOnClickListener(view -> {
//            rootNode = FirebaseDatabase.getInstance();
//            reference = rootNode.getReference("users");
//            reference.setValue("first data");
//
//        });




    }



    public void callVerifyOTPScreen1(View view) {
//        startActivity(intent);
//        if (!validatePhoneNumber()) {
//            return;
//        }
//
//        String _fullName = getIntent().getStringExtra("fullName");
//        String _email = getIntent().getStringExtra("email");
//        String _username = getIntent().getStringExtra("username");
//        String _password = getIntent().getStringExtra("password");
//        String _date = getIntent().getStringExtra("date");
//        String _gender = getIntent().getStringExtra("gender");
//
//        String _getUserEnteredPhoneNumber = Objects.requireNonNull(phoneNumber.getEditText()).getText().toString().trim();
//        String _phoneNo = "+"+countryCodePicker.getFullNumber()+_getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), VerifyOTP1.class);
        startActivity(intent);
//        intent.putExtra("fullName", _fullName);
//        intent.putExtra("email", _email);
//        intent.putExtra("username", _username);
//        intent.putExtra("password", _password);
//        intent.putExtra("date", _date);
//        intent.putExtra("gender", _gender);
//        intent.putExtra("phoneNo", _phoneNo);
//
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollView, "transition_OTP_screen");


    }


//    private boolean validatePhoneNumber() {
//
//        return true;
//
//    }


}
