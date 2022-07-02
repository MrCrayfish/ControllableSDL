package org.libsdl.api.timer;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * <p>It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 * <p>If you didn't keep the reference you'd encounter an error like this:<br>
 * <code>JNA: callback object has been garbage collected</code>
 * </p>
 */
@FunctionalInterface
public interface SDL_TimerCallback extends Callback {

    /**
     * Function prototype for the timer callback function.
     *
     * The callback function is passed the current timer interval and returns
     * the next timer interval. If the returned value is the same as the one
     * passed in, the periodic alarm continues, otherwise a new alarm is
     * scheduled. If the callback returns 0, the periodic alarm is cancelled.
     */
    int callback(int interval, Pointer param);
}
