package android.widget;

import android.view.View;
/**
 * @author Smartisan
 * @version 1.0.0
 */
public class TextDragPopupWindow {

    /**
     * Constructor to use when create drag popup window from code.
     *
     * @param parent The View object which you press it
     * @param dragListener The listener will be callback when start to drag the windown.
     */
    public TextDragPopupWindow(View parent, View.OnDragListener dragListener) {

    }

    /**
     * Measure the drag popup window.
     *
     * @param text The content which you want to share.
     *
     * @return
     */
    public int measureContent(String text) {
        return -1;
    }

    /**
     * @param x The position x which you to popup window.
     * @param y The position y which you to popup window.
     */
    public void show(int x, int y) {

    }

    /**
     * Hide the drag popup window.
     */
    public void hide() {

    }
}
