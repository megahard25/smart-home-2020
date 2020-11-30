package ru.sbt.mipt.oop;

public class SignalingEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if (sensorEvent.getType() == SensorEventType.SIGNALIZATION_ACTIVATED) {
            smartHome.getSignaling().getSignalizationState().setActivated(sensorEvent.getPIN());
        } else if(sensorEvent.getType() == SensorEventType.SIGNALIZATION_DEACTIVATED){
            smartHome.getSignaling().getSignalizationState().setDeactivated(sensorEvent.getPIN());
        }
    }
}