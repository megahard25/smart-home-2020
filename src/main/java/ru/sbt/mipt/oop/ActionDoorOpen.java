package ru.sbt.mipt.oop;

public class ActionDoorOpen implements Action {
    private final String deviceId;

    public ActionDoorOpen(String deviceId) {
        if (deviceId == null) {
            throw new IllegalArgumentException();
        }
        this.deviceId = deviceId;
    }

    @Override
    public void doAction(Actionable smartDevice) {
        if (!(smartDevice instanceof Door)) {
            throw new IllegalArgumentException();
        }
        Door door = (Door) smartDevice;
        door.setOpen(true);
        System.out.println("Door " + door.getId() + " was opened");
    }
}
