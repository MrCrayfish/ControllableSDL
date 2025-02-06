package com.mrcrayfish.controllable_sdl.jna;

import com.mrcrayfish.controllable_sdl.api.version.SdlVersionConst;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static com.sun.jna.Library.OPTION_CLASSLOADER;
import static com.sun.jna.Library.OPTION_STRING_ENCODING;

public final class SdlNativeLibraryLoader {

    private static final Logger LOGGER = Logger.getLogger(SdlNativeLibraryLoader.class.getName());
    public static final String SDL_LIBRARY_NAME = "SDL2";

    // This field keeps the reference to the loaded JNA library object to prevent it from being garbage collected.
    private static NativeLibrary sdl2Library;
    private static Path extractionPath;

    private SdlNativeLibraryLoader() {
    }

    public static void setExtractionPath(Path path) {
        extractionPath = path;
    }

    private static Path getExtractionPath() {
        Path nativesPath;
        if(extractionPath != null) {
            nativesPath = extractionPath;
        } else {
            Path tempPath = Path.of(System.getProperty("java.io.tmpdir"));
            nativesPath = tempPath.resolve("ControllableSDL");
        }
        String version = String.join(".",
            Integer.toString(SdlVersionConst.SDL_MAJOR_VERSION),
            Integer.toString(SdlVersionConst.SDL_MINOR_VERSION),
            Integer.toString(SdlVersionConst.SDL_PATCHLEVEL)
        );
        Path libraryPath = nativesPath.resolve(version);
        if(Files.notExists(libraryPath)) {
            try {
                Files.createDirectories(libraryPath);
            } catch(IOException e) {
                throw new RuntimeException("Failed to create directories", e);
            }
        }
        return libraryPath;
    }

    public static synchronized void registerNativeMethods(Class<?> nativeClass) {
        loadSDL2NativeFromEmbeddedResources();
        Native.register(nativeClass, sdl2Library);
    }

    private static Map<String, Object> createOptions() {
        Map<String, Object> options = new HashMap<>();
        options.put(OPTION_STRING_ENCODING, "UTF-8");
        options.put(OPTION_CLASSLOADER, SdlNativeLibraryLoader.class.getClassLoader());
        return options;
    }

    public static synchronized <T extends Library> T loadSDL2InterfaceInstance(Class<T> libraryInterface) {
        loadSDL2NativeFromEmbeddedResources();
        return Native.load(SDL_LIBRARY_NAME, libraryInterface, createOptions());
    }

    private static void loadSDL2NativeFromEmbeddedResources() {
        if(sdl2Library != null)
            return;
        String libraryName = System.mapLibraryName(SDL_LIBRARY_NAME);
        Path libraryPath = getExtractionPath();
        Path libraryFile = libraryPath.resolve(libraryName);
        if(Files.notExists(libraryFile)) {
            extractPlatformSDL2NativeTo(libraryFile);
        }
        NativeLibrary.addSearchPath(SDL_LIBRARY_NAME, libraryPath.toString());
        sdl2Library = NativeLibrary.getInstance(SDL_LIBRARY_NAME, createOptions());
    }

    private static void extractPlatformSDL2NativeTo(Path outputFile)
    {
        String path = Platform.RESOURCE_PREFIX + "/" + System.mapLibraryName(SDL_LIBRARY_NAME);
        try(InputStream is = SdlNativeLibraryLoader.class.getClassLoader().getResourceAsStream(path)) {
            if(is != null) {
                Files.copy(is, outputFile, StandardCopyOption.REPLACE_EXISTING);
            } else {
                throw new RuntimeException("Unsupported platform: " + Platform.RESOURCE_PREFIX);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
