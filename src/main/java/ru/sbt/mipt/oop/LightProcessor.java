package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightProcessor implements EventProcessor{
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!(event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)) {
            return;
        }
        smartHome.execute( device ->
                {
                    if (!(device instanceof Light)) {
                        return;
                    }
                    Light light = (Light) device;
                    if (!light.getId().equals(event.getObjectId())) {
                        return;
                    }
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " ON");
                    }
                    else if (event.getType() == LIGHT_ON){
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " OFF");
                    }
                }
        );
    }
}
