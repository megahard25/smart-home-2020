package ru.sbt.mipt.oop;

import java.util.Objects;

public class Light implements Actionable{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Light light = (Light) o;
        return isOn == light.isOn &&
                Objects.equals(id, light.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOn, id);
    }

    @Override
    public void execute(Event event) {
        event.accept(this);
    }
}
