package com.example.prasannakumara.materialdesign.steppers;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.prasannakumara.materialdesign.R;

/**
 * Created by PrasannakumarA on 5/16/2017.
 */

public class StepperFragTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_stepper_two, container, false);
        View controls = view.findViewById(R.id.controls_toolbar);
        ImageView tickImgOne = (ImageView) controls.findViewById(R.id.image_tick_one);
        ImageView tickImgTwo = (ImageView) controls.findViewById(R.id.image_tick_two);
        ImageView numOne = (ImageView) controls.findViewById(R.id.image_one);
        ImageView numteo = (ImageView) controls.findViewById(R.id.image_two);

        numteo.setVisibility(View.INVISIBLE);
        tickImgOne.setVisibility(View.VISIBLE);


        ProgressBar progressBar = (ProgressBar) controls.findViewById(R.id.progressBar);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            // will update the "progress" propriety of seekbar until it reaches progress
            ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 100);
            animation.setDuration(500); // 0.5 second
            animation.setInterpolator(new DecelerateInterpolator());
            animation.start();

        } else
            progressBar.setProgress(100);



            numOne.setVisibility(View.INVISIBLE);
            tickImgTwo.setVisibility(View.VISIBLE);


        return view;
    }
}
