package com.fyt.androidpractise;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ActionBarActivity {
    private int[] pic = new int[]{R.drawable.pic_oracle, R.drawable.pic_javase,
            R.drawable.pic_javaweb, R.drawable.pic_javaee, R.drawable.pic_android};
    private String data[][] = new String[][]{{"Oracle", "A"}, {"JavaSE", "B"}, {"JavaWeb", "C"},
            {"JavaEE", "D"}, {"Android", "E"}};
    private List<Map<String, String>> list = new ArrayList<>();
    private SimpleAdapter simpleAdapter = null;
    private ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.listView = (ListView)super.findViewById(R.id.datalist);
        for(int i = 0; i < data.length; i++){
            Map<String, String> map = new HashMap<>();
            map.put("pic", String.valueOf(pic[i]));
            map.put("title", data[i][0]);
            map.put("author", data[i][1]);
            map.put("star", String.valueOf(R.drawable.start_05));
            this.list.add(map);
        }
        this.simpleAdapter = new SimpleAdapter(this, this.list, R.layout.data_list,
                new String[]{"pic", "title", "author", "star"}, new int[]{R.id.pic, R.id.title,
                R.id.author, R.id.star});
        this.listView.setAdapter(this.simpleAdapter);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
