package ru.sbt.mipt.oop;

public class SensorEvent {
    private final SensorEventType type;
    private String objectId;
    private int PIN;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        if (this.type == SensorEventType.SIGNALIZATION_ACTIVATED || this.type == SensorEventType.SIGNALIZATION_DEACTIVATED) {
            this.PIN = PIN;
        }
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
