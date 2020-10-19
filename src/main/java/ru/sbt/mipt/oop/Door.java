package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class Door implements Actionable{
    private final String id;
    private boolean isOpen;

    public Door(String id, boolean isOpen) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void execute(Action action) {
        if (action == null) {
            return;
        }
        action.doAction(this);
    }

    public static String getType(){
        return "Door";
    }
}
