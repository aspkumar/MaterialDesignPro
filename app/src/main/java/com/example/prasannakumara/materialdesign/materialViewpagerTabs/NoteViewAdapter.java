package com.example.prasannakumara.materialdesign.materialViewpagerTabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.prasannakumara.materialdesign.R;
import com.squareup.picasso.Picasso;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class NoteViewAdapter extends BaseAdapter {


    private LayoutInflater inflater;
    private ArrayList<RestaurantDup> notes;
    Context context;
    String note;


    public NoteViewAdapter(ArrayList<RestaurantDup> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }





    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (convertView == null) {
            layout = inflater.inflate(R.layout.flip_activity_main, null);
        }


        final ImageView imageView= (ImageView) layout.findViewById(R.id.imageView);
        final Button share= (Button) layout.findViewById(R.id.share_btn);

        //Get's value from our ArrayList by the position
        note = notes.get(position).getName();

      /*  // Load image
        Glide.with(imageView.getContext())
                .load(notes.get(position).getPhoto())
                .into(imageView);
*/
        // Fire async request to load image
        Picasso.with(context).load(notes.get(position).getPhoto()).into(imageView);


        final View finalLayout = layout;
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }


        });


        TextView tView = (TextView) layout.findViewById(R.id.note);

        tView.setText(note);
        return layout;
    }







    private void prepareShareIntent(Bitmap bmp) {
        Uri bmpUri = getLocalBitmapUri(bmp); // see previous remote images section
        // Construct share intent as described above based on bitmap

        Intent shareIntent = new Intent();
        shareIntent.setPackage("com.whatsapp");
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,note);
        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
        shareIntent.setType("image");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(Intent.createChooser(shareIntent, "Share Opportunity"));

    }
    private Uri getLocalBitmapUri(Bitmap bmp) {
        Uri bmpUri = null;
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bmpUri = Uri.fromFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }






}
