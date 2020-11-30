package com.coolcompany.smarthome.events;

import java.util.ArrayList;
import java.util.Collection;

public class SensorEventsManager {
    private final String[] eventTypes = new String[] { "LightON", "LightOFF", "DoorOPEN", "DoorCLOSE", "DoorLOCK", "DoorUNLOCK" };

    private Collection<EventHandler> handlers = new ArrayList<>();

    public void registerEventHandler(EventHandler handler) {
        this.handlers.add(handler);
    }

    public void start() {
        CCSensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("EVENT: " + event);
            for (EventHandler handler : handlers) {
                //System.out.println(event);
                handler.handleEvent(event);
            }
            event = getNextSensorEvent();
        }
    }

    private CCSensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null; // null means end of event stream
        String sensorEventType = eventTypes[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new CCSensorEvent(sensorEventType, objectId);
    }


}