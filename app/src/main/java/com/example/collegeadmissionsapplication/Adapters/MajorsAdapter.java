package com.example.collegeadmissionsapplication.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeadmissionsapplication.Interface.IClickItem.IClickItemMajor;
import com.example.collegeadmissionsapplication.Models.Majors;
import com.example.collegeadmissionsapplication.R;

import java.util.List;

public class MajorsAdapter extends RecyclerView.Adapter<MajorsAdapter.ViewHolder>{
    Context mContext;
    Activity mActivity;
    FragmentActivity fragmentActivity;
    Fragment mFragment;
    List<Majors> majorsList;
    IClickItemMajor iClickMajor;

    public MajorsAdapter(Activity mActivity, List<Majors> majorsList, IClickItemMajor iClickMajor) {
        this.mActivity = mActivity;
        this.majorsList = majorsList;
        this.iClickMajor = iClickMajor;
    }

    public MajorsAdapter(Context mContext, List<Majors> majorsList, IClickItemMajor iClickMajor) {
        this.mContext = mContext;
        this.majorsList = majorsList;
        this.iClickMajor = iClickMajor;
    }

    public MajorsAdapter(FragmentActivity fragmentActivity, List<Majors> majorsList, IClickItemMajor iClickMajor) {
        this.fragmentActivity = fragmentActivity;
        this.majorsList = majorsList;
        this.iClickMajor = iClickMajor;
    }

    public MajorsAdapter(Fragment mFragment, List<Majors> majorsList, IClickItemMajor iClickMajor) {
        this.mFragment = mFragment;
        this.majorsList = majorsList;
        this.iClickMajor = iClickMajor;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.major_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Majors majors = majorsList.get(position);
        holder.major.setText(majorsList.get(position).getMajors());
        holder.cvMajor.setOnClickListener(view -> iClickMajor.onClickMajor(majors));
    }

    @Override
    public int getItemCount() {
        return majorsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView major;
        CardView cvMajor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            major = itemView.findViewById(R.id.nameMajor);
            cvMajor = itemView.findViewById(R.id.cv_major_item);
        }
    }
}