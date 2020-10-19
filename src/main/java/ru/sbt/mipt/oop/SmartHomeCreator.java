package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SmartHomeCreator {
    SmartHome loadSmartHome() throws IOException;
    void saveSmartHome(SmartHome smartHome);

}
