package ru.sbt.mipt.oop;

public enum SensorEventType {
    LIGHT_ON, LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED, ALARM_ACTIVATE, ALARM_DEACTIVATE;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (this == ALARM_ACTIVATE || this == ALARM_DEACTIVATE){
            this.code = code;
        }
    }
}