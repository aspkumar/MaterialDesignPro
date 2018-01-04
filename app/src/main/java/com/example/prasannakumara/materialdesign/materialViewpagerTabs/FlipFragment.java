package com.example.prasannakumara.materialdesign.materialViewpagerTabs;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;


import com.example.prasannakumara.materialdesign.R;

import java.util.ArrayList;

import se.emilsjolander.flipview.FlipView;

/**
 * Created by DELL on 09-12-2017.
 */

public class FlipFragment extends android.support.v4.app.Fragment {


    private FlipView flipView;
    ArrayList<RestaurantDup> names;
    private static final String TAG = "MainActivity";
    private NoteViewAdapter mAdapter;

    public static FlipFragment newInstance() {
        return new FlipFragment();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.aactivity_main, container, false);

        flipView = (FlipView) rootView.findViewById(R.id.flip_view);
//        loadData();
//        loadListener();

        names = new ArrayList<>();
        names.add(new RestaurantDup("Accidental Cosplay?", "https://i.imgur.com/6Q5zfrp.jpg"));
        names.add(new RestaurantDup("Accidental Cosplay?", "https://i.imgur.com/6Q5zfrp.jpg"));
        names.add(new RestaurantDup("Accidental Cosplay?", "https://i.imgur.com/6Q5zfrp.jpg"));
        names.add(new RestaurantDup("Accidental Cosplay?", "https://i.imgur.com/6Q5zfrp.jpg"));
        names.add(new RestaurantDup("Accidental Cosplay?", "https://i.imgur.com/6Q5zfrp.jpg"));
        names.add(new RestaurantDup("Accidental Cosplay?", "https://i.imgur.com/6Q5zfrp.jpg"));
        names.add(new RestaurantDup("Accidental Cosplay?", "https://i.imgur.com/6Q5zfrp.jpg"));
        mAdapter = new NoteViewAdapter(names,getContext());
        flipView.setAdapter((ListAdapter) mAdapter);
        mAdapter.notifyDataSetChanged();
        return rootView;
    }

    }

