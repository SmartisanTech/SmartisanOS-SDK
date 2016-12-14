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

/**
 * The interface that apps use to talk to the one step manager.
 * <p>
 * Use <code>Context.getSystemService(Context.ONE_STEP_SERVICE)</code> to get one of these.
 *
 * @see android.content.Context#getSystemService
 */
public interface OneStepManager {

    /**
     *  Whether in one step mode or not.
     *
     * @return {@code true} if in the onestep mode, or
     * {@code false} if it fails anywhere. Returning {@code false} means the system was not
     * in oneStep mode, can not drag anything.
     */
    public boolean isInOneStepMode();


}
