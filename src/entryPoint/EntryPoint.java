package entryPoint;

import controller.Controller;
import httpurlconnect.HTTPURLConnection;
import model.Root;
import modelparser.AbstractModelParser;
import modelparser.ParserFactory;
import view.ServiceStationUI;

import javax.swing.*;

public class EntryPoint {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Start at EntryPoint at "+ Runtime.getRuntime()+" , "+System.currentTimeMillis());
        //JFrame mainFrame = new JFrame();
//        Root root = new Root();

        ServiceStationUI serviceStationUI = new ServiceStationUI();
        //serviceStationUI.showUI();
        //Establish connection and dounloading files
//        HTTPURLConnection connection = HTTPURLConnection.getInstance();
//        connection.downloadFiles();
//
//        ParserFactory parserFactory = new ParserFactory();
//        AbstractModelParser parser = parserFactory.getParser(jsonPath);
//        Root root = parser.parse(jsonPath);
//        System.out.println(root.toString());
//        System.out.println("Parse xml ----->");
//        parser = parserFactory.getParser(xmlPATH);
//        root = parser.parse(xmlPATH);
//        System.out.println(root.toString());
//        System.out.println("Finished");
    }

}
