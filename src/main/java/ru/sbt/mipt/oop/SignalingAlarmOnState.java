package ru.sbt.mipt.oop;

public class SignalingAlarmOnState implements SignalingState {
    private final Signaling signalization;
    private String s = "alarm";

    SignalingAlarmOnState(Signaling alarm) {
        this.signalization = alarm;
    }

    @Override
    public void setActivated(int PIN) {
        System.out.println("LOCKED");
    }

    @Override
    public void setDeactivated(int PIN) {
        if (signalization.checkPassword(PIN)) {
            signalization.changeState(new SignalingDeactivatedState(signalization));
            System.out.println("DEACTIVATED");
        } else {
            System.out.println("INVALID PIN");
        }
    }

    @Override
    public void alarmOn() {
        System.out.println("ALREADY SWITCHED ON");
    }
}