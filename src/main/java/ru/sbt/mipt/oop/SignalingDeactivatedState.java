package ru.sbt.mipt.oop;

public class SignalingDeactivatedState implements SignalingState {
    private final Signaling signalization;
    private String s = "deactivated";

    SignalingDeactivatedState(Signaling alarm) {
        this.signalization = alarm;
    }

    @Override
    public void setActivated(int PIN) {
        if (PIN == signalization.pin) {
            signalization.changeState(new SignalingActivatedState(signalization));
            System.out.println("ACTIVATED");
        } else {
            System.out.println("INVALID PIN");
        }
    }

    @Override
    public void setDeactivated(int PIN) {
        System.out.println("ALREADY DEACTIVATED");
    }

    @Override
    public void AlarmOn() {
        System.out.println("LOCKED");
    }
}
