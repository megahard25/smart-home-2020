package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.SmartHome;

public class CommandSignalingOn implements CommandRC {
    private final SmartHome smartHome;

    public CommandSignalingOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle() {
        smartHome.getSignaling().getSignalizationState().setActivated(123);
    }
}