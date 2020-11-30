package ru.sbt.mipt.oop;

public class SignalingActivatedState implements SignalingState {
    private Signaling signalization;

    public SignalingActivatedState(Signaling alarm) {
        this.signalization = alarm;
    }

    @Override
    public void setActivated(int PIN) {
        System.out.println("Signaling already ACTIVATED");
    }

    @Override
    public void setDeactivated(int PIN) {
        if (signalization.checkPassword(PIN)){
            SignalingState deactivateSmartSignalingStatus = new SignalingDeactivatedState(signalization);
            signalization.changeState(deactivateSmartSignalingStatus);
            System.out.println("Signaling DEACTIVATED");
        }
        else {
            this.alarmOn();
        }
    }
    @Override
    public void alarmOn() {
        //System.out.println("Sending sms");
        SignalingState signalingSmartSignalingStatus = new SignalingActivatedState(signalization);
        signalization.changeState(signalingSmartSignalingStatus);
    }
}