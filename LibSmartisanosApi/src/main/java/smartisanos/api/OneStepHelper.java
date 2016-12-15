/**
 * Copyright (c) 2016, The Smartisan Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package smartisanos.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextDragPopupWindow;

import java.io.File;

import smartisanos.util.SidebarUtils;

/**
 * @author Smartisan
 * @version 1.0.1
 */
public final class OneStepHelper {

    private static OneStepHelper mInstance;
    private Context mContext;

    private OneStepHelper(Context context) {
        mContext = context.getApplicationContext();
        //ToDo:set the app whether can hold "OneStep" by itself.
    }

    public static synchronized OneStepHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new OneStepHelper(context);
        }
        return mInstance;
    }

    /**
     *  Whether in one step mode or not.
     *
     * @return {@code true} if in the onestep mode, or
     * {@code false} if it fails anywhere. Returning {@code false} means the system was not
     * in oneStep mode, can not drag anything.
     */
    public boolean isOneStepShowing() {
        try {
            return SidebarUtils.isSidebarShowing(mContext);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Long Press and Drag to share {@link java.lang.CharSequence} content text.
     * For example: Smartisan Notes App long press and share an Article.
     *
     * @param view The View object which you long press and drag.
     * @param text The content which you want to share. Can be {@link java.lang.String}
     * {@link android.text.SpannableString} or any other implementation class object.
     */
    public void dragText(View view, CharSequence text) {
        SidebarUtils.dragText(view , mContext, text);
    }

    /**
     * Long Press and Drag to share link. This Method will display a link icon when drag.
     * For example: Smartisan Browser App long press and share a link address.
     *
     * @param view The View object which you long press and drag.
     * @param link The content which you want to share. Can be {@link java.lang.String}
     * {@link android.text.SpannableString} or any other implementation class object.
     */
    public void dragLink(View view,  CharSequence link) {
        SidebarUtils.dragLink(view , mContext, link);
    }

    /**
     * Long Press and Drag to share {@link java.lang.CharSequence} content. You can set
     * the style of popup bubble,
     * For example: Smartisan Contacts App Long Press and share a contact.
     *
     * @param view The View object which you long press and drag.
     * @param text The content which you want to share. Can be {@link java.lang.String}
     * {@link android.text.SpannableString} or any other implementation class object.
     * @param background The bubble background bitmap. At the Bottom of Z-order.
     * Suggest Size: 96dp x 87dp
     * @param content The bubble content bitmap display. At the Middle of Z-order.
     * Suggest Size:66dp x 45dp
     * @param avatar The bubble avatar bitmap on the left(has a padding). At the Top of Z-order
     * Suggest Size: 26dp x 26dp
     *
     */
    public void dragText(View view,  CharSequence text, Bitmap background, Bitmap content, Bitmap avatar) {
        SidebarUtils.dragText(view , mContext, text, background, content, avatar);
    }

    /**
     * Long Press and Drag to share a File. We will add file icon for the drag bubble
     * by the file extension and mimetype.
     * For example: Smartisan FileManager App long press and share files.
     *
     * @param view The View object which you long press and drag.
     * @param file The File you want to share,
     * @param mimeType The mimeType of your file,
     * @param displayname The drag bubble display text.
     */
    public void dragFile(View view,  File file, String mimeType, String displayname){
        SidebarUtils.dragFile(view, mContext, file, mimeType, displayname);
    }

    /**
     * Long Press and Drag to share a File.You can set the style of popup bubble,
     *
     * @param view The View object which you long press and drag.
     * @param file The File you want to share,
     * @param mimeType The mimeType of your file,
     * @param background The bubble background bitmap. At the Bottom of Z-order.
     * Suggest Size: 96dp x 87dp
     * @param content The bubble content bitmap display. At the Middle of Z-order.
     * Suggest Size:66dp x 45dp
     * @param avatar The bubble avatar bitmap on the left(has a padding). At the Top of Z-order
     * Suggest Size: 26dp x 26dp
     */
    public void dragFile(View view,  File file, String mimeType, Bitmap background, Bitmap content, Bitmap avatar) {
        SidebarUtils.dragFile(view, mContext, file, mimeType, background, content, avatar);
    }

    /**
     * Long Press and Drag to share a image.
     *
     * @param view The View object which you long press and drag.
     * @param file The image file object.
     * @param mimeType The mimeType of image.
     */
    public void dragImage(View view,  File file, String mimeType) {
        SidebarUtils.dragImage(view, mContext, file, mimeType);
    }

    /**
     * Long Press and Drag to share a image. you can set the bitmap when drag.
     *
     * @param view The View object which you long press and drag.
     * @param content The drag bubble display bitmap.
     * @param file The image file object.
     * @param mimeType The mimeType of image.
     */
    public void dragImage(View view,  Bitmap content, File file, String mimeType) {
        SidebarUtils.dragImage(view, mContext, content, file, mimeType);
    }

    /**
     * Long Press and Drag to share multi images.
     *
     * @param view The View object which you long press and drag.
     * @param files The array of file you want to share.
     * @param mimeTypes The array of appropriate mimetype.
     */
    public void dragMultipleImages(View view,  File[] files, String[] mimeTypes) {
        SidebarUtils.dragMultipleImage(view,mContext,files, mimeTypes);
    }

    /**
     * Popup drag window to share text.
     *
     * For example: Smartisan Browser App long press and share an select text.
     *
     * @param view The View object which you press it
     * @param dragListener The listener will be callback when start to drag the windown.
     * @param content The content which you want to share.
     * @param x The x position which you to popup window.
     * @param y The y position which you to popup window.
     * @return TextDragPopupWindow
     */
    public TextDragPopupWindow showDragPopupText(View view, View.OnDragListener dragListener, String content, int x, int y) {
        TextDragPopupWindow textDragPopupWindow = new TextDragPopupWindow(view, dragListener);
        textDragPopupWindow.measureContent(content);
        textDragPopupWindow.show(x, y);
        return textDragPopupWindow;
    }
}
