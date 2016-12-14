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
     * @return the height of text.
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
