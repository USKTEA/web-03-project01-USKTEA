package repository;

import infrastructure.FileManager;
import models.Mall;

import java.io.FileNotFoundException;

public class MallRepository {
    FileManager fileManager;

    public MallRepository() {
        this.fileManager = new FileManager("mall.csv");
    }

    public Mall products() throws FileNotFoundException {
        return fileManager.mallProducts();
    }
}
