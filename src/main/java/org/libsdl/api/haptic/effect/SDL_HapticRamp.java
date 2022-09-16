package org.libsdl.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.haptic.SDL_HapticDirection;

import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_RAMP;
import static org.libsdl.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "start",
        "end",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticRamp extends Structure {

    @MagicConstant(intValues = SDL_HAPTIC_RAMP)
    public short type;
    public SDL_HapticDirection direction;

    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
    public int length;
    public short delay;
    public short button;
    public short interval;
    public short start;
    public short end;
    public short attackLength;
    public short attackLevel;
    public short fadeLength;
    public short fadeLevel;

    public SDL_HapticRamp() {
    }

    public SDL_HapticRamp(Pointer p) {
        super(p);
    }
}
