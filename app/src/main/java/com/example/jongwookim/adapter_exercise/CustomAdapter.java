package com.example.jongwookim.adapter_exercise;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
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



    public CustomAdapter(Context context, int resource, ArrayList<String> Uris) {
        super(context,resource,Uris);
        mContext = context;
        mResLayoutId = resource;
        mImageUri = Uris;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("Joey", "position " + position);
        View rowView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(mResLayoutId, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.listImageView);

        URL Url;
        try {
            Url = new URL(mImageUri.get(position));
            new imageAsyncTask(Url, imageView).execute();

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

    public class imageAsyncTask extends AsyncTask<Void, Void, Void> {
        private Bitmap mBitmap;
        private URL mUrl;
        private ImageView mImageView;
        public imageAsyncTask(URL url, ImageView image) {
            mUrl = url;
            mImageView = image;
        }


        @Override
        protected Void doInBackground(Void... params) {
            try {
                mBitmap = BitmapFactory.decodeStream(mUrl.openConnection().getInputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mImageView.setImageBitmap(mBitmap);
        }
    }
}
