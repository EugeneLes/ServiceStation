package model;

import java.util.ArrayList;
import java.util.Comparator;
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

    public Customer() {
    }

    public Customer(int id, String name, String surname, String middle_name, Date lastOrder, Date dateOfBirth, ArrayList<String> car, boolean discount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.lastOrder = lastOrder;
        this.dateOfBirth = dateOfBirth;
        this.car = car;
        this.discount = discount;
    }

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

    // реализуем интерфейс Comparator, для сортировки по id
    public static Comparator<Customer> sortedById = new Comparator<Customer>() {

        public int compare(Customer obj1, Customer obj2) {

            int id1 = obj1.getId();
            int id2 = obj2.getId();

            if(id1 > id2) {
                return 1;
            }
            else if(id1 < id2) {
                return -1;
            }
            else {
                return 0;
            }
        }
    };
    // реализуем интерфейс Comparator, для сортировки по имени
    public static Comparator<Customer> sortedByName = new Comparator<Customer>() {

        public int compare(Customer obj1, Customer obj2) {

            String str1 = obj1.getName();
            String str2 = obj2.getName();

            return str1.compareTo(str2);
        }
    };

    // реализуем интерфейс Comparator, для сортировки по фамилии
    public static Comparator<Customer> sortedBySurname = new Comparator<Customer>() {

        public int compare(Customer obj1, Customer obj2) {

            String str1 = obj1.getSurname();
            String str2 = obj2.getSurname();

            return str1.compareTo(str2);
        }
    };
    // реализуем интерфейс Comparator, для сортировки по middle name
    public static Comparator<Customer> sortedBymiddlename = new Comparator<Customer>() {

        public int compare(Customer obj1, Customer obj2) {

            String str1 = obj1.getMiddle_name();
            String str2 = obj2.getMiddle_name();

            return str1.compareTo(str2);
        }
    };
    // реализуем интерфейс Comparator, для сортировки по дате последнего заказа
    public static Comparator<Customer> sortedByLastOrder = new Comparator<Customer>() {

        public int compare(Customer obj1, Customer obj2) {

            Date date1 = obj1.getLastOrder();
            Date date2 = obj2.getLastOrder();
            return date1.compareTo(date2);
        }
    };
    // реализуем интерфейс Comparator, для сортировки по дате последнего заказа
    public static Comparator<Customer> sortedByBirthDay = new Comparator<Customer>() {

        public int compare(Customer obj1, Customer obj2) {

            Date date1 = obj1.getDateOfBirth();
            Date date2 = obj2.getDateOfBirth();
            return date1.compareTo(date2);
        }
    };

}
