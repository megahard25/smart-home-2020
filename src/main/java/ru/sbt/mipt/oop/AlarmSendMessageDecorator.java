package ru.sbt.mipt.oop;

public class AlarmSendMessageDecorator implements EventProcessor {
    private final EventProcessor handler;

    public AlarmSendMessageDecorator(EventProcessor handler) {
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
                if (signaling.isAlarmed() || signaling.isActivated()) {
                    System.out.println("Send SMS!");
                }
            });
        }
        handler.processEvent(smartHome, event);
    }

    private boolean isAlarmType(SensorEvent event) {
        return event.getType() != SensorEventType.SIGNALIZATION_ACTIVATED && event.getType() != SensorEventType.SIGNALIZATION_DEACTIVATED;
    }
}
