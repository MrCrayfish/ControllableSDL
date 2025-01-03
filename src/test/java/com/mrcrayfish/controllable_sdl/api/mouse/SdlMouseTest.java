package com.mrcrayfish.controllable_sdl.api.mouse;

import org.junit.jupiter.api.Test;

import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_Init;
import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_Quit;
import static com.mrcrayfish.controllable_sdl.api.mouse.SdlMouse.SDL_GetCursor;

public final class SdlMouseTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_GetCursor();
        SDL_Quit();
    }
}
