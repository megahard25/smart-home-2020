package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private final SmartHomeCreator smartHomeCreator;

    public Application(SmartHomeCreator smartHomeCreator) {
        this.smartHomeCreator = smartHomeCreator;
    }

    public static void main(String... args) throws IOException {
        SmartHomeCreator smartHomeCreator = new SmartHomeJsonCreator("NewHomeInp.json", "NewHomeOutp.json");
        Application application = new Application(smartHomeCreator);
        SmartHome smartHome = smartHomeCreator.loadSmartHome();
        if (smartHome == null) {
            System.out.println("Something wrong with input file");
            return;
        }

        List<EventProcessor> processors = Arrays.asList(
                new AlarmDecorator(new AlarmProcessor()),
                new AlarmDecorator(new LightProcessor()),
                new AlarmDecorator(new DoorProcessor()),
                new AlarmDecorator(new HallDoorProcessor())
        );

        GeneralProcessor generalProcess = new GeneralProcessorImpl(new EventHandler(processors), new EventGeneratorImpl());
        generalProcess.run(smartHome);
    }
}
