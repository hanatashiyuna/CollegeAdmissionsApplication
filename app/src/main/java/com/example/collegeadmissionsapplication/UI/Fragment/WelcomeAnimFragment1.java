package com.example.collegeadmissionsapplication.UI.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.collegeadmissionsapplication.Adapters.AnimFragmentAdapter;
import com.example.collegeadmissionsapplication.R;

public class WelcomeAnimFragment1 extends Fragment {

    View view;
    ImageView light, human, smallCircle, bigCircle;
    Animation lightAnim, humanAnim, smallCircleAnim, bigCircleAnim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_welcome_anim1, container, false);
        light = view.findViewById(R.id.light);
        human = view.findViewById(R.id.human);
        smallCircle = view.findViewById(R.id.small_circle);
        bigCircle = view.findViewById(R.id.big_circle);

        lightAnim = AnimationUtils.loadAnimation(getContext(), R.anim.top_to_bottom);
        humanAnim = AnimationUtils.loadAnimation(getContext(), R.anim.left_to_right);
        smallCircleAnim = AnimationUtils.loadAnimation(getContext(), R.anim.right_to_left);
        bigCircleAnim = AnimationUtils.loadAnimation(getContext(), R.anim.slanted_up_right);

        light.startAnimation(lightAnim);
        human.startAnimation(humanAnim);
        smallCircle.startAnimation(smallCircleAnim);
        bigCircle.startAnimation(bigCircleAnim);
        return view;
    }
}