package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;

import java.util.Map;

public class AdapterNewApi implements com.coolcompany.smarthome.events.EventHandler {
    private final SmartHome smartHome;
    EventProcessor processor;
    private final Map<String, SensorEventType> mapper;

    public AdapterNewApi(EventProcessor processor, Map<String, SensorEventType> mapper, SmartHome smartHome) {
        this.smartHome = smartHome;
        this.processor = processor;
        this.mapper = mapper;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = new SensorEvent(mapper.get(event.getEventType()), event.getObjectId());
        sensorEvent.setPIN(666);
        processor.processEvent(smartHome, sensorEvent);
    }
}