package com.example.collegeadmissionsapplication.UI.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegeadmissionsapplication.Adapters.NCAdapter;
import com.example.collegeadmissionsapplication.Models.NameCard;
import com.example.collegeadmissionsapplication.R;
import com.example.collegeadmissionsapplication.UI.Fragment.HomeFragment;
import com.example.collegeadmissionsapplication.UI.Fragment.InforFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class HomeActivity extends AppCompatActivity {

    public String getValueUser = "";
    String[] identityCard;
    String qrcode;
    TextView nameIdentity, nameUser;
    private ViewPager2 mViewPager2;
    CircleIndicator3 mCircleIndicator3;
    List<NameCard> mListNameCard = new ArrayList<>();
    NCAdapter ncAdapter;
    LinearLayout nameCardDemo;
    FrameLayout contentPanel;
    boolean isNewUser = true;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nameUser = findViewById(R.id.name_user);
        nameCardDemo = findViewById(R.id.nameCardDemo);
        nameIdentity = findViewById(R.id.nameIC);
        contentPanel = findViewById(R.id.contentPanel);
        mViewPager2 = findViewById(R.id.view_pager2);
        mCircleIndicator3 = findViewById(R.id.circle_indicator);

        FloatingActionButton fab = findViewById(R.id.fab);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setBackground(null);

        fab.setOnClickListener(view ->
                getSupportFragmentManager().beginTransaction().replace(R.id.contentPanel, new HomeFragment()).commit()
        );

        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentPanel, new HomeFragment()).commit();
                    break;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentPanel, new InforFragment()).commit();
                    break;
                default:
                    break;
            }
            return true;
        });

        mListNameCard.add(new NameCard("", "", "", "", "", "", ""));
        ncAdapter = new NCAdapter(HomeActivity.this, mListNameCard);
        mViewPager2.setAdapter(ncAdapter);
        mCircleIndicator3.setViewPager(mViewPager2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(intentResult.getContents() != null){
            for(int i = 0; i <= mListNameCard.size(); i++){
                NameCard nameCard = mListNameCard.get(i);
                if(nameCard.getItem1().equals("")){
                    mListNameCard.remove(i);
                }
            }
            getValueUser = intentResult.getContents();
            qrcode = getValueUser.replace("|", "_");
            identityCard = qrcode.split("_");
            if(!getValueUser.equals("") && identityCard.length == 7){
                //set title cho name card
                if(isNewUser){
                    nameUser.setText(identityCard[2]);
                    isNewUser = false;
                }
                //set du lieu cho name card
                mListNameCard.add(new NameCard("CCCD: " + identityCard[0], "Ng??y Sinh: " + identityCard[3], "Gi???i T??nh: " + identityCard[4], "?????a Ch???: " + identityCard[5], "", "", "T??n: " + identityCard[2]));
                mListNameCard.add(new NameCard("", "", "", "", "", "", ""));
                ncAdapter = new NCAdapter(HomeActivity.this, mListNameCard);
                mViewPager2.setAdapter(ncAdapter);
                mCircleIndicator3.setViewPager(mViewPager2);
            }else{
                Toast.makeText(HomeActivity.this, "C?? g?? ???? nh???m l???n ch??ng?", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(HomeActivity.this, "B???n v???n ch??a scan th??? g??...", Toast.LENGTH_SHORT).show();
        }
    }
}