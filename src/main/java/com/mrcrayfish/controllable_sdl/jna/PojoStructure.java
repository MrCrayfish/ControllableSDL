package com.mrcrayfish.controllable_sdl.jna;

import com.sun.jna.Pointer;

public interface PojoStructure {

    long size();

    void write(Pointer buffer, long offset);
}
