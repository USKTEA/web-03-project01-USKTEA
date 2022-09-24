package controller;

import service.ImagePathService;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ImagePathController {
    public ImagePathController() {}

    public HashMap<String, String> getPaths() throws FileNotFoundException {
        return new ImagePathService().getPaths();
    }
}
