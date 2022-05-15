package com.example.collegeadmissionsapplication.UI.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.collegeadmissionsapplication.R;
import com.example.collegeadmissionsapplication.UI.Activities.HomeActivity;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button btnLogIn = findViewById(R.id.log_in_btn);
        TextView signUp = findViewById(R.id.sign_up_text);

        btnLogIn.setOnClickListener(view -> letLogIn());

        signUp.setOnClickListener(view -> letSignUp());
    }

    private void letLogIn() {
        Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private void letSignUp() {
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}