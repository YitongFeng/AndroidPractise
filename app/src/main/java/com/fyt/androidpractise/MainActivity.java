package com.fyt.androidpractise;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
    private ImageSwitcher switcher = null;
    private Button previous = null;
    private Button next = null;
    private int curPic = 0;
    private int pic[] = {R.drawable.ispic_a, R.drawable.ispic_b, R.drawable.ispic_c,
        R.drawable.ispic_d, R.drawable.ispic_e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.switcher = (ImageSwitcher) super.findViewById(R.id.switcher);
        this.switcher.setFactory(new ViewFactoryImpl());
        this.switcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left));
        this.switcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right));
        this.switcher.setImageResource(pic[0]);

        this.previous = (Button) super.findViewById(R.id.previous);
        this.next = (Button) super.findViewById(R.id.next);
        this.checkButEnable();
        this.previous.setOnClickListener(new ClickListenerPrevious());
        this.next.setOnClickListener(new ClickListenerNext());
    }

    private class ClickListenerPrevious implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            MainActivity.this.curPic -= 1;
            MainActivity.this.switcher.setImageResource(pic[curPic]);
            MainActivity.this.checkButEnable();
        }
    }

    private class ClickListenerNext implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            MainActivity.this.curPic += 1;
            MainActivity.this.switcher.setImageResource(pic[curPic]);
            MainActivity.this.checkButEnable();
        }
    }

    private class ViewFactoryImpl implements ViewSwitcher.ViewFactory{
        @Override
        public View makeView() {
            ImageView img = new ImageView(MainActivity.this);
            img.setBackgroundColor(0xffff);
            img.setScaleType(ImageView.ScaleType.CENTER);
            img.setLayoutParams(new ImageSwitcher.LayoutParams(
                    ImageSwitcher.LayoutParams.WRAP_CONTENT, ImageSwitcher.LayoutParams.WRAP_CONTENT));
            return img;
        }
    }

    public void checkButEnable(){
        if(this.curPic == 0)
            this.previous.setEnabled(false);
        else
            this.previous.setEnabled(true);
        if(this.curPic < this.pic.length - 1)
            this.next.setEnabled(true);
        else
            this.next.setEnabled(false);
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
