package com.example.prasannakumara.materialdesign.videostream;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasannakumara.materialdesign.R;
import com.example.prasannakumara.materialdesign.RecyclerViewAdapter;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import java.util.ArrayList;

/**
 * Created by DELL on 15-12-2017.
 */

public class ExoRecyclerView extends RecyclerView.Adapter<ExoRecyclerView.MyViewHoldre> {

    private static RecyclerViewClickListener context;
    ArrayList<String> passarray;


    SimpleExoPlayer exoPlayer;

    public ExoRecyclerView(RecyclerViewClickListener context, ArrayList<String> passarray) {
        this.context = context;
        this.passarray = passarray;
    }

    @Override
    public ExoRecyclerView.MyViewHoldre onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view_exo_rv, parent, false);
        return new ExoRecyclerView.MyViewHoldre(view);

    }

    @Override
    public void onBindViewHolder(ExoRecyclerView.MyViewHoldre holder, final int position) {

        final ExoPlayer myActivity = (ExoPlayer) context;


        try {
//            exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exo_player);
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance((Context) ExoRecyclerView.context, trackSelector);

            Uri videoURI = Uri.parse(passarray.get(position));
            DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory("exo_player");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            final MediaSource videosource = new ExtractorMediaSource(videoURI, defaultHttpDataSourceFactory, extractorsFactory, null, null);
            holder.exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(videosource);

            holder.exoPlayerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText((Context) ExoRecyclerView.context, "asdfas", Toast.LENGTH_SHORT).show();
                }
            });

//            exoPlayer.setPlayWhenReady(true);
           /* holder.exoPlayerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });*/


        } catch (Exception e) {
            Log.e("MainActivity", "exoplayer error" + e.toString());
        }

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ExoPlayer) context).someMethod();

                ExoPlayerFrag newFragment = new ExoPlayerFrag();
                FragmentTransaction transaction = myActivity.getSupportFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putString("name", passarray.get(position)); //key and value
//set Fragmentclass Arguments
                newFragment.setArguments(bundle);
                transaction.replace(R.id.frag_main, newFragment)
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

    }

    @Override
    public int getItemCount() {
        return passarray.size();
    }

//    @Override
//    public void onClick(View v)
//    {
//        itemListener.recyclerViewListClicked(v, this.getPosition());
//
//    }

    public class MyViewHoldre extends RecyclerView.ViewHolder implements View.OnClickListener {
        SimpleExoPlayerView exoPlayerView;
        Button button;

        public MyViewHoldre(View itemView) {
            super(itemView);
            exoPlayerView = (SimpleExoPlayerView) itemView.findViewById(R.id.item_exo_player);
            button = (Button) itemView.findViewById(R.id.btn_exo);
        }

        @Override
        public void onClick(View v) {
            context.recyclerViewListClicked(v, this.getLayoutPosition());
        }
    }

}
