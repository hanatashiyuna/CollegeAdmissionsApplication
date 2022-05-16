package com.example.collegeadmissionsapplication.UI.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.collegeadmissionsapplication.R;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CheckOTPActivity extends AppCompatActivity {

    private int random;
    private String replaceEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_otpactivity);

        random = ThreadLocalRandom.current().nextInt(1000,9999);

        TextView email = findViewById(R.id.get_email);
        ImageView back = findViewById(R.id.back);
        PinView otp = findViewById(R.id.otp);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(CheckOTPActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        Bundle bundle = getIntent().getExtras();
        String getEmail = (String) bundle.get("email");
        String[] separated = getEmail.split("@",2);
        String[] separated2 = separated[0].split("",4);
        replaceEmail = getEmail.replaceAll(separated2[3], "********");
        email.setText(replaceEmail);

        otp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 4){
                    Toast.makeText(CheckOTPActivity.this, "done", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}