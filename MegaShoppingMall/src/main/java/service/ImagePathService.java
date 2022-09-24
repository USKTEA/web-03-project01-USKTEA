package service;

import repository.ImagePathRepository;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ImagePathService {
    public ImagePathService() {}

    public HashMap<String, String> getPaths() throws FileNotFoundException {
        return new ImagePathRepository().paths();
    }
}
