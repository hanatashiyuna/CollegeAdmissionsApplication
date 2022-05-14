package com.example.collegeadmissionsapplication.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.collegeadmissionsapplication.UI.Fragment.WelcomeAnimFragment1;
import com.example.collegeadmissionsapplication.UI.Fragment.WelcomeAnimFragment2;
import com.example.collegeadmissionsapplication.UI.Fragment.WelcomeAnimFragment3;
import com.example.collegeadmissionsapplication.UI.Fragment.WelcomeAnimFragment4;

public class AnimFragmentAdapter extends FragmentStateAdapter {

    public static final int NUM_PAGES = 4;

    public AnimFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new WelcomeAnimFragment1();
            case 1:
                return new WelcomeAnimFragment2();
            case 2:
                return new WelcomeAnimFragment3();
            case 3:
                return new WelcomeAnimFragment4();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
