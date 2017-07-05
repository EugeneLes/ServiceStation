package controller;

import httpurlconnect.HTTPURLConnection;
import model.Customer;
import model.Root;
import modelparser.AbstractModelParser;
import modelparser.ParserFactory;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by LeskovskijE on 6/29/2017.
 */
public class Controller {
    static final String jsonPath = "src\\service_station.json";
    static final String xmlPATH= "src\\service_station.xml";

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    Root root;
    private Controller(){

    }

    private static class ControllerHolder{
        private final static Controller instance = new Controller();
    }

    public static Controller getInstance(){
        return ControllerHolder.instance;
    }

    public void performUpdateModel(String filetype){
        String path = "";
        if (filetype=="XML"){
            path = xmlPATH;
        }else if (filetype=="JSON"){
            path = jsonPath;
        }
        HTTPURLConnection connection = HTTPURLConnection.getInstance();
        connection.downloadFiles();
        ParserFactory parserFactory = new ParserFactory();
        AbstractModelParser parser = parserFactory.getParser(path);
        setRoot(parser.parse(path));
        System.out.println(getRoot().toString());


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
}

