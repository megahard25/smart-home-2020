package ru.sbt.mipt.oop;

import java.util.List;

public class LoopEventManager implements EventManager {
    private final EventGenerator eventGenerator;
    private final SmartHome smartHome;
    private List<EventProcessor> handlers;


    public LoopEventManager(EventGenerator eventGenerator, SmartHome smartHome) {
        this.eventGenerator = eventGenerator;
        this.smartHome = smartHome;
    }
    @Override
    public void manage(List<EventProcessor> processEvents) {
        SensorEvent event = eventGenerator.getNextEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processEvent : processEvents){
                processEvent.processEvent(smartHome, event);
            }
            event = eventGenerator.getNextEvent();
        }

    }
}
