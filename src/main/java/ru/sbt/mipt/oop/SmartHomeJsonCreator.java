package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SmartHomeJsonCreator implements SmartHomeCreator {
    private final String inputFileName;
    private final String outputFileName;

    public SmartHomeJsonCreator(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    @Override
    public SmartHome loadSmartHome() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        return smartHome;
    }

    @Override
    public void saveSmartHome(SmartHome smartHome) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(smartHome);
        Path path = Paths.get(outputFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        } catch (IOException exception) {
            System.out.println("Output file " + outputFileName + " is not exist!");
            exception.printStackTrace();
        }
    }
}
