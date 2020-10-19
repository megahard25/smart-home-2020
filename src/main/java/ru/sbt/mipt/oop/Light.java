package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class Light implements Actionable{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
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
    public void execute(Action action) {
        if (action == null) return;
        action.doAction(this);
    }

    public static String getType(){
        return "Light";
    }
}
