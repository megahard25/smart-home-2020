package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import java.util.HashMap;

public class EventProcessorAdapter implements EventHandler{
    private final EventProcessor eventProcessor;
    private final SmartHome smartHome;
    private final HashMap<String, SensorEventType> adapter;

    public EventProcessorAdapter(EventProcessor eventProcessor, SmartHome smartHome, HashMap<String, SensorEventType> adapter) {
        this.eventProcessor = eventProcessor;
        this.smartHome = smartHome;
        this.adapter = adapter;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        if(adapter.containsKey(event.getEventType())) {
            eventProcessor.processEvent(smartHome, new SensorEvent(adapter.get(event.getEventType()), event.getObjectId()));
        }
    }
}