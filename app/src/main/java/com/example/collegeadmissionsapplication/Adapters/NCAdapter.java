package com.example.collegeadmissionsapplication.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeadmissionsapplication.Models.NameCard;
import com.example.collegeadmissionsapplication.R;
import com.example.collegeadmissionsapplication.Scan.Capture;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.List;

public class NCAdapter extends RecyclerView.Adapter<NCAdapter.ViewHolder>{

    List<NameCard> mNameCardList;
    Activity mActivity;

    @SuppressLint("NotifyDataSetChanged")
    public NCAdapter(Activity activity, List<NameCard> mNameCardList) {
        this.mActivity = activity;
        this.mNameCardList = mNameCardList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NameCard nameCard = mNameCardList.get(position);
        if(nameCard != null){
            holder.name.setText(nameCard.getName());
            holder.item1.setText(nameCard.getItem1());
            holder.item2.setText(nameCard.getItem2());
            holder.item3.setText(nameCard.getItem3());
            holder.item4.setText(nameCard.getItem4());
            holder.item5.setText(nameCard.getItem5());
            holder.item6.setText(nameCard.getItem6());
            if(nameCard.getItem1().equals("")){
                holder.nameCard.setVisibility(View.GONE);
                holder.scanMethod.setOnClickListener(view -> {
                    IntentIntegrator intentIntegrator = new IntentIntegrator(mActivity);
                    intentIntegrator.setPrompt("Để có đèn flash, hãy sử dụng phím tăng âm lượng");
                    intentIntegrator.setBeepEnabled(true);
                    intentIntegrator.setOrientationLocked(true);
                    intentIntegrator.setCaptureActivity(Capture.class);
                    intentIntegrator.initiateScan();
                });
            }else{
                holder.defaultLL.setVisibility(View.GONE);
                holder.scan.setOnClickListener(view -> {
                    IntentIntegrator intentIntegrator = new IntentIntegrator(mActivity);
                    intentIntegrator.setPrompt("Để có đèn flash, hãy sử dụng phím tăng âm lượng");
                    intentIntegrator.setBeepEnabled(true);
                    intentIntegrator.setOrientationLocked(true);
                    intentIntegrator.setCaptureActivity(Capture.class);
                    intentIntegrator.initiateScan();
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if(mNameCardList != null){
            return mNameCardList.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView item1, item2, item3, item4, item5, item6, name;
        ImageView scan;
        LinearLayout nameCard, defaultLL, scanMethod;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameIC);
            scan = itemView.findViewById(R.id.scan);
            scanMethod = itemView.findViewById(R.id.scanMethod);
            item1 = itemView.findViewById(R.id.nc_item1);
            item2 = itemView.findViewById(R.id.nc_item2);
            item3 = itemView.findViewById(R.id.nc_item3);
            item4 = itemView.findViewById(R.id.nc_item4);
            item5 = itemView.findViewById(R.id.nc_item5);
            item6 = itemView.findViewById(R.id.nc_item6);

            nameCard = itemView.findViewById(R.id.nameCard);
            defaultLL = itemView.findViewById(R.id.nameCardDemo);
        }
    }
}
