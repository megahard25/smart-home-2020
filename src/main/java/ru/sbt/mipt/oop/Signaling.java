package ru.sbt.mipt.oop;

public class Signaling implements Actionable {
    private SignalingState signalizationState;
    private int pin;

    public Signaling() {
        signalizationState = new SignalingDeactivatedState(this);
        pin = 0;
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

    void setCode(int PIN) {
        this.pin = PIN;
    }

    public boolean checkPassword(int PIN){
        return PIN == this.getCode();
    }

    public void activate(int pin){
        signalizationState.setActivated(pin);
    }

    public void deactivate(int pin){
        signalizationState.setDeactivated(pin);
    }

    public void signaling(){
        signalizationState.alarmOn();
    }

    public boolean isActivated() {
        return signalizationState instanceof SignalingActivatedState;
    }

    public boolean isDeactivated() {
        return signalizationState instanceof SignalingDeactivatedState;
    }

    public boolean isAlarmed() {
        return signalizationState instanceof SignalingAlarmOnState;
    }

    @Override
    public void execute(Event event) {
        event.accept(this);
    }
}
