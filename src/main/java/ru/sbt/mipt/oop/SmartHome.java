package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    private Signaling signalization;

    //public SmartHome() {
    //    rooms = new ArrayList<>();
    //    this.signalization = new Signaling();
    //}

    public SmartHome(Collection<Room> rooms, Signaling signalization) {
        this.rooms = rooms;
        this.signalization = signalization;
    }


    public void signalizationON(){
        signalization.signaling();
    };

    public void signalizationActivate(int PIN){
        signalization.activate(PIN);
    };


    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
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



    @Override
    public void execute(Event event) {
        signalization.execute(event);
        if (rooms != null) {
            rooms.forEach(room -> room.execute(event));
        }
        event.accept(this);
    }

}
