package com.example.prasannakumara.materialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.prasannakumara.materialdesign.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ComponetsNameModel> comparr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        comparr = new ArrayList<>();
        comparr.add(new ComponetsNameModel("BottomSheet", "BottonSheetMain"));
        comparr.add(new ComponetsNameModel("Chipset","asdfsd"));
        comparr.add(new ComponetsNameModel("Tooltip","something"));
        comparr.add(new ComponetsNameModel("RippleEffct","nothding"));
        comparr.add(new ComponetsNameModel("Bottom Layout","onething"));
        comparr.add(new ComponetsNameModel("Steppers","sampleSteppers"));
        comparr.add(new ComponetsNameModel("Pagination","sample pagination"));
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(getApplicationContext(),comparr);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
