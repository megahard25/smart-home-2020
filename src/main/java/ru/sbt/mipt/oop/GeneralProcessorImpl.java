package ru.sbt.mipt.oop;

public class GeneralProcessorImpl implements GeneralProcessor {
    private final EventGenerator eventGenerator;
    private final EventHandler eventHandler;

    public GeneralProcessorImpl(EventHandler eventHandler, EventGenerator eventGenerator) {
        if (eventHandler == null) {
            throw new IllegalArgumentException();
        }
        if (eventGenerator == null) {
            throw new IllegalArgumentException();
        }
        this.eventHandler = eventHandler;
        this.eventGenerator = eventGenerator;
    }

    public void run(SmartHome smartHome) {
        eventHandler.executeEvent(smartHome, new SensorEvent(SensorEventType.ALARM_ACTIVATE, "12345"));
        boolean indicator = true;
        while(indicator) {
            SensorEvent event = eventGenerator.getNextEvent();
            if (event == null){
                indicator =  false;
            }
            else{
                eventHandler.executeEvent(smartHome, event);
                System.out.println(event + " handled!");
            };
        }
    }
}
