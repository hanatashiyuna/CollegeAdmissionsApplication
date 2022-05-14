package com.example.collegeadmissionsapplication.UI.FlashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.collegeadmissionsapplication.R;
import com.example.collegeadmissionsapplication.UI.Activities.HomeActivity;


public class FlashScreenActivity extends AppCompatActivity {

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        timer = new CountDownTimer(3500, 3500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                switchActivity();
            }
        }.start();
    }
    private void switchActivity() {
        Intent intent = new Intent(FlashScreenActivity.this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

    /*private void startCircularImage() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mCircleImageView.animate().rotationBy(360).withEndAction(this).setDuration(10000).setInterpolator(new LinearInterpolator()).start();
            }
        };

        mCircleImageView.animate().rotationBy(360).withEndAction(runnable).setDuration(10000).setInterpolator(new LinearInterpolator()).start();
    }

    private void countDownTimerLeft(int time){
        timer = new CountDownTimer(time, time) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                animLeftToRight();
            }
        }.start();
    }

    private void countDownTimerRight(int time){
        timer = new CountDownTimer(time, time) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                animRightToLeft();
            }
        }.start();
    }

    private void countDownTimerTop(int time){
        timer = new CountDownTimer(time, time) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                animTopToBottom();
            }
        }.start();
    }

    private void countDownTimerBottom(int time){
        timer = new CountDownTimer(time, time) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                animBottomToTop();
            }
        }.start();
    }

    private void animLeftToRight(){
        *//*getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slanted_up_left, R.anim.exit_slanted_up_left)
                .replace(R.id.anim_bottom_left, new WelcomeAnimFragment1())
                .commit();*//*
    }

    private void animRightToLeft(){
        *//*getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slanted_up_right, R.anim.exit_slanted_up_right)
                .replace(R.id, new WelcomeAnimFragment2())
                .commit();*//*
    }

    private void animTopToBottom(){
        *//*getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slanted_down_left, R.anim.exit_slanted_down_left)
                .replace(R.id.anim_bottom_left, new WelcomeAnimFragment1())
                .commit();*//*
    }

    private void animBottomToTop(){
        *//*getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slanted_down_right, R.anim.exit_slanted_down_right)
                .replace(R.id.anim_bottom_left, new WelcomeAnimFragment2())
                .commit();*//*
    }*/
}