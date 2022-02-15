package com.example.sportivity.Common.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportivity.R;
import com.google.android.material.textfield.TextInputLayout;


public class SignUp1 extends AppCompatActivity {
    TextInputLayout fullName, userName, email, password;
    ImageView backBtn;
    Button next, login;
    TextView titleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up);
        backBtn = findViewById(R.id.Signup_back_button);
        next = findViewById(R.id.Signup_next_button);
        login = findViewById(R.id.Signup_login_button);
        titleText = findViewById(R.id.Signup_title_text);
//Hooks
        fullName = findViewById(R.id.signup_fullname);
        userName = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email2);
        password = findViewById(R.id.signup_password);
    }
    public void callNextSignUp2(View view) {
        if(!validateFullName()| !validateEmail() | !validateUsername()| !validatePassword()){
            return;
        }
        Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);
        //Transition
        //Add Transition and call next activity
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp1.this, pairs);
        startActivity(intent, options.toBundle());//attaching animation with intent
    }
    public void callNextSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);
        startActivity(intent);
    }
    private boolean validateFullName() {
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateUsername() {
        String val = userName.getEditText().getText().toString().trim();
        String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            userName.setError("Field can not be Empty");
            return false;
        } else if (val.length() > 20) {
            userName.setError("Username is too large!");
            return false;
//        } else if (!val.matches(checkspaces)) {
//            userName.setError("No whitespaces are allowed!");
//            return false;
        } else {
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Field can not be Empty");
            return false;
        }  else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (val.isEmpty()) {
            email.setError("Field can not be Empty");
            return false;
//        }  else if (!val.matches(checkPassword)) {
//            password.setError("Password should contain four characters!");
//            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


}
