package com.example.prasannakumara.materialdesign.videostream;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.prasannakumara.materialdesign.R;

import java.net.URI;

/**
 * Created by DELL on 09-12-2017.
 */

public class VideoMain extends AppCompatActivity {

    ProgressDialog progressDialog;
    VideoView videoView;
    Button button;
    ImageView playpausebtn;

    String url = "https://www.dropbox.com/s/r6olw0u7dga2uj2/VIDEO0298.mp4?dl=0";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.video_layout);

        videoView = (VideoView) findViewById(R.id.video_view);

        playpausebtn = (ImageView) findViewById(R.id.play_pause_btn);
        playpausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(VideoMain.this);
                progressDialog.setMessage("plese wait");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();


                try {
                    if(!videoView.isPlaying())
                    {
                        Uri uri=Uri.parse(url);
                        videoView.setVideoURI(uri);
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                            }
                        });
                    }
                    else
                    {
                        videoView.pause();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        progressDialog.dismiss();
                        mp.setLooping(true);
                        videoView.start();
                    }
                });


            }
        });
    }



}
