package ru.sbt.mipt.oop;

public interface SignalingState {

    void setActivated(int PIN);

    void setDeactivated(int PIN);

    void alarmOn();
}
