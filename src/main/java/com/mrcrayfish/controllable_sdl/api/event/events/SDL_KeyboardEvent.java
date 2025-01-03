package com.mrcrayfish.controllable_sdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.mrcrayfish.controllable_sdl.api.keyboard.SDL_Keysym;
import org.intellij.lang.annotations.MagicConstant;

import static com.mrcrayfish.controllable_sdl.api.event.SDL_EventType.SDL_KEYDOWN;
import static com.mrcrayfish.controllable_sdl.api.event.SDL_EventType.SDL_KEYUP;
import static com.mrcrayfish.controllable_sdl.api.event.SdlEventsConst.SDL_PRESSED;
import static com.mrcrayfish.controllable_sdl.api.event.SdlEventsConst.SDL_RELEASED;

/**
 * Keyboard button event structure (event.key.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "state",
        "repeat",
        "padding2",
        "padding3",
        "keysym"
})
public final class SDL_KeyboardEvent extends Structure {

    /**
     * {@link com.mrcrayfish.controllable_sdl.api.event.SDL_EventType#SDL_KEYDOWN SDL_KEYDOWN}
     * or {@link com.mrcrayfish.controllable_sdl.api.event.SDL_EventType#SDL_KEYUP SDL_KEYUP}
     */
    @MagicConstant(intValues = {SDL_KEYDOWN, SDL_KEYUP})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with keyboard focus, if any */
    public int windowID;

    /**
     * {@link com.mrcrayfish.controllable_sdl.api.event.SdlEventsConst#SDL_PRESSED SDL_PRESSED}
     * or {@link com.mrcrayfish.controllable_sdl.api.event.SdlEventsConst#SDL_RELEASED SDL_RELEASED}
     */
    @MagicConstant(intValues = {SDL_PRESSED, SDL_RELEASED})
    public byte state;

    /** Non-zero if this is a key repeat */
    public byte repeat;

    public byte padding2;
    public byte padding3;

    /** The key that was pressed or released */
    public SDL_Keysym keysym;

    public SDL_KeyboardEvent() {
    }

    public SDL_KeyboardEvent(Pointer p) {
        super(p);
    }
}
