package models;

import java.util.List;

public class Mall {
    private List<Service> services;

    public Mall(List<Service> services) {
        this.services = services;
    }

    public List<Service> products() {
        return services;
    }
}
