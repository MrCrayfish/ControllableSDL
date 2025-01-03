package com.mrcrayfish.controllable_sdl.api.timer;

import java.util.concurrent.atomic.AtomicInteger;
import com.sun.jna.Pointer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_InitSubSystem;
import static com.mrcrayfish.controllable_sdl.api.Sdl.SDL_QuitSubSystem;
import static com.mrcrayfish.controllable_sdl.api.SdlSubSystemConst.SDL_INIT_TIMER;
import static com.mrcrayfish.controllable_sdl.api.SdlTest.assertNoMemoryLeak;
import static com.mrcrayfish.controllable_sdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static com.mrcrayfish.controllable_sdl.api.timer.SdlTimer.SDL_AddTimer;
import static com.mrcrayfish.controllable_sdl.api.timer.SdlTimer.SDL_GetTicks;
import static com.mrcrayfish.controllable_sdl.api.timer.SdlTimer.SDL_RemoveTimer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimerTest {

    private int numOfAllocationsBefore;

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_TIMER);
        numOfAllocationsBefore = SDL_GetNumAllocations();
    }

    @Test
    public void getTicksShouldReportTimeInMilliseconds() throws InterruptedException {
        int time1 = SDL_GetTicks();
        Thread.sleep(2500L);
        int time2 = SDL_GetTicks();
        assertTrue(time1 + 2450L <= time2);
        assertTrue(time1 + 10_000L > time2);
        assertNoMemoryLeak(numOfAllocationsBefore);
    }

    @Test
    public void timerShouldTriggerCallback() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        SDL_TimerCallback callbackHolder = (interval, param) -> {
            counter.incrementAndGet();
            return interval;
        };
        SDL_TimerID timerID = SDL_AddTimer(1000, callbackHolder, Pointer.NULL);
        SDL_TimerID timerID2 = SDL_AddTimer(1000, callbackHolder, Pointer.NULL);
        Thread.sleep(3500L);

        boolean result = SDL_RemoveTimer(timerID);
        assertTrue(result);
        boolean result2 = SDL_RemoveTimer(timerID2);
        assertTrue(result2);
        Thread.sleep(2000L);

        assertEquals(6, counter.get());
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_TIMER);
    }
}
