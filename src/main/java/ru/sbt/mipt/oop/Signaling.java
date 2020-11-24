package ru.sbt.mipt.oop;

public class Signaling {
    private SignalingState signalizationState;
    final int pin;

    public Signaling(int PIN) {
        signalizationState = new SignalingDeactivatedState(this);
        this.pin = PIN;
    }

    public SignalingState getSignalizationState() {
        return signalizationState;
    }

    public void changeState(SignalingState signalizationState){
        this.signalizationState = signalizationState;
    }

    private int getCode() {
        return pin;
    }

    public boolean checkPassword(int password){
        return password==this.pin;
    }

    public void activate(int pin){
        signalizationState.setActivated(pin);
    }

    public void deactivate(int pin){
        signalizationState.setDeactivated(pin);
    }

    public void signaling(){
        signalizationState.AlarmOn();
    }
}
