package com.example.prasannakumara.materialdesign.steppers;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prasannakumara.materialdesign.R;

/**
 * Created by PrasannakumarA on 5/16/2017.
 */

public class StepperFragOne extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_stepper_one,container,false);


        return view;
    }
}
