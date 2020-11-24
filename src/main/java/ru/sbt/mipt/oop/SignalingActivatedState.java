package ru.sbt.mipt.oop;

public class SignalingActivatedState implements SignalingState {
    private Signaling signalization;

    public SignalingActivatedState(Signaling alarm) {
        this.signalization = alarm;
    }

    @Override
    public void setActivated(int pin) {
        return;
    }

    @Override
    public void setDeactivated(int pin) {
        if (signalization.checkPassword(pin)){
            SignalingState deactivateSmartSignalingStatus = new SignalingDeactivatedState(signalization);
            signalization.changeState(deactivateSmartSignalingStatus);
        }
        else {
            this.AlarmOn();
        }
    }
    @Override
    public void AlarmOn() {
        System.out.println("Sending sms");
        SignalingState signalingSmartSignalingStatus = new SignalingActivatedState(signalization);
        signalization.changeState(signalingSmartSignalingStatus);
    }
}