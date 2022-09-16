package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "window"
})
public class SDL_SysWMInfoWinRT extends Structure {

    /** The WinRT CoreWindow */
    public Pointer window;

    public SDL_SysWMInfoWinRT() {
    }

    public SDL_SysWMInfoWinRT(Pointer p) {
        super(p);
    }
}
