package com.mrcrayfish.controllable_sdl.api.filesystem;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_Init;
import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_Quit;
import static com.mrcrayfish.controllable_sdl.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static com.mrcrayfish.controllable_sdl.api.filesystem.SdlFilesystem.SDL_GetBasePath;
import static com.mrcrayfish.controllable_sdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SdlFilesystemTest {

    @BeforeEach
    public void setUp() {
        SDL_Init(SDL_INIT_VIDEO);
    }

    @Test
    public void basePathShouldBeValid() {
        int allocCountBefore = SDL_GetNumAllocations();

        Path actualBasePath = Paths.get(SDL_GetBasePath());
        Path expectedBasePath = Paths.get(System.getProperty("java.home"), "bin");
        // If the JDK has a JRE folder, it will return that instead. SDL_GetBasePath gets the JDK bin, not JRE bin.
        String jreBinPath = "jre" + System.getProperty("file.separator") + "bin";
        if(expectedBasePath.toAbsolutePath().toString().endsWith(jreBinPath)) {
            expectedBasePath = expectedBasePath.getParent().getParent().resolve("bin");
        }
        assertEquals(expectedBasePath, actualBasePath);

        int allocCountAfter = SDL_GetNumAllocations();
        System.out.println(allocCountAfter);
        assertEquals(allocCountBefore, allocCountAfter);
    }

    @AfterEach
    public void tearDown() {
        SDL_Quit();
    }
}
