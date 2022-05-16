package com.example.collegeadmissionsapplication.UI.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.collegeadmissionsapplication.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btnSignIn = findViewById(R.id.sign_in_btn);
        EditText email = findViewById(R.id.edit_email);

        btnSignIn.setOnClickListener(view -> {
            String getEmail = email.getText().toString().trim();
            if(!getEmail.equals("")){
                Bundle bundle = new Bundle();
                Intent intent = new Intent(SignUpActivity.this, CheckOTPActivity.class);
                bundle.putString("email", getEmail);
                intent.putExtras(bundle);
                startActivity(intent);
            }else{
                Toast.makeText(SignUpActivity.this, "Bạn chưa nhập email", Toast.LENGTH_SHORT).show();
            }
        });
    }
}