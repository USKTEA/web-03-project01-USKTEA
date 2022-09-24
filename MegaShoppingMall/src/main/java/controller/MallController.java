package controller;

import models.Service;
import service.MallService;

import java.io.FileNotFoundException;
import java.util.List;

public class MallController {
    public MallController() {}

    public List<Service> products() throws FileNotFoundException {
        return new MallService().products();
    }
}
