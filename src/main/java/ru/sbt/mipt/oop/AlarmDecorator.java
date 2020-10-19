package ru.sbt.mipt.oop;

public class AlarmDecorator implements EventProcessor {
    private final EventProcessor source;

    public AlarmDecorator(EventProcessor source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        this.source = source;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        Alarm alarm = smartHome.getAlarm();

        if (alarm == null || isAlarm(event)) {
            source.processEvent(smartHome, event);
            return;
        }
        if (alarm.state == AlarmStates.availableState) {
            alarm.activateRinging();
        }
        if (alarm.state == AlarmStates.ringingState) {
            System.out.println("SMS sent");
            return;
        }

        source.processEvent(smartHome, event);
    }

    private boolean isAlarm(SensorEvent event) {
        return event.getType() == SensorEventType.ALARM_DEACTIVATE || event.getType() == SensorEventType.ALARM_ACTIVATE;
    }
}
