package ru.sbt.mipt.oop;

public class SignalingDeactivatedState implements SignalingState {
    private final Signaling signalization;
    private String s = "deactivated";

    SignalingDeactivatedState(Signaling alarm) {
        this.signalization = alarm;
    }

    @Override
    public void setActivated(int PIN) {
        signalization.changeState(new SignalingActivatedState(signalization));
        signalization.setCode(PIN);
        System.out.println("Signaling ACTIVATED");
    }

    @Override
    public void setDeactivated(int PIN) {
        System.out.println("Signaling already DEACTIVATED");
    }

    @Override
    public void alarmOn() {
        System.out.println("Signaling ALARMED");
    }
}
