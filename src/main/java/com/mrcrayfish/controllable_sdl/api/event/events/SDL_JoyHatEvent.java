package com.mrcrayfish.controllable_sdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.mrcrayfish.controllable_sdl.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

import static com.mrcrayfish.controllable_sdl.api.event.SDL_EventType.SDL_JOYHATMOTION;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_CENTERED;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_DOWN;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_LEFT;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_LEFTDOWN;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_LEFTUP;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_RIGHT;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_RIGHTDOWN;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_RIGHTUP;
import static com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst.SDL_HAT_UP;

/**
 * Joystick hat position change event structure (event.jhat.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "hat",
        "value",
        "padding1",
        "padding2"
})
public final class SDL_JoyHatEvent extends Structure {

    /** {@link com.mrcrayfish.controllable_sdl.api.event.SDL_EventType#SDL_JOYHATMOTION SDL_JOYHATMOTION} */
    @MagicConstant(intValues = SDL_JOYHATMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The joystick hat index */
    public byte hat;

    /**
     * The hat position value.
     *
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_LEFTUP
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_UP
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_RIGHTUP
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_LEFT
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_CENTERED
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_RIGHT
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_LEFTDOWN
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_DOWN
     * @see com.mrcrayfish.controllable_sdl.api.joystick.SdlJoystickConst#SDL_HAT_RIGHTDOWN
     *
     * <p>Note that zero means the POV is centered.</p>
     */
    @MagicConstant(intValues = {
            SDL_HAT_CENTERED,
            SDL_HAT_UP,
            SDL_HAT_RIGHT,
            SDL_HAT_DOWN,
            SDL_HAT_LEFT,
            SDL_HAT_RIGHTUP,
            SDL_HAT_RIGHTDOWN,
            SDL_HAT_LEFTUP,
            SDL_HAT_LEFTDOWN})
    public byte value;

    public byte padding1;
    public byte padding2;

    public SDL_JoyHatEvent() {
    }

    public SDL_JoyHatEvent(Pointer p) {
        super(p);
    }
}
