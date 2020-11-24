package ru.sbt.mipt.oop;

public class CommandSenderImpl implements CommandSender {
    @Override
    public void sendCommand(SensorCommand command) {
        System.out.println("Sending command " + command);
    }
}