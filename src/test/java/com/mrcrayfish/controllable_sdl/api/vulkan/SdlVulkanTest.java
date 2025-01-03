package com.mrcrayfish.controllable_sdl.api.vulkan;

import java.util.List;
import com.mrcrayfish.controllable_sdl.api.video.SDL_Window;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_InitSubSystem;
import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_QuitSubSystem;
import static com.mrcrayfish.controllable_sdl.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static com.mrcrayfish.controllable_sdl.api.error.SdlError.SDL_GetError;
import static com.mrcrayfish.controllable_sdl.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static com.mrcrayfish.controllable_sdl.api.video.SDL_WindowFlags.SDL_WINDOW_VULKAN;
import static com.mrcrayfish.controllable_sdl.api.video.SdlVideo.SDL_CreateWindow;
import static com.mrcrayfish.controllable_sdl.api.vulkan.SdlVulkan.SDL_Vulkan_GetInstanceExtensions;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SdlVulkanTest {

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_VIDEO);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    public void getVulkanInfo() throws InterruptedException {
        SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_VULKAN | SDL_WINDOW_SHOWN);
        if (window == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }

        List<String> extensions = SDL_Vulkan_GetInstanceExtensions(window);
        System.out.println("Vulkan extensions: " + extensions);
        assertNotNull(extensions, () -> "SDL Failure: " + SDL_GetError());
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_VIDEO);
    }
}
