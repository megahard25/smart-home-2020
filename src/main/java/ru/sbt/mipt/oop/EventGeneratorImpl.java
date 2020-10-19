package ru.sbt.mipt.oop;

import java.util.concurrent.ThreadLocalRandom;

public class EventGeneratorImpl implements EventGenerator {
    public SensorEvent getNextEvent() {
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        sensorEventType.setCode(Integer.toString(ThreadLocalRandom.current().nextInt(9999)));
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
