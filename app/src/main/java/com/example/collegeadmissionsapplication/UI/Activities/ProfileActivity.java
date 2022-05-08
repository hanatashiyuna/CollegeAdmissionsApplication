package com.example.collegeadmissionsapplication.UI.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.collegeadmissionsapplication.Adapters.MajorsAdapter;
import com.example.collegeadmissionsapplication.Models.Majors;
import com.example.collegeadmissionsapplication.Models.University;
import com.example.collegeadmissionsapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    List<Majors> majorsList;
    String[] profile;
    University university;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            profile = (String[]) bundle.get("profile");
            university = (University) bundle.get("university");
        }

        RecyclerView majorsRec = findViewById(R.id.rec_majors);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getApplication(), DividerItemDecoration.VERTICAL);
        majorsRec.setLayoutManager(new LinearLayoutManager(getApplication()));
        majorsRec.addItemDecoration(decoration);

        getMajorsList();

        MajorsAdapter majorsAdapter = new MajorsAdapter(ProfileActivity.this, majorsList, this::onClickToNext);
        majorsRec.setAdapter(majorsAdapter);
    }

    public void getMajorsList(){
        majorsList = new ArrayList<>();
        majorsList.add(new Majors("Information Technology"));
        majorsList.add(new Majors("Graphics"));
        majorsList.add(new Majors("Network"));
        majorsList.add(new Majors("Nursing"));
    }

    private void onClickToNext(Majors majors) {
        Intent intent = new Intent(ProfileActivity.this, AdmissionMethodActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("major_admission", majors);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void switchActivity(){
        Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}