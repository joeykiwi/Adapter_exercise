package com.example.jongwookim.adapter_exercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import java.io.IOException;
import java.net.URL;

/**
 * Created by jongwookim on 3/4/15.
 */
public class ImageLoader{
    URL mUrl;
    public ImageLoader(URL url) {
        mUrl = url;
    }

    public Bitmap getImage() throws IOException {
        Bitmap bitmap = BitmapFactory.decodeStream(mUrl.openConnection().getInputStream());
        return bitmap;
    }

}
