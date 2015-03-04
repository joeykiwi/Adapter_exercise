package com.example.jongwookim.adapter_exercise;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jongwookim on 3/4/15.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    Context mContext;
    int mResLayoutId;
    ArrayList<String> mImageUri;
    TextView textView;
    ImageView imageView;

    public CustomAdapter(Context context, int resource, ArrayList<String> Uris) {
        super(context,resource,Uris);
        mContext = context;
        mResLayoutId = resource;
        mImageUri = Uris;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(mResLayoutId, parent, false);
        imageView = (ImageView) rowView.findViewById(R.id.listImageView);
        URL mUrl;
        try {
            mUrl = new URL(mImageUri.get(position));
            new imageAsyncTask().execute(mUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

//        ImageLoader imageLoader = new ImageLoader(mUrl);
//        try {
//            imageView.setImageBitmap(imageLoader.getImage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        textView = (TextView) rowView.findViewById(R.id.textForList);
//        textView.setText(mImageUri.get(position));

        return rowView;
    }

    public class imageAsyncTask extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... params) {
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(params[0].openConnection().getInputStream());
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
        }
    }
}
