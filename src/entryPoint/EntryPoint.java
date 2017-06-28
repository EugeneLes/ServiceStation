package entryPoint;

import modelparser.AbstractModelParser;
import modelparser.ParserFactory;
import httpurlconnect.HTTPURLConnection;
import model.Root;

public class EntryPoint {
    static final String jsonPath = "src\\service_station.json";
    static final String xmlPATH= "src\\service_station.xml";
    public static void main(String[] args) {
	// write your code here
        System.out.println("Start at EntryPoint");
        //Establish connection and dounloading files
        HTTPURLConnection connection = HTTPURLConnection.getInstance();
        connection.downloadFiles();

        ParserFactory parserFactory = new ParserFactory();
        AbstractModelParser parser = parserFactory.getParser(jsonPath);
        Root root = parser.parse(jsonPath);
        System.out.println(root.toString());
        System.out.println("Parse xml ----->");
        parser = parserFactory.getParser(xmlPATH);
        root = parser.parse(xmlPATH);
        System.out.println(root.toString());
        System.out.println("Finished");
    }

}
