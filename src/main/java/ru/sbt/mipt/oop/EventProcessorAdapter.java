package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import java.util.Map;

public class EventProcessorAdapter implements EventHandler{
    private final EventProcessor eventProcessor;
    private final SmartHome smartHome;
    private final Map<String, SensorEventType> adapter;

    public EventProcessorAdapter(EventProcessor eventProcessor, SmartHome smartHome, Map<String, SensorEventType> adapter) {
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