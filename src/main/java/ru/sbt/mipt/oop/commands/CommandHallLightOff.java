package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CommandHallLightOff implements CommandRC {
    private final SmartHome smartHome;

    public CommandHallLightOff(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle() {
        smartHome.execute(roomObj ->{
            if(!(roomObj instanceof Room)){ return; }
            Room room = (Room)roomObj;
            if(!(room.getName().equals("hall"))){ return; }
            room.execute(lightObj ->{
                if(!(lightObj instanceof Light)){ return; }
                Light door = (Light) lightObj;
                door.setOn(false);
            });
        });
    }
}