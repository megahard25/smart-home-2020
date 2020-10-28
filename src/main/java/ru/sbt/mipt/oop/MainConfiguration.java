package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MainConfiguration {

    @Bean
    SmartHome smartHome() throws IOException {
        SmartHomeCreator creator = new SmartHomeJsonCreator("smart_home_input.json", "smart_home_output.json");
        return creator.loadSmartHome();
    }

    @Bean
    EventProcessor alarmEventProcessor() {
        return new AlarmProcessor();
    }

    @Bean
    EventProcessor doorEventProcessor() {
        return new DoorProcessor();
    }

    @Bean
    EventProcessor hallDoorEventProcessor() {
        return new HallDoorProcessor();
    }

    @Bean
    EventProcessor lightEventProcessor() {
        return new LightProcessor();
    }

    @Bean
    public Map<String,SensorEventType> getConvertor(){
        return new HashMap<String, SensorEventType>() {{
            put("LightIsOn", SensorEventType.LIGHT_ON);
            put("LightIsOff", SensorEventType.LIGHT_OFF);
            put("DoorIsOpen", SensorEventType.DOOR_OPEN);
            put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        }};
    }

    @Bean
    AdapterNewApi eventHandlerAdapter(EventProcessor eventProcessor, Map mapper, SmartHome smartHome) {
        return new AdapterNewApi(eventProcessor, mapper, smartHome);
    }

    @Bean
    SensorEventsManager sensorEventsManager(AdapterNewApi adapterNewApi) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(adapterNewApi);
        return sensorEventsManager;
    }
}