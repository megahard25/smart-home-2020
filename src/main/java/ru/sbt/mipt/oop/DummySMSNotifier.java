package ru.sbt.mipt.oop;

public class DummySMSNotifier implements Notifier {
    @Override
    public void donotify(){
        System.out.println("Send SMS!");
    }
}
