package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!(event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED)) return;
        smartHome.execute(device ->
                {
                    if (!(device instanceof Door)) {
                        return;
                    }
                    Door door = (Door) device;
                    if (!door.getId().equals(event.getObjectId())) {
                        return;
                    }
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " opened");
                    } else if (event.getType() == DOOR_CLOSED) {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " closed");
                    }
                }
        );
    }
}