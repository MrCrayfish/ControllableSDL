package io.github.libsdl4j.api.keyboard;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import io.github.libsdl4j.api.keycode.SDL_Keycode;
import io.github.libsdl4j.api.scancode.SDL_Scancode;

/**
 * The SDL keysym structure, used in key events.
 *
 * @apiNote If you are looking for translated character input, see the
 * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_TEXTINPUT} event.
 */
@Structure.FieldOrder({
        "scancode",
        "sym",
        "mod",
        "unused"
})
public final class SDL_Keysym extends Structure {

    /** SDL physical key code - see {@link SDL_Scancode} for details */
    @MagicConstant(valuesFromClass = SDL_Scancode.class)
    public int scancode;

    /** SDL virtual key code - see {@link SDL_Keycode} for details */
    @MagicConstant(valuesFromClass = SDL_Keycode.class)
    public int sym;

    /** current key modifiers */
    public short mod;

    public int unused;

    public SDL_Keysym() {
    }

    public SDL_Keysym(Pointer p) {
        super(p);
    }
}