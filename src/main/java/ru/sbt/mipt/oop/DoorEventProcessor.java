package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    private final CommandSender commandSender = new CommandSenderImpl();
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            smartHome.execute(doorObj -> {
                if (!(doorObj instanceof Door)) {
                    return;
                }
                Door door = (Door) doorObj;
                if (!door.getId().equals(event.getObjectId())) {
                    return;
                }
                if (event.getType() == DOOR_OPEN) {
                    door.setOpen(true);
                    System.out.println("Door " + door.getId() + " OPEN");
                } else {
                    door.setOpen(false);
                    System.out.println("Door " + door.getId() + " CLOSE");
                }
            });
        }
    }
}