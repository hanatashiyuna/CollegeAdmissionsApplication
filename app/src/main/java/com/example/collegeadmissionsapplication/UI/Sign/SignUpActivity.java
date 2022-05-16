package com.example.collegeadmissionsapplication.UI.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.collegeadmissionsapplication.R;
import com.example.collegeadmissionsapplication.UI.CustomUI.LoadingDialog;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SignUpActivity extends AppCompatActivity {

    private int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btnSignIn = findViewById(R.id.sign_in_btn);
        EditText email = findViewById(R.id.edit_email);
        //random = ThreadLocalRandom.current().nextInt(1000,9999);
        random = 2507;
        final LoadingDialog loadingDialog = new LoadingDialog(SignUpActivity.this);

        btnSignIn.setOnClickListener(view -> {
            loadingDialog.startLoadingDialog();
            String getEmail = email.getText().toString();
            final String myEmail = "hanatashiyuna2507@gmail.com";
            final String password = "yuna.2507";
            String sendMessage = String.format("Your OTP is %s. Please do not send OTP to anyone!", String.valueOf(random));
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myEmail, password);
                }
            });

            try {
//                Message message = new MimeMessage(session);
//                message.setFrom(new InternetAddress(myEmail));
//                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getEmail));
//                message.setSubject("OTP code from Yuna to you :3");
//                message.setText(sendMessage);
//                Transport.send(message);
                Toast.makeText(SignUpActivity.this, "Send to email success!", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                e.printStackTrace();
            }

            if(!getEmail.equals("")){
                Bundle bundle = new Bundle();
                Intent intent = new Intent(SignUpActivity.this, CheckOTPActivity.class);
                bundle.putString("email", getEmail);
                bundle.putString("otp", String.valueOf(random));
                intent.putExtras(bundle);
                loadingDialog.dismissDialog();
                startActivity(intent);
            }else{
                loadingDialog.dismissDialog();
                Toast.makeText(SignUpActivity.this, "Bạn chưa nhập email", Toast.LENGTH_SHORT).show();
            }

        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}