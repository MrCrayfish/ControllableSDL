package com.mrcrayfish.controllable_sdl.api.clipboard;

import com.mrcrayfish.controllable_sdl.api.Sdl;
import org.junit.jupiter.api.Test;

public final class SdlClipboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlClipboard.SDL_HasClipboardText();
        Sdl.SDL_Quit();
    }
}
