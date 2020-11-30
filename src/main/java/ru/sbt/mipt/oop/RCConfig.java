package ru.sbt.mipt.oop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.commands.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RCConfig {
    @Bean
    public RemoteControlRegistry remoteControlRegistry(Collection<RemoteControl> remoteControls) {
        RemoteControlRegistry registry = new RemoteControlRegistry();
        remoteControls.forEach(e -> {
            registry.registerRemoteControl(e, e.getId());
        });
        return registry;
    }

    @Bean
    public SmartHomeRC smartHomeRemoteControl(
            @Qualifier(value = "buttons") Map<String, CommandRC> buttons) {
        return new SmartHomeRC("1", buttons);
    }

    @Bean
    CommandRC ActivateSignalizationCommand(SmartHome smartHome) {
        return new CommandSignalingOn(smartHome);
    }

    @Bean
    CommandRC AlarmOnCommand(SmartHome smartHome) {
        return new CommandAlarmOn(smartHome);
    }

    @Bean
    CommandRC CloseHallDoorCommand(SmartHome smartHome) {
        return new CommandHallClose(smartHome);
    }

    @Bean
    CommandRC SwitchOffAllLightCommand(SmartHome smartHome) {
        return new CommandAllLightOff(smartHome);
    }

    @Bean
    CommandRC SwitchOffHallLightCommand(SmartHome smartHome) {
        return new CommandHallLightOff(smartHome);
    }

    @Bean
    CommandRC SwitchOnAllLightCommand(SmartHome smartHome) {
        return new CommandAllLightOn(smartHome);
    }
    @Bean
    Map<String, CommandRC> buttons(
            CommandRC ActivateSignalizationCommand,
            CommandRC AlarmOnCommand,
            CommandRC CloseHallDoorCommand,
            CommandRC SwitchOffAllLightCommand,
            CommandRC SwitchOffHallLightCommand,
            CommandRC SwitchOnAllLightCommand
    ) {
        Map<String, CommandRC> buttons = new HashMap<>();
        buttons.put("A", ActivateSignalizationCommand);
        buttons.put("B", AlarmOnCommand);
        buttons.put("C", CloseHallDoorCommand);
        buttons.put("D", SwitchOffAllLightCommand);
        buttons.put("1", SwitchOffHallLightCommand);
        buttons.put("2", SwitchOnAllLightCommand);
        return buttons;
    }
}
