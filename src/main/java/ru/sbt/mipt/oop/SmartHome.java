package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private final Collection<Room> rooms = new ArrayList<>();
    private final Alarm alarm;

    public SmartHome(Collection<Room> rooms, Alarm alarm) {
        if (alarm == null) {
            throw new IllegalArgumentException();
        }
        if (rooms == null) {
            throw new IllegalArgumentException();
        }
        this.rooms.addAll(rooms);
        this.alarm = alarm;
    }

    public void execute(Action action) {
        if (action == null) {
            return;
        }
        action.doAction( this);
        alarm.execute(action);
        for (Room room : rooms){
            room.execute(action);
        }
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Alarm getAlarm() {
        return alarm;
    }
}
