package com.smartisan.onestepdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import smartisanos.api.OneStepHelper;

public class MainActivity extends Activity {
    private OneStepHelper mOneStepHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOneStepHelper = OneStepHelper.getInstance(MainActivity.this);
        View textView = findViewById(R.id.text);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOneStepHelper.isOneStepShowing()) {
                    mOneStepHelper.dragText(v, "永远年轻,永远热泪盈眶!");
                    return true;
                }
                return false;
            }
        });
        View linkView = findViewById(R.id.link);
        linkView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOneStepHelper.isOneStepShowing()) {
                    mOneStepHelper.dragLink(v, "http://t.tt");
                    return true;
                }
                return false;
            }
        });
//        View imageView = findViewById(R.id.image);
//        imageView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                if (mOneStepHelper.isOneStepShowing()) {
////                    mOneStepHelper.dragImage();
//                    return true;
//                }
//                return false;
//            }
//        });
//        View fileView = findViewById(R.id.file);
//        fileView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                if (OneStepHelper.getInstance(MainActivity.this).isOneStepShowing()) {
//                    OneStepHelper.getInstance(MainActivity.this).dragText(v, "永远年轻,永远热泪盈眶!");
//                    return true;
//                }
//                return false;
//            }
//        });
    }
}
