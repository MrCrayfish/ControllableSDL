package com.mrcrayfish.controllable_sdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.mrcrayfish.controllable_sdl.jna.size_t;

@Structure.FieldOrder({
        "data",
        "size",
        "left"
})
public final class SDL_RWopsIOBuffer extends Structure {

    public Pointer data;
    public size_t size;
    public size_t left;

    public SDL_RWopsIOBuffer() {
    }

    public SDL_RWopsIOBuffer(Pointer p) {
        super(p);
    }
}
