package controller;

import models.Product;
import service.MallService;

import java.io.FileNotFoundException;
import java.util.List;

public class MallController {
    public MallController() {}

    public List<Product> products() throws FileNotFoundException {
        return new MallService().products();
    }
}
