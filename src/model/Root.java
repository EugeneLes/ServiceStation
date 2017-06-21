package model;

import java.util.ArrayList;

/**
 * Created by Eugene on 21.06.2017.
 */
public class Root {
    String name;
    String location;
    ArrayList<Customers> customers;

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", customers=" + customers +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customers> customers) {
        this.customers = customers;
    }
}
