package com.example.prasannakumara.materialdesign.bottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.prasannakumara.materialdesign.R;

/**
 * Created by PrasannakumarA on 5/15/2017.
 */

public class BottmNav extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;
    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnav);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.firsr_item:
                        Toast.makeText(getApplicationContext(), "one clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.second_item:
                        Toast.makeText(getApplicationContext(), "second clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.third_item:
                        Toast.makeText(getApplicationContext(), "three clicked", Toast.LENGTH_SHORT).show();
                        break;
                }


                return true;
            }
        });

    }
}
