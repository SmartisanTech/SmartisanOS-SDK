package smartisanos.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import java.io.File;

@Deprecated
public class SidebarUtils {

    public static boolean isSidebarShowing(Context context){

        return false;
    }

    public static void dragText(View view, Context context, CharSequence text) {
    }

    public static void dragText(View view, Context context, CharSequence text, Bitmap background, Bitmap content, Bitmap avatar) {

    }

    public static void dragLink(View view, Context context, CharSequence link) {
    }


    public static void dragFile(View view, Context context, File file, String mimeType, Bitmap background, Bitmap content, Bitmap avatar) {

    }

    public static void dragFile(View view, Context context, File file, String mimeType, String displayname){

    }

    public static void dragImage(View view, Context context, File file, String mimeType) {
        dragImage(view, context, null, file, mimeType);
    }

    public static void dragImage(View view, Context context, Bitmap content, File file, String mimeType) {

    }

    public static void dragMultipleImage(View view, Context context, File[] files, String[] mimeTypes) {
    }



}