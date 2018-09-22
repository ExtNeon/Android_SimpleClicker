package com.example.stdcounter;

import android.content.res.Resources;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Integer counter = 0;
    private static final String TAG = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        redrawNumber();
    }

    @Override
    public void onClick(View v) {
        counter++;
        redrawNumber();
    }

    private void redrawNumber() {
        TextView counterView = findViewById(R.id.txt_counter);
        int size = (int) pxFromDp(80 + 30 * counter.toString().length());
        counterView.setHeight(size);
        counterView.setWidth(size);
        //counterView.setLayoutParams(new AbsListView.LayoutParams(100, 100));
        counterView.setText(counter.toString());
    }

    private float dpFromPx(float px) {
        return px / getApplicationContext().getResources().getDisplayMetrics().density;
    }

    private float pxFromDp(float dp) {
        return dp * getApplicationContext().getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("counter")) {
            counter = savedInstanceState.getInt("counter");
            redrawNumber();
        }
        Log.d(TAG, "onRestoreInstanceState");
    }
}
