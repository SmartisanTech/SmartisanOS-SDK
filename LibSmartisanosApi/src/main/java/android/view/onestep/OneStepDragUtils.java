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
package android.view.onestep;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import java.io.File;

/**
 * Helper Class for drag something when in oneStep mode.
 */
public class OneStepDragUtils {

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