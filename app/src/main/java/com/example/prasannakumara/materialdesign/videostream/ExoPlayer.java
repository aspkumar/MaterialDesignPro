package com.example.prasannakumara.materialdesign.videostream;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import java.util.ArrayList;

/**
 * Created by DELL on 12-12-2017.
 */

public class ExoPlayer extends AppCompatActivity implements RecyclerViewClickListener {

    SimpleExoPlayerView exoPlayerView;
    SimpleExoPlayer exoPlayer;
    String videoURL = "https://www.dropbox.com/s/cqw98w3hcf4ilj7/WhatsApp1.mp4?dl=1";
    ArrayList<String> urlList;
    RecyclerView mRecyclerView;
    FrameLayout fragmentframe;
    View firstBorder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exo_player);

        fragmentframe = (FrameLayout) findViewById(R.id.frag_main);
        firstBorder=findViewById(R.id.first_border);


        urlList = new ArrayList<>();
        urlList.add("https://www.dropbox.com/s/cqw98w3hcf4ilj7/WhatsApp1.mp4?dl=1");
        urlList.add("http://techslides.com/demos/sample-videos/small.mp4");
        urlList.add("https://www.dropbox.com/s/r6olw0u7dga2uj2/VIDEO0298.mp4?dl=1");
        urlList.add("https://www.dropbox.com/s/cqw98w3hcf4ilj7/WhatsApp1.mp4?dl=1");
        urlList.add("http://techslides.com/demos/sample-videos/small.mp4");
        urlList.add("https://www.dropbox.com/s/cqw98w3hcf4ilj7/WhatsApp1.mp4?dl=1");
        urlList.add("https://www.dropbox.com/s/r6olw0u7dga2uj2/VIDEO0298.mp4?dl=1");
        urlList.add("http://techslides.com/demos/sample-videos/small.mp4");
        urlList.add("https://www.dropbox.com/s/cqw98w3hcf4ilj7/WhatsApp1.mp4?dl=1");
        urlList.add("http://techslides.com/demos/sample-videos/small.mp4");
        urlList.add("https://www.dropbox.com/s/cqw98w3hcf4ilj7/WhatsApp1.mp4?dl=1");

//        ExoPlayerFrag exoPlayerFrag = new ExoPlayerFrag();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction()
//                .replace(R.id.frag_main, exoPlayerFrag)
//                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
//                .show(exoPlayerFrag)
//                .commit();


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_exo);
        ExoRecyclerView adapter = new ExoRecyclerView(this, urlList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


//                recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
//        RecyclerViewAdapter adapter=new RecyclerViewAdapter(getApplicationContext(),comparr);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//
        /*try {
            exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exo_player);
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

            Uri videoURI = Uri.parse(videoURL);
            DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory("exo_player");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource videosource = new ExtractorMediaSource(videoURI, defaultHttpDataSourceFactory, extractorsFactory, null, null);
            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(videosource);
            exoPlayer.setPlayWhenReady(true);
        } catch (Exception e) {
            Log.e("MainActivity", "exoplayer error" + e.toString());
        }*/

    }


    @Override
    public void recyclerViewListClicked(View v, int position) {

        Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();


    }


    public void someMethod() {
        Toast.makeText(getApplicationContext(), "fasdfas", Toast.LENGTH_LONG).show();
//        ViewGroup.LayoutParams params=mRecyclerView.getLayoutParams();
//        params.height=400;
//        mRecyclerView.setLayoutParams(params);
//mRecyclerView.setVisibility(View.GONE);
        fragmentframe.setVisibility(View.VISIBLE);
        firstBorder.setVisibility(View.VISIBLE);
    }
}


