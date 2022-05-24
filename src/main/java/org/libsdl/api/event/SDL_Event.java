package org.libsdl.api.event;

import com.sun.jna.Union;
import org.libsdl.api.event.events.SDL_AudioDeviceEvent;
import org.libsdl.api.event.events.SDL_CommonEvent;
import org.libsdl.api.event.events.SDL_ControllerAxisEvent;
import org.libsdl.api.event.events.SDL_ControllerButtonEvent;
import org.libsdl.api.event.events.SDL_ControllerDeviceEvent;
import org.libsdl.api.event.events.SDL_DollarGestureEvent;
import org.libsdl.api.event.events.SDL_DropEvent;
import org.libsdl.api.event.events.SDL_JoyAxisEvent;
import org.libsdl.api.event.events.SDL_JoyBallEvent;
import org.libsdl.api.event.events.SDL_JoyButtonEvent;
import org.libsdl.api.event.events.SDL_JoyDeviceEvent;
import org.libsdl.api.event.events.SDL_JoyHatEvent;
import org.libsdl.api.event.events.SDL_KeyboardEvent;
import org.libsdl.api.event.events.SDL_MouseButtonEvent;
import org.libsdl.api.event.events.SDL_MouseMotionEvent;
import org.libsdl.api.event.events.SDL_MouseWheelEvent;
import org.libsdl.api.event.events.SDL_MultiGestureEvent;
import org.libsdl.api.event.events.SDL_QuitEvent;
import org.libsdl.api.event.events.SDL_SysWMEvent;
import org.libsdl.api.event.events.SDL_TextEditingEvent;
import org.libsdl.api.event.events.SDL_TextInputEvent;
import org.libsdl.api.event.events.SDL_TouchFingerEvent;
import org.libsdl.api.event.events.SDL_UserEvent;
import org.libsdl.api.event.events.SDL_WindowEvent;

import static org.libsdl.api.event.SDL_EventType.SDL_AUDIODEVICEADDED;
import static org.libsdl.api.event.SDL_EventType.SDL_AUDIODEVICEREMOVED;
import static org.libsdl.api.event.SDL_EventType.SDL_CLIPBOARDUPDATE;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERAXISMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERBUTTONDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERBUTTONUP;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERDEVICEADDED;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERDEVICEREMAPPED;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERDEVICEREMOVED;
import static org.libsdl.api.event.SDL_EventType.SDL_DOLLARGESTURE;
import static org.libsdl.api.event.SDL_EventType.SDL_DOLLARRECORD;
import static org.libsdl.api.event.SDL_EventType.SDL_DROPBEGIN;
import static org.libsdl.api.event.SDL_EventType.SDL_DROPCOMPLETE;
import static org.libsdl.api.event.SDL_EventType.SDL_DROPFILE;
import static org.libsdl.api.event.SDL_EventType.SDL_DROPTEXT;
import static org.libsdl.api.event.SDL_EventType.SDL_FINGERDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_FINGERMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_FINGERUP;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYAXISMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYBALLMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYBUTTONDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYBUTTONUP;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYDEVICEADDED;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYHATMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_KEYDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_KEYUP;
import static org.libsdl.api.event.SDL_EventType.SDL_LASTEVENT;
import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEBUTTONDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEBUTTONUP;
import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEWHEEL;
import static org.libsdl.api.event.SDL_EventType.SDL_MULTIGESTURE;
import static org.libsdl.api.event.SDL_EventType.SDL_QUIT;
import static org.libsdl.api.event.SDL_EventType.SDL_RENDER_DEVICE_RESET;
import static org.libsdl.api.event.SDL_EventType.SDL_RENDER_TARGETS_RESET;
import static org.libsdl.api.event.SDL_EventType.SDL_SYSWMEVENT;
import static org.libsdl.api.event.SDL_EventType.SDL_TEXTEDITING;
import static org.libsdl.api.event.SDL_EventType.SDL_TEXTINPUT;
import static org.libsdl.api.event.SDL_EventType.SDL_USEREVENT;
import static org.libsdl.api.event.SDL_EventType.SDL_WINDOWEVENT;

/**
 * This class is a union of all event info objects from SDL.
 * You can pass an empty instance to methods such as {@link SdlEvents#SDL_PollEvent(SDL_Event)}
 * and have it populated with event info.
 *
 * Although it is as close a mapping of a C union as possible, Java does not really support that kind of thing.
 * Therefore, unlike in C where you can read from any union member and have a view to the raw data,
 * in JNA union, it must be selected which union member is the active field.
 * When the object is populated in a native method, it is done automatically (by {@link #read()})
 * If you populate the object in Java, always remember to select the active member field
 * using {@link #setType(Class)}.
 */
@SuppressWarnings({"checkstyle:classfanoutcomplexity", "checkstyle:cyclomaticcomplexity", "checkstyle:avoidstaticimport"})
public final class SDL_Event extends Union {

