package repository;

import infrastructure.FileManager;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ImagePathRepository {
    FileManager fileManager;

    public ImagePathRepository() {
        fileManager = new FileManager("imagePaths.csv");
    }

    public HashMap<String, String> paths() throws FileNotFoundException {
        return fileManager.imagePaths();
    }
}
