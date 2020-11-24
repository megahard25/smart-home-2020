package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class SmartHome {
    ArrayList<Room> rooms;
    private final int PIN;
    private Signaling signalization;

    public SmartHome(ArrayList<Room> rooms, int PIN) {
        this.rooms = rooms;
        this.PIN = PIN;
    }

    public Signaling getSignaling() {
        return signalization;
    }

    public void formSignalizationObj() {
        signalization = new Signaling(PIN);
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void handleEvent(Action action) {
        action.accept(this);
        rooms.forEach(room -> room.execute(action));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartHome smartHome = (SmartHome) o;
        return Objects.equals(rooms, smartHome.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms);
    }

}
