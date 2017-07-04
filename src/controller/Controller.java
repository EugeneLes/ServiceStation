package controller;

import httpurlconnect.HTTPURLConnection;
import model.Root;
import modelparser.AbstractModelParser;
import modelparser.ParserFactory;

/**
 * Created by LeskovskijE on 6/29/2017.
 */
public class Controller {
    static final String jsonPath = "src\\service_station.json";
    static final String xmlPATH= "src\\service_station.xml";
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
        Root root = parser.parse(path);
        System.out.println(root.toString());

    }
    public Root initializeRootModel(){
        ParserFactory parserFactory = new ParserFactory();
        AbstractModelParser parser = parserFactory.getParser(jsonPath);
        return  parser.parse(jsonPath);
    }
}

