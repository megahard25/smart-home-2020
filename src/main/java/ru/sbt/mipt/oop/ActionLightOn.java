package ru.sbt.mipt.oop;

public class ActionLightOn implements Action{
    private final String deviceId;

    public ActionLightOn(String deviceId) {
        if (deviceId == null) {
            throw new IllegalArgumentException();
        }
        this.deviceId = deviceId;
    }

    @Override
    public void doAction(Actionable smartDevice) {
        if (!(smartDevice instanceof Light)) {
            throw new IllegalArgumentException();
        }
        Light light = (Light) smartDevice;
        light.setOn(false);
        System.out.println("Light " + light.getId() + " off");
    }
}
