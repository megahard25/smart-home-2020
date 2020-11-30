package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class CommandAllLightOff implements CommandRC {
    private final SmartHome smartHome;

    public CommandAllLightOff(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle() {
        smartHome.execute(lightObj ->{
            if(!(lightObj instanceof Light)){
                return;
            }
            Light light = (Light) lightObj;
            light.setOn(false);
        });
    }
}