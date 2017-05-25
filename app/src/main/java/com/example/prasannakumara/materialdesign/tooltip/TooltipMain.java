package com.example.prasannakumara.materialdesign.tooltip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.prasannakumara.materialdesign.R;

import it.sephiroth.android.library.tooltip.Tooltip;

/**
 * Created by PrasannakumarA on 5/12/2017.
 */

public class TooltipMain extends AppCompatActivity {
   TextView tooltip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltip);

        tooltip= (TextView) findViewById(R.id.tooltip_TV);


        //tooltip api
        tooltip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tooltip.make(TooltipMain.this,
                        new Tooltip.Builder(101)
                                .anchor(tooltip, Tooltip.Gravity.BOTTOM)
                                .closePolicy(new Tooltip.ClosePolicy()
                                        .insidePolicy(true, false)
                                        .outsidePolicy(true, false), 30000)
                                .activateDelay(800)
                                .showDelay(300)
                                .text("Click")
                                .maxWidth(500)
                                .withArrow(true)
                                .withOverlay(true)
                                .floatingAnimation(Tooltip.AnimationBuilder.DEFAULT)
                                .build()
                ).show();
            }
        });

    }
}
