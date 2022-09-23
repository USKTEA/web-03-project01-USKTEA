package repository;

import infrastructure.Infrastructure;
import models.Mall;

import java.io.FileNotFoundException;

public class MallRepository {
    Infrastructure infrastructure;

    public MallRepository() {
        this.infrastructure = new Infrastructure("mall.csv");
    }

    public Mall products() throws FileNotFoundException {
        return infrastructure.mallProducts();
    }
}
