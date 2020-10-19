package ru.sbt.mipt.oop;

public class HallDoorProcessor implements EventProcessor{
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!(event.getType() == SensorEventType.DOOR_CLOSED)) {
            return;
        }
        smartHome.execute( device ->
                {
                    if (!(device instanceof Room)) {
                        return;
                    }
                    Room room = (Room) device;
                    if (!room.getName().equals("hall")) {
                        return;
                    }
                    room.execute(deviceInRoom ->
                    {
                        if (!(deviceInRoom instanceof Door)) {
                            return;
                        }
                        Door door = (Door) deviceInRoom;
                        if (((Door) deviceInRoom).getId().equals(event.getObjectId()))
                            turnOffAllLights(smartHome);
                    });
                }
        );
    }

    private void turnOffAllLights(SmartHome smartHome) {
        smartHome.execute(object ->
        {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(false);
                System.out.println("Light " + light.getId() + " was off.");
            }
        });
    }
}
