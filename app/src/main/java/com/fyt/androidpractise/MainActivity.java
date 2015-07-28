package com.fyt.androidpractise;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {
    private Spinner _sp = null;
    private Spinner _spArea = null;
    private String[][] areaData = new String[][]{
            {"东城", "西城", "朝阳", "海淀"},
            {"浦东", "闵行", "上1", "上2"},
            {"广1", "广2"},
            {"深1", "深2"} };
    private ArrayAdapter<CharSequence> adapterArea = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this._sp = (Spinner)super.findViewById(R.id.spn);
        this._spArea = (Spinner)super.findViewById(R.id.spn_area);

        _sp.setOnItemSelectedListener(new spItemSelectedListener());
    }

    private class spItemSelectedListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            MainActivity.this.adapterArea = new ArrayAdapter<CharSequence>(MainActivity.this,
                    android.R.layout.simple_dropdown_item_1line,
                    MainActivity.this.areaData[position]);
            MainActivity.this.adapterArea.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item);
            MainActivity.this._spArea.setAdapter(MainActivity.this.adapterArea);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
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
