package com.example.jongwookim.adapter_exercise;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class AdapterActivity extends ActionBarActivity {
    private ArrayList<String> mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        mImageUri = new ArrayList<String>();
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/10684326_729878647066797_2105336718_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/10693820_460984107377934_849114485_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xfp1/t51.2885-15/s306x306/e15/10601954_676617655754094_565747230_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/928624_679342942153851_1181842888_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/928057_1514244212120474_1715956623_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xap1/t51.2885-15/s306x306/e15/10570120_678052908932063_1405511728_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10561176_427757957362687_172165859_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/10576172_347014075448890_1911967382_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10561176_1495572584013064_1149283813_n.jpg");
        mImageUri.add("http://scontent.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10560916_257110941153605_1295607370_n.jpg");
        String[] mUrl = new String[] {
                "http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/10684326_729878647066797_2105336718_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/10693820_460984107377934_849114485_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xfp1/t51.2885-15/s306x306/e15/10601954_676617655754094_565747230_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/928624_679342942153851_1181842888_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/928057_1514244212120474_1715956623_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xap1/t51.2885-15/s306x306/e15/10570120_678052908932063_1405511728_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10561176_427757957362687_172165859_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xpa1/t51.2885-15/s306x306/e15/10576172_347014075448890_1911967382_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10561176_1495572584013064_1149283813_n.jpg",
                "http://scontent.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10560916_257110941153605_1295607370_n.jpg"
        };

        CustomAdapter adapter = new CustomAdapter(this, R.layout.textview, mImageUri);

        ListView listView = (ListView) findViewById(R.id.listViewTest);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adapter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
