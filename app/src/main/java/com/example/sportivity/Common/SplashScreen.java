package com.example.sportivity.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportivity.R;
import com.example.sportivity.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    ImageView backgroundImage;
    TextView poweredByLine;
    Animation sideAnim, bottomAnim;
    SharedPreferences onBoardingScreen;
    private static final int SPLASH_TIMER=4000;//duration of animation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.aplash_screen);
        //Hooks
        backgroundImage=findViewById(R.id.background_image);
        poweredByLine=findViewById(R.id.powered_by_line);
        //Animations
        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
//set animations on elements
        backgroundImage.setAnimation(sideAnim);
        backgroundImage.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime=onBoardingScreen.getBoolean("isFirstTime",true);

                if(isFirstTime){
                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("isFirstTime",false);
                    editor.apply();
                    Intent intent=new Intent(SplashScreen.this, OnBoarding.class);
//                    Intent intent2=new Intent(SplashScreen.this, PermissionActivity.class);

                    //We can also use getApplication as context of present activity
                    startActivity(intent);
//                    startActivity(intent2);// finish() will destroyed this activity
                    //call the next activity
                    finish();
                }
                else{
                    Intent intent=new Intent(getApplicationContext(), UserDashboard.class);//We can also use getApplication as context of present activity
                    startActivity(intent);
//                    call the next activity
                    finish();
                }
            }
        },SPLASH_TIMER);
    }
}