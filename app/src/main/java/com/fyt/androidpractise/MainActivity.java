package com.fyt.androidpractise;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    private ImageView img = null;
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.img = (ImageView)super.findViewById(R.id.img);
        this.btn = (Button)super.findViewById(R.id.btn);

        this.btn.setOnClickListener(new ChangeScreenListener());
    }

    private class ChangeScreenListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(MainActivity.this.getRequestedOrientation() ==
                    ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                MainActivity.this.btn.setText("Unchangeable");
            else if(MainActivity.this.getRequestedOrientation() ==
                    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            else if(MainActivity.this.getRequestedOrientation() ==
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig){
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            MainActivity.this.btn.setText("Landscape now");
            MainActivity.this.img.setImageResource(R.drawable.lyf_lan);
        }
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            MainActivity.this.btn.setText("Portrait now");
            MainActivity.this.img.setImageResource(R.drawable.lyf_por);
        }
        super.onConfigurationChanged(newConfig);
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
