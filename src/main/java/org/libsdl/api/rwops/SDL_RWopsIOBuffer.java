package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;
import org.libsdl.jna.size_t;

@Structure.FieldOrder({
        "data",
        "size",
        "left"
})
public final class SDL_RWopsIOBuffer extends JnaStructure {

    public Pointer data;
    public size_t size;
    public size_t left;

    public SDL_RWopsIOBuffer() {
    }

    public SDL_RWopsIOBuffer(Pointer p) {
        super(p);
    }
}
