package com.smartisan.onestepdemo;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextDragPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import smartisanos.api.OneStepHelper;
import smartisanos.util.SidebarUtils;

public class MainActivity extends Activity {

    private static final String DRAG_IMG_FILE_NAME = "033202yw7e3lawlczeua7d.jpg";
    private static final String SAMPLE_FILE_DIR = Environment.getExternalStorageDirectory() + "/OneStepSample/";

    private OneStepHelper mOneStepHelper;
    private TextDragPopupWindow mTextDragPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new File(SAMPLE_FILE_DIR).mkdir();

        TextView introduce = (TextView) findViewById(R.id.how_to_use);
        introduce.setPaintFlags(introduce.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.smartisan.com/pr/#/video/onestep-Introduction");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        mOneStepHelper = OneStepHelper.getInstance(MainActivity.this);
        View textView = findViewById(R.id.text);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOneStepHelper.isOneStepShowing()) {
                    mOneStepHelper.dragText(v, "永远年轻,永远热泪盈眶!");
                    return true;
                }else {
                    Toast.makeText(MainActivity.this, "还没进入OneStep模式呢.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        findViewById(R.id.text_card_style).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    //3张图片的尺寸请参考 OneStepHelper 接口说明。
                    //background 或 content 为空时使用默认图片;
                    //content 和 avatar 同时为空时，相当于调用 mOneStepHelper.dragText(View, CharSequence);
                    Bitmap background = null;
                    Bitmap content = BitmapFactory.decodeResource(getResources(), R.mipmap.drag_card_content);
                    Bitmap avatar = BitmapFactory.decodeResource(getResources(), R.mipmap.music_cover);
                    mOneStepHelper.dragText(view, "拖拽的文本内容", background, content, avatar);
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

        findViewById(R.id.file).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    File f = createTestFileIfNotExists("drag_file_test.txt");
                    mOneStepHelper.dragFile(view, f, "text/plain", f.getName());
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.file_card_style).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    File f = createTestFileIfNotExists("drag_file_test.mp3");
                    Bitmap content = BitmapFactory.decodeResource(getResources(), R.mipmap.drag_card_content);
                    Bitmap avatar = BitmapFactory.decodeResource(getResources(), R.mipmap.music_cover);
                    mOneStepHelper.dragFile(view, f, "audio/mpeg", null, content, avatar);
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.image).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    File f = new File(SAMPLE_FILE_DIR, DRAG_IMG_FILE_NAME);
                    if (!f.exists()) {
                        copyAssetFile2Sdcard(DRAG_IMG_FILE_NAME);
                    }
                    mOneStepHelper.dragImage(view, f, "image/jpeg");
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.image_show_specific).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    File f = new File(SAMPLE_FILE_DIR, DRAG_IMG_FILE_NAME);
                    if (!f.exists()) {
                        copyAssetFile2Sdcard(DRAG_IMG_FILE_NAME);
                    }
                    Bitmap specificContent = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_fso_folder);
                    mOneStepHelper.dragImage(view, specificContent, f, "image/png");
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.multi_images).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    int size = 3;
                    File[] files = new File[size];
                    String[] mimeTypes = new String[size];
                    File f1 = new File(SAMPLE_FILE_DIR, DRAG_IMG_FILE_NAME);
                    if (!f1.exists()) {
                        copyAssetFile2Sdcard(DRAG_IMG_FILE_NAME);
                    }
                    files[0] = f1;
                    mimeTypes[0] = "image/jpeg";

                    File f2 = new File(SAMPLE_FILE_DIR, "music_cover.png");
                    if (!f2.exists()) {
                        copyAssetFile2Sdcard("music_cover.png");
                    }
                    files[1] = f2;
                    mimeTypes[1] = "image/png";

                    File f3 = new File(SAMPLE_FILE_DIR, "ic_fso_folder.png");
                    if (!f3.exists()) {
                        copyAssetFile2Sdcard("ic_fso_folder.png");
                    }
                    files[2] = f3;
                    mimeTypes[2] = "image/png";

                    mOneStepHelper.dragMultipleImages(view, files, mimeTypes);
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


    private File createTestFileIfNotExists(String filename) {
        File testFile = new File(SAMPLE_FILE_DIR, filename);
        if (!testFile.exists()) {
            try {
                testFile.createNewFile();
            } catch (IOException e) {
            }
        }
        return testFile;
    }

    private void copyAssetFile2Sdcard(String assetFile) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = getAssets().open(assetFile);
            String destFilePath = createTestFileIfNotExists(assetFile).getAbsolutePath();
            File f = new File(destFilePath);
            outputStream = new FileOutputStream(f);
            byte[] buf = new byte[1024 * 4];
            int len = 0;
            while((len = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {}
        }
    }

}
