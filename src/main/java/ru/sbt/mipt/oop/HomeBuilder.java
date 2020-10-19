package ru.sbt.mipt.oop;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        Collection<Room> allRooms = new ArrayList<Room>();

        Room kitchen = new Room("eat");
        kitchen.addDevice(new Light("1", false));
        kitchen.addDevice(new Light("2", true));
        kitchen.addDevice(new Door("3", false));
        kitchen.addDevice(new Door("6", false));
        allRooms.add(kitchen);

        Room bathroom = new Room("bath");
        bathroom.addDevice(new Light("4", false));
        bathroom.addDevice(new Light("5", false));
        bathroom.addDevice(new Door("6", false));
        allRooms.add(bathroom);

        Room livingRoom1 = new Room("childrens room");
        livingRoom1.addDevice(new Light("7", false));
        livingRoom1.addDevice(new Door("8", false));
        allRooms.add(livingRoom1);

        Room livingRoom2 = new Room("parents room");
        livingRoom2.addDevice(new Light("9", false));
        livingRoom2.addDevice(new Door("10", false));
        allRooms.add(livingRoom2);

        Room lobby = new Room("hallway");
        lobby.addDevice(new Light("15", false));
        lobby.addDevice(new Door("0", false));
        lobby.addDevice(new Door("16", false));
        allRooms.add(lobby);

        Room hall = new Room("general space");
        hall.addDevice(new Light("11", false));
        hall.addDevice(new Light("12", false));
        hall.addDevice(new Light("13", false));
        hall.addDevice(new Light("14", false));
        hall.addDevice(new Door("8", false));
        hall.addDevice(new Door("10", false));
        hall.addDevice(new Door("16", false));
        allRooms.add(hall);

        Alarm alarm = new Alarm("12345");
        SmartHome smartHome = new SmartHome(allRooms, alarm);
        SmartHomeCreator smartHomeCreator = new SmartHomeJsonCreator(
                "InpName.json",
                "OutName.json");
        smartHomeCreator.saveSmartHome(smartHome);
    }
}
