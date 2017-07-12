package controller;

import httpurlconnect.HTTPURLConnection;
import model.Customer;
import model.CustomerTableModel;
import model.Root;
import modelparser.AbstractModelParser;
import modelparser.ParserFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.*;

/**
 * Created by LeskovskijE on 6/29/2017.
 */
public class Controller {
    private String filteredBy = "No filter";
    private volatile String fileType;
    private JTable jTable;
    Root root;
    public String getFilteredBy() {
        return this.filteredBy;
    }

    public void setFilteredBy(String filteredBy) {
       this.filteredBy = filteredBy;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public JTable getjTable() {
        return jTable;
    }
    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public Root getRoot() {
        return root;
    }
    public void setRoot(Root root) {
        this.root = root;
    }

    private Controller(){

    }

    private static class ControllerHolder{
        private final static Controller instance = new Controller();
    }

    public static Controller getInstance(){
        return ControllerHolder.instance;
    }

    public void performUpdateModel(){
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();

        downloaderThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloaderThread);

        parserThread.start();
        downloaderThread.start();

    }
    public void initializeRootModel(){
//        ParserFactory parserFactory = new ParserFactory();
//        AbstractModelParser parser = parserFactory.getParser(jsonPath);
        Date today = new Date();
        root = new Root();
        //Customer customer = new Customer();
        Customer customer = new Customer(00,"Name","","",today,today,new ArrayList<String>(),true);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        root.setCustomers(customers);
        //parser.parse(jsonPath);
    }
    public void sortBy(String itemStr){
        ArrayList<Customer> customers = Controller.getInstance().getRoot().getCustomers();

        switch (itemStr) {
            case "ID":
                Collections.sort(customers, Customer.sortedById);
                System.out.println("Sorting by ID");
                break;
            case "Name":
                Collections.sort(customers, Customer.sortedByName);
                System.out.println("Sorting by Name");
                break;
            case "Surname":
                Collections.sort(customers, Customer.sortedBySurname);
                System.out.println("Sorting by Surname");
                break;
            case "Middle Name":
                Collections.sort(customers, Customer.sortedBymiddlename);
                System.out.println("Sorting by Middle name");
                break;
            case "Date of Birth":
                Collections.sort(customers, Customer.sortedByBirthDay);
                System.out.println("Sorting by Date of Birth");
                break;
            case "Last Order Day":
                Collections.sort(customers, Customer.sortedByLastOrder);
                System.out.println("Sorting by Last order Date");
                break;
        }
        Controller.getInstance().getRoot().setCustomers(customers);
        Controller.getInstance().getjTable().setModel(new CustomerTableModel(Controller.getInstance().getRoot()) );//need to update TableModel just after sorting
        return;

    }

}

