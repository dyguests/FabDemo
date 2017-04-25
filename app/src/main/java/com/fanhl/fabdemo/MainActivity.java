package com.fanhl.fabdemo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private Toolbar toolbar;
    private FloatingActionButton fab;

    private NestedScrollView nestedScrollView;
    private TextView view1;
    private TextView view2;
    private TextView view3;
    private TextView view4;
    private TextView view5;
    private TextView view6;
    private TextView view7;
    private TextView view8;
    private TextView view9;
    private TextView view10;
    private TextView view11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
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

    private void assignViews() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nestedScrollView = ((NestedScrollView) findViewById(R.id.nestedScrollView));
        this.view1 = (TextView) findViewById(R.id.view1);
        this.view2 = (TextView) findViewById(R.id.view2);
        this.view3 = (TextView) findViewById(R.id.view3);
        this.view4 = (TextView) findViewById(R.id.view4);
        this.view5 = (TextView) findViewById(R.id.view5);
        this.view6 = (TextView) findViewById(R.id.view6);
        this.view7 = (TextView) findViewById(R.id.view7);
        this.view8 = (TextView) findViewById(R.id.view8);
        this.view9 = (TextView) findViewById(R.id.view9);
        this.view10 = (TextView) findViewById(R.id.view10);
        this.view11 = (TextView) findViewById(R.id.view11);
        this.fab = (FloatingActionButton) findViewById(R.id.fab);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            private boolean isHiding = false;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (ViewUtil.isViewHigher(view6, nestedScrollView)) {
                    Log.d(TAG, "higher");
                    if (fab.getVisibility() == View.INVISIBLE) {
                        isHiding = false;
                        AnimateUtil.showFab(fab);
                    }
                } else {
                    Log.d(TAG, "not higher");
                    if (fab.getVisibility() == View.VISIBLE && !isHiding) {
                        isHiding = true;
                        AnimateUtil.hideFab(fab);
                    }
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void isViewIn() {
        final Rect scrollBounds = new Rect();
        nestedScrollView.getHitRect(scrollBounds);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (view6 != null) {
                    if (view6.getLocalVisibleRect(scrollBounds)) {
                        if (!view6.getLocalVisibleRect(scrollBounds)
                                || scrollBounds.height() < view6.getHeight()) {
                            Log.i(TAG, "BTN APPEAR parcial");
                        } else {
                            Log.i(TAG, "BTN APPEAR FULLY!!!");
                        }
                    } else {
                        Log.i(TAG, "No");
                    }
                }

            }
        });
    }

}
