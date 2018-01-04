package com.example.prasannakumara.materialdesign.videostream;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.prasannakumara.materialdesign.R;
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

/**
 * Created by DELL on 16-12-2017.
 */


public class ExoPlayerFrag extends android.support.v4.app.Fragment {

    String url;
    SimpleExoPlayer exoPlayer;
    SimpleExoPlayerView exoPlayerView;
    String strtext="";


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exo,
                container, false);


        try {
            strtext = getArguments().getString("name"); //fetching value by key
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(strtext.equals(null)||strtext.equals("")){
            url = "https://www.dropbox.com/s/r6olw0u7dga2uj2/VIDEO0298.mp4?dl=1";
        }
        else
            url=strtext;



        try {
            exoPlayerView = (SimpleExoPlayerView) view.findViewById(R.id.frag_item_exo_player);
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector);

            Uri videoURI = Uri.parse(url);
            DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory("exo_player");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            final MediaSource videosource = new ExtractorMediaSource(videoURI, defaultHttpDataSourceFactory, extractorsFactory, null, null);
            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(videosource);

        } catch (Exception e) {
            Log.e("MainActivity", "exoplayer error" + e.toString());
        }


        return view;

    }
}
