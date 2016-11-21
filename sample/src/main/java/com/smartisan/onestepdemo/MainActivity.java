package com.smartisan.onestepdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextDragPopupWindow;
import android.widget.Toast;

import smartisanos.api.OneStepHelper;

public class MainActivity extends Activity {
    private OneStepHelper mOneStepHelper;
    private TextDragPopupWindow mTextDragPopupWindow;

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

        final Button btn_show_popup = (Button) findViewById(R.id.btn_show_popup);
        btn_show_popup.setOnClickListener(new View.OnClickListener() {

            View.OnDragListener dragListener = new View.OnDragListener() {

                @Override
                public boolean onDrag(View view, DragEvent dragEvent) {
                    Toast.makeText(MainActivity.this, "Drag started", Toast.LENGTH_SHORT).show();
                    return false;
                }
            };

            @Override
            public void onClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    mTextDragPopupWindow = mOneStepHelper.showDragPopupText(btn_show_popup,
                            dragListener,
                            "One Step",
                            btn_show_popup.getLeft(),
                            btn_show_popup.getTop());

                }
            }

        });

        final Button btn_hide_popup = (Button) findViewById(R.id.btn_hide_popup);
        btn_hide_popup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mTextDragPopupWindow != null) {
                    mTextDragPopupWindow.hide();
                }
            }
        });
    }
}
