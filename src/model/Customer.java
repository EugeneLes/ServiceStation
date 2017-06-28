package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Eugene on 21.06.2017.
 *
 */
public class Customer {

//    "id": 0,
//            "name": "Ivan",
//            "surname":"Ivanov",
//            "middle_name":"Ivanovich",
//            "lastOrder": "2015-09-25",
//            "dateOfBirth": "2004-10-25",
//            "car": [
//            "BMW 5",
//            "Opel"
//            ],
//            "discount": true
    int id;
    String name;
    String surname;
    String middle_name;
    Date lastOrder;
    Date dateOfBirth;
    ArrayList<String> car;
    boolean discount;
//Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public Date getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(Date lastOrder) {
        this.lastOrder = lastOrder;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<String> getCar() {
        return car;
    }

    public void setCar(ArrayList<String> car) {
        this.car = car;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", lastOrder=" + lastOrder +
                ", dateOfBirth=" + dateOfBirth +
                ", car=" + car +
                ", discount=" + discount +
                '}';
    }
}
