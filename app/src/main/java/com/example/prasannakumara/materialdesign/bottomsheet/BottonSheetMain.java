package com.example.prasannakumara.materialdesign.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.prasannakumara.materialdesign.R;

import it.sephiroth.android.library.tooltip.Tooltip;

/**
 * Created by PrasannakumarA on 5/10/2017.
 */

public class BottonSheetMain extends AppCompatActivity {
    BottomSheetBehavior mBottomSheetBehavior1;
    Button mButton1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_main);
        final View bottomSheet = findViewById(R.id.bottom_sheet1);
        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet);

        mButton1 = (Button) findViewById(R.id.button_1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheet.post(new Runnable() {
                    @Override
                    public void run() {
                        if(mBottomSheetBehavior1.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                            mBottomSheetBehavior1.setPeekHeight(100);
                            mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
                            mButton1.setText("Expanded");
                        }
                        else {
                            mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
                            mButton1.setText("collapsed");
                        }
//                        mBottomSheetBehavior1.setPeekHeight(100);
//                        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                });


//                if(mBottomSheetBehavior1.getState() != BottomSheetBehavior.STATE_EXPANDED) {
//                    mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
//                    mButton1.setText("Expanded");
//                }
//                else {
//                    mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                    mButton1.setText("collapsed");
//                }
            }
        });





    }


}
