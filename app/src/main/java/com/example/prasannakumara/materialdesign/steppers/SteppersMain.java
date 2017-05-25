package com.example.prasannakumara.materialdesign.steppers;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasannakumara.materialdesign.R;

/**
 * Created by PrasannakumarA on 5/16/2017.
 */

public class SteppersMain extends AppCompatActivity {
    int curentfrag;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepper);


        View bottomcontrols = findViewById(R.id.bottom_controls);
        ImageView imgback = (ImageView) bottomcontrols.findViewById(R.id.img_back);
        ImageView imgforward = (ImageView) bottomcontrols.findViewById(R.id.img_forward);
        TextView txtback = (TextView) bottomcontrols.findViewById(R.id.text_back);

        curentfrag = 1;
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragment_layout, new StepperFragOne());
        ft.commit();
//        txtback.setText(String.valueOf(Build.TIME));


        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curentfrag == 1) {
                    Toast.makeText(getApplicationContext(), "no previous page available", Toast.LENGTH_SHORT).show();
                } else if (curentfrag == 2) {
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_layout, new StepperFragOne());
                    ft.commit();
                    curentfrag = 1;
                } else if (curentfrag == 3) {
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_layout, new StepperFragTwo());
                    ft.commit();
                    curentfrag = 2;
                }

            }
        });


        imgforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curentfrag == 1) {
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_layout, new StepperFragTwo());
                    ft.commit();

                    curentfrag = 2;
                } else if (curentfrag == 2) {
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_layout, new StepperFragThree());
                    ft.commit();
                    curentfrag = 3;
                } else if (curentfrag == 3) {
                    Toast.makeText(getApplicationContext(), "last page", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
