package service;

import models.Mall;
import models.Service;
import repository.MallRepository;

import java.io.FileNotFoundException;
import java.util.List;

public class MallService {
    public MallService() {}

    public List<Service> products() throws FileNotFoundException {
        Mall mall = new MallRepository().products();

        return mall.products();
    }
}
