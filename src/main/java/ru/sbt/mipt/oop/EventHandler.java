package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EventHandler {
    private final List<EventProcessor> processors = new ArrayList<>();

    public EventHandler(Collection<EventProcessor> processors) {
        this.processors.addAll(processors);
    }

    public void executeEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        processors.forEach(processor -> processor.processEvent(smartHome, sensorEvent));
    }
}
