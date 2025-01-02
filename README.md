ControllableSDL
========
ControllableSDL is a fork of [libsdl4j](https://github.com/libsdl4j). Its purpose is purely for [Controllable](https://github.com/MrCrayfish/Controllable), a Minecraft mod that adds game controller support. It has been modernised to use the Gradle build system and use GitHub workflows for automated testing and building. In comparison to libsdl4j, ControllableSDL supplies embedded libraries for Windows, Linux, and MacOS and their popular architectures. ControllableSDL targets the latest released version of SDL2 (`2.30.10`), and unlike libsdl4j, will load embedded libraries first before falling back to searching the system for an SDL installations. This attempts to ensure we are loading `2.30.10` of SDL2, and not an older version.

While ControllableSDL essentially has full API support for SDL2, `video`, `audio`, and `render` modules have been disabled in releases as:
- Controllable only requires the modules needed for interfacing with game controllers.
- It reduces the file size of the natives.
  
If you need all modules, set `strip_modules` to `false` in `gradle.properties` and then run the `build.yml` workflow (you'll need to fork the project). Keep in mind that further optimisations may be added in the future, so use this fork at your own risk.

## License
See [LICENSE](https://github.com/MrCrayfish/controllable-sdl/blob/master/LICENSE)

