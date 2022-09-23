package service;

import models.Mall;
import models.Product;
import repository.MallRepository;

import java.io.FileNotFoundException;
import java.util.List;

public class MallService {
    public MallService() {}

    public List<Product> products() throws FileNotFoundException {
        Mall mall = new MallRepository().products();

        return mall.products();
    }
}
