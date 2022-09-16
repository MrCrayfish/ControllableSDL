package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_CommonEvent extends Structure {

    public int type;
    public int timestamp;

    public SDL_CommonEvent() {
    }

    public SDL_CommonEvent(Pointer p) {
        super(p);
    }
}
