package com.mrcrayfish.controllable_sdl.api.haptic;

import com.mrcrayfish.controllable_sdl.api.Sdl;
import org.junit.jupiter.api.Test;

public class SdlHapticTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlHaptic.SDL_MouseIsHaptic();
        Sdl.SDL_Quit();
    }
}
