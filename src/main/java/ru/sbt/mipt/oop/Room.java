package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Objects;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(lights, room.lights) &&
                Objects.equals(doors, room.doors) &&
                Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lights, doors, name);
    }

    @Override
    public void execute(Event event) {
        event.accept(this);

        lights.forEach(light -> light.execute(event));
        doors.forEach(door -> door.execute(event));
    }

}
