package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;


public class Room implements Actionable {
    private final String type;
    private final String name;
    private final Collection<Actionable> devices = new ArrayList<Actionable>();

    public Room(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.type = "Room";
        if (devices != null) {
            this.devices.addAll(devices);
        }
    }

    public void addDevice(Actionable device) {
        if (device == null) {
            throw new IllegalArgumentException();
        }
        devices.add(device);
    }

    @Override
    public void execute(Action action) {
        if (action == null) {
            return;
        }
        for(Actionable device : devices) {
            device.execute(action);
        }
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Collection<Actionable> getDevices() {
        return devices;
    }
}
