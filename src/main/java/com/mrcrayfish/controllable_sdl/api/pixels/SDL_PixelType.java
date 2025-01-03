package com.mrcrayfish.controllable_sdl.api.pixels;

import com.mrcrayfish.controllable_sdl.jna.JnaEnum;

public final class SDL_PixelType implements JnaEnum {

    public static final int SDL_PIXELTYPE_UNKNOWN = 0;
    public static final int SDL_PIXELTYPE_INDEX1 = 1;
    public static final int SDL_PIXELTYPE_INDEX4 = 2;
    public static final int SDL_PIXELTYPE_INDEX8 = 3;
    public static final int SDL_PIXELTYPE_PACKED8 = 4;
    public static final int SDL_PIXELTYPE_PACKED16 = 5;
    public static final int SDL_PIXELTYPE_PACKED32 = 6;
    public static final int SDL_PIXELTYPE_ARRAYU8 = 7;
    public static final int SDL_PIXELTYPE_ARRAYU16 = 8;
    public static final int SDL_PIXELTYPE_ARRAYU32 = 9;
    public static final int SDL_PIXELTYPE_ARRAYF16 = 10;
    public static final int SDL_PIXELTYPE_ARRAYF32 = 11;
    public static final int SDL_PIXELTYPE_INDEX2 = 12;

    // TODO: Generate public static String toString(int value)

    private SDL_PixelType() {
    }
}
