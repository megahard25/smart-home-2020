package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;


public class AlarmProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!(event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE)) {
            return;
        }
        smartHome.execute( device ->
                {
                    if (!(device instanceof Alarm)) {
                        return;
                    }
                    Alarm alarm = (Alarm) device;
                    if (!alarm.getId().equals(event.getObjectId())) {
                        return;
                    }
                    if (event.getType() == ALARM_ACTIVATE) {
                        if (alarm.activate(event.getType().getCode()))
                            System.out.println("Alarm ON");
                    }
                    else if(event.getType() == ALARM_DEACTIVATE) {
                        if (alarm.deactivate(event.getType().getCode()))
                            System.out.println("Alarm OFF");
                    }
                }
        );
    }
}
