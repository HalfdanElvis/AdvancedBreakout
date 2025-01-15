package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.stage.Screen;

import java.io.FileReader;

public class OptionsModel {
    private static double sceneWidth = Screen.getPrimary().getBounds().getWidth();
    private static double sceneHeight = Screen.getPrimary().getBounds().getHeight();
    private static double musicVolume = 1;
    private static double SoundVolume = 1;

    public static void loadOptions() {

    }

    public static double getSceneWidth() {
        return sceneWidth;
    }
    public static double getSceneHeight() {
        return sceneHeight;
    }
    public static double getMusicVolume() {
        return musicVolume;
    }
    public static double getSoundVolume() {
        return SoundVolume;
    }
}