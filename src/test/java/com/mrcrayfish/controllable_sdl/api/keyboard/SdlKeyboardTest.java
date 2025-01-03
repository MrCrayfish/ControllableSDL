package com.mrcrayfish.controllable_sdl.api.keyboard;

import com.mrcrayfish.controllable_sdl.api.Sdl;
import org.junit.jupiter.api.Test;

public final class SdlKeyboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlKeyboard.SDL_GetModState();
        Sdl.SDL_Quit();
    }
}
