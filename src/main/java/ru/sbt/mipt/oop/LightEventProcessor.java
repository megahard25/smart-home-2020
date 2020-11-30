package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            smartHome.execute(lightObj -> {
                if (!(lightObj instanceof Light)) {
                    return;
                }
                Light light = (Light) lightObj;
                if (!light.getId().equals(event.getObjectId())) {
                    return;
                }
                if (event.getType() == LIGHT_ON) {
                    light.setOn(true);
                    System.out.println("light " + light.getId() + " ON");
                } else {
                    light.setOn(false);
                    System.out.println("light " + light.getId() + " OFF");
                }
            });
        }
    }
}