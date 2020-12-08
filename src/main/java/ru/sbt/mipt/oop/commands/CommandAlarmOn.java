package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.SmartHome;

public class CommandAlarmOn implements CommandRC{
    private final SmartHome smartHome;

    public CommandAlarmOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle() {
        // smartHome.getSignaling().getSignalizationState().alarmOn();
        smartHome.signalizationON();
    }
}