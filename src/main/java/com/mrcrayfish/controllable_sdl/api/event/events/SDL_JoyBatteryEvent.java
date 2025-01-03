package com.mrcrayfish.controllable_sdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.mrcrayfish.controllable_sdl.api.joystick.SDL_JoystickID;
import com.mrcrayfish.controllable_sdl.api.joystick.SDL_JoystickPowerLevel;
import org.intellij.lang.annotations.MagicConstant;

import static com.mrcrayfish.controllable_sdl.api.event.SDL_EventType.SDL_JOYBATTERYUPDATED;

/**
 * Joysick battery level change event structure (event.jbattery.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "level"
})
public final class SDL_JoyBatteryEvent extends Structure {

    /** {@link com.mrcrayfish.controllable_sdl.api.event.SDL_EventType#SDL_JOYBATTERYUPDATED SDL_JOYBATTERYUPDATED} */
    @MagicConstant(intValues = SDL_JOYBATTERYUPDATED)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The joystick battery level */
    @MagicConstant(valuesFromClass = SDL_JoystickPowerLevel.class)
    public int level;

    public SDL_JoyBatteryEvent() {
    }

    public SDL_JoyBatteryEvent(Pointer p) {
        super(p);
    }
}
