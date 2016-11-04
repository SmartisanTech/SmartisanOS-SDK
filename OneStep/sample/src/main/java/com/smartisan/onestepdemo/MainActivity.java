package com.smartisan.onestepdemo;

import com.smartisan.onestep.sdk.OneStepHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View textView = (TextView) findViewById(R.id.text);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (OneStepHelper.getInstance(MainActivity.this).isOneStepShowing()) {
                    TextView text = (TextView)v;
                    OneStepHelper.getInstance(MainActivity.this).dragText(text, "Hello World.");
                    return true;
                }
                return false;
            }
        });
    }
}