    public int type;
    public SDL_CommonEvent common;
    public SDL_WindowEvent window;
    public SDL_KeyboardEvent key;
    public SDL_TextEditingEvent edit;
    public SDL_TextInputEvent text;
    public SDL_MouseMotionEvent motion;
    public SDL_MouseButtonEvent button;
    public SDL_MouseWheelEvent wheel;
    public SDL_JoyAxisEvent jaxis;
    public SDL_JoyBallEvent jball;
    public SDL_JoyHatEvent jhat;
    public SDL_JoyButtonEvent jbutton;
    public SDL_JoyDeviceEvent jdevice;
    public SDL_ControllerAxisEvent caxis;
    public SDL_ControllerButtonEvent cbutton;
    public SDL_ControllerDeviceEvent cdevice;
    public SDL_AudioDeviceEvent adevice;
    public SDL_QuitEvent quit;
    public SDL_UserEvent user;
    public SDL_SysWMEvent syswm;
    public SDL_TouchFingerEvent tfinger;
    public SDL_MultiGestureEvent mgesture;
    public SDL_DollarGestureEvent dgesture;
    public SDL_DropEvent drop;

    @SuppressWarnings({"checkstyle:javancss", "checkstyle:requirethis"})
    @Override
    public void read() {
        type = (Integer) readField("type");
        switch (type) {
            case SDL_QUIT:
                setType(SDL_QuitEvent.class);
                break;
            case SDL_WINDOWEVENT:
                setType(SDL_WindowEvent.class);
                break;
            case SDL_SYSWMEVENT:
                setType(SDL_SysWMEvent.class);
                break;
            case SDL_KEYDOWN:
            case SDL_KEYUP:
                setType(SDL_KeyboardEvent.class);
                break;
            case SDL_TEXTEDITING:
                setType(SDL_TextEditingEvent.class);
                break;
            case SDL_TEXTINPUT:
                setType(SDL_TextInputEvent.class);
                break;
            case SDL_MOUSEMOTION:
                setType(SDL_MouseMotionEvent.class);
                break;
            case SDL_MOUSEBUTTONDOWN:
            case SDL_MOUSEBUTTONUP:
                setType(SDL_MouseButtonEvent.class);
                break;
            case SDL_MOUSEWHEEL:
                setType(SDL_MouseWheelEvent.class);
                break;
            case SDL_JOYAXISMOTION:
                setType(SDL_JoyAxisEvent.class);
                break;
            case SDL_JOYBALLMOTION:
                setType(SDL_JoyBallEvent.class);
                break;
            case SDL_JOYHATMOTION:
                setType(SDL_JoyHatEvent.class);
                break;
            case SDL_JOYBUTTONDOWN:
            case SDL_JOYBUTTONUP:
                setType(SDL_JoyButtonEvent.class);
                break;
            case SDL_JOYDEVICEADDED:
                setType(SDL_JoyDeviceEvent.class);
                break;
            case SDL_CONTROLLERAXISMOTION:
                setType(SDL_ControllerAxisEvent.class);
                break;
            case SDL_CONTROLLERBUTTONDOWN:
            case SDL_CONTROLLERBUTTONUP:
                setType(SDL_ControllerButtonEvent.class);
                break;
            case SDL_CONTROLLERDEVICEADDED:
            case SDL_CONTROLLERDEVICEREMOVED:
            case SDL_CONTROLLERDEVICEREMAPPED:
                setType(SDL_ControllerDeviceEvent.class);
                break;
            case SDL_FINGERMOTION:
            case SDL_FINGERDOWN:
            case SDL_FINGERUP:
                setType(SDL_TouchFingerEvent.class);
                break;
            case SDL_DOLLARGESTURE:
            case SDL_DOLLARRECORD:
                setType(SDL_DollarGestureEvent.class);
                break;
            case SDL_MULTIGESTURE:
                setType(SDL_MultiGestureEvent.class);
                break;
            case SDL_CLIPBOARDUPDATE:
                setType(SDL_CommonEvent.class);
                break;
            case SDL_DROPBEGIN:
            case SDL_DROPFILE:
            case SDL_DROPTEXT:
            case SDL_DROPCOMPLETE:
                setType(SDL_DropEvent.class);
                break;
            case SDL_AUDIODEVICEADDED:
            case SDL_AUDIODEVICEREMOVED:
                setType(SDL_AudioDeviceEvent.class);
                break;
            case SDL_RENDER_TARGETS_RESET:
            case SDL_RENDER_DEVICE_RESET:
                setType(SDL_CommonEvent.class);
                break;
            default:
                if (type >= SDL_USEREVENT && type < SDL_LASTEVENT) {
                    setType(SDL_UserEvent.class);
                } else {
                    setType(SDL_CommonEvent.class);
                }
                break;
        }
        super.read();
    }
}
