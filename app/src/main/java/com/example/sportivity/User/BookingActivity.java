package com.example.sportivity.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportivity.R;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
    }

    public void SelectTime(View view) {
        Intent intent=new Intent(getApplicationContext(), TimeActivity.class);
        startActivity(intent);

    }
}