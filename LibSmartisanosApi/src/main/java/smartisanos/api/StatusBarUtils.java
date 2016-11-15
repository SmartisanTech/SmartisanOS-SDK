package smartisanos.api;

import android.view.Window;

import smartisanos.util.StatusBarColorUtils;


public class StatusBarUtils {


    public static void setStatusBarColor(Window w, int color) {
        StatusBarColorUtils.setStatusBarColor(w, color);
    }

    public static void setLightStatusBar(Window w, boolean light) {
        StatusBarColorUtils.setLightStatusBar(w, light);
    }
}
