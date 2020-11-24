package ru.sbt.mipt.oop;

import java.util.List;

public interface EventManager {
    public void manage(List<EventProcessor> processEvents);
}
