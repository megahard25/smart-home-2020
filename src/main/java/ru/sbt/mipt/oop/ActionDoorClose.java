package ru.sbt.mipt.oop;

public class ActionDoorClose implements Action {
    private final String deviceId;

    public ActionDoorClose(String deviceId) {
        if (deviceId == null) {
            throw new IllegalArgumentException();
        }
        this.deviceId = deviceId;
    }

    @Override
    public void doAction(Actionable device) {
        if (!(device instanceof Door)) {
            throw new IllegalArgumentException();
        }
        Door door = (Door) device;
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " was closed");
    }
}
