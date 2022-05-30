package org.libsdl.api.pixels;

import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "r",
        "g",
        "b",
        "a"
})
public class SDL_Color extends JnaStructure {

    public byte r;
    public byte g;
    public byte b;
    public byte a;

    public static class ByReference extends SDL_Color implements Structure.ByReference {
    }
}
