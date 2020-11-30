package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan
public class MainConfiguration {

    @Bean
    public SmartHome smartHome() {
        HomeReader reader = new JsonHomeReader();
        if(reader != null) {
            SmartHome smartHome = reader.getSmartHome();
            return smartHome;
        }
        return null;
    }

    @Bean
    Signaling signalization() {
        Signaling signalization = new Signaling();
        signalization.changeState(new SignalingDeactivatedState(signalization));
        return signalization;
    }

    @Bean
    Map<String, SensorEventType> getAdapter() {
        Map<String, SensorEventType> result = new HashMap<>();
        result.put("LightON", SensorEventType.LIGHT_ON);
        result.put("LightOFF", SensorEventType.LIGHT_OFF);
        result.put("DoorOPEN", SensorEventType.DOOR_OPEN);
        result.put("DoorCLOSE", SensorEventType.DOOR_CLOSED);
        result.put("DoorLOCK", SensorEventType.SIGNALIZATION_ACTIVATED);
        result.put("DoorUNLOCK", SensorEventType.SIGNALIZATION_DEACTIVATED);
        return result;
    }
    @Bean
    public AdapterNewApi doorsEventAdapter(SmartHome smartHome){
        return new AdapterNewApi(
                new AlarmSendMessageDecorator(new AlarmProcessorDecorator(new DoorEventProcessor())),
                getAdapter(), smartHome);
    }
    @Bean
    public AdapterNewApi hallDoorEventAdapter(SmartHome smartHome){
        return new AdapterNewApi(
                new AlarmProcessorDecorator(new HallDoorEventProcessor()),
                getAdapter(), smartHome);
    }
    @Bean
    public AdapterNewApi lightEventAdapter(SmartHome smartHome){
        return new AdapterNewApi(new AlarmProcessorDecorator(new LightEventProcessor()), getAdapter(), smartHome);
    }

    @Bean
    public AdapterNewApi signalizationEventAdapter(SmartHome smartHome) {
        return new AdapterNewApi(new SignalingEventProcessor(), getAdapter(), smartHome);
    }

    @Bean
    public SensorEventsManager sensorEventsManager(Collection<AdapterNewApi> adapters) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        adapters.forEach(sensorEventsManager::registerEventHandler);
        return sensorEventsManager;
    }

    @Bean
    CommandSender commandSender() {
        return new CommandSenderImpl();
    }
}
