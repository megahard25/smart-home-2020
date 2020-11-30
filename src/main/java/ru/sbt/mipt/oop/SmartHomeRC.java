package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.commands.CommandRC;

import java.util.Map;
import java.util.Objects;

public class SmartHomeRC implements RemoteControl {
    private final String id;
    private final Map<String, CommandRC> buttons;

    public SmartHomeRC(String id, Map<String, CommandRC> buttons) {
        this.id = id;
        this.buttons = buttons;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (Objects.equals(id, rcId) && buttons.containsKey(buttonCode)) {
            buttons.get(buttonCode).handle();
        }
    }
}