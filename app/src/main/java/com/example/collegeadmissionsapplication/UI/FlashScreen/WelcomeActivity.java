package com.example.collegeadmissionsapplication.UI.FlashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.collegeadmissionsapplication.Adapters.AnimFragmentAdapter;
import com.example.collegeadmissionsapplication.R;
import com.example.collegeadmissionsapplication.UI.Sign.SignInActivity;
import com.example.collegeadmissionsapplication.UI.Sign.SignUpActivity;

import me.relex.circleindicator.CircleIndicator3;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager2);
        TextView signIn = findViewById(R.id.sign_in_text);
        Button signUp = findViewById(R.id.sign_now_btn);
        CircleIndicator3 indicator3 = findViewById(R.id.circleIndicator3);

        AnimFragmentAdapter animFragmentAdapter = new AnimFragmentAdapter(this);
        viewPager2.setAdapter(animFragmentAdapter);
        indicator3.setViewPager(viewPager2);

        signUp.setOnClickListener(view -> goSignNow());

        signIn.setOnClickListener(view -> goSignIn());
    }

    private void goSignIn() {
        Intent intent = new Intent(WelcomeActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    public void goSignNow(){
        Intent intent = new Intent(WelcomeActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}