package com.example.collegeadmissionsapplication.UI.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.collegeadmissionsapplication.R;
import com.example.collegeadmissionsapplication.UI.Activities.HomeActivity;
import com.example.collegeadmissionsapplication.UI.CustomUI.LoadingDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CheckOTPActivity extends AppCompatActivity {

    private String replaceEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_otpactivity);

        TextView email = findViewById(R.id.get_email);
        ImageView back = findViewById(R.id.back);
        PinView otp = findViewById(R.id.otp);
        TextView countdownTime = findViewById(R.id.countdown_time);
        TextView text = findViewById(R.id.text2);
        TextView sendAgain = findViewById(R.id.send_again);
        long duration = TimeUnit.MINUTES.toMillis(5);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(CheckOTPActivity.this, SignUpActivity.class);
            startActivity(intent);
        });


        Bundle bundle = getIntent().getExtras();
        final String getEmail = (String) bundle.get("email");
        String getOTP = bundle.getString("otp");
        String[] separated = getEmail.split("@",2);
        String[] separated2 = separated[0].split("",4);

        replaceEmail = getEmail.replaceAll(separated2[3], "******");
        email.setText(replaceEmail);

        otp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 4){
                    if(charSequence.toString().equals(getOTP)){
                        final LoadingDialog loadingDialog = new LoadingDialog(CheckOTPActivity.this);
                        CountDownTimer timer = new CountDownTimer(1500, 3500) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                loadingDialog.startLoadingDialog();
                            }

                            @Override
                            public void onFinish() {
                                loadingDialog.dismissDialog();
                                switchActivity();
                            }
                        };
                        timer.start();
                    }else{
                        Toast.makeText(CheckOTPActivity.this, "OTP incorrect!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                countdownTime.setText(sDuration);
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                text.setText("Không có email?");
                countdownTime.setVisibility(View.INVISIBLE);
                sendAgain.setVisibility(View.VISIBLE);
                sendAgain.setText("Gửi lại OTP");
            }
        }.start();
    }

    private void switchActivity() {
        Intent intent = new Intent(CheckOTPActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}