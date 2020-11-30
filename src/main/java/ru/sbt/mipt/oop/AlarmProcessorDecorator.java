package ru.sbt.mipt.oop;

import java.util.List;

public class AlarmProcessorDecorator implements EventProcessor {
    private final EventProcessor handler;

    public AlarmProcessorDecorator(EventProcessor handler) {
        this.handler = handler;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (isAlarmType(event)) {
            smartHome.execute(object -> {
                if (!(object instanceof Signaling)) {
                    return;
                }
                Signaling signaling = (Signaling) object;
                if (signaling.isAlarmed()) {
                    return;
                }
                handler.processEvent(smartHome, event);
                if (signaling.isActivated()) {
                    signaling.signaling();
                }
            });
        }
    }

    private boolean isAlarmType(SensorEvent event) {
        return event.getType() != SensorEventType.SIGNALIZATION_ACTIVATED && event.getType() != SensorEventType.SIGNALIZATION_DEACTIVATED;
    }
}