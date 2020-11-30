package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CommandHallClose implements CommandRC {
    private final SmartHome smartHome;

    public CommandHallClose(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle() {
        smartHome.execute(roomObj ->{
            if(!(roomObj instanceof Room)){ return; }
            Room room = (Room)roomObj;
            if(!(room.getName().equals("hall"))){ return; }
            room.execute(doorObj ->{
                if(!(doorObj instanceof Door)){ return; }
                Door door = (Door) doorObj;
                door.setOpen(false);
            });
        });
    }
}