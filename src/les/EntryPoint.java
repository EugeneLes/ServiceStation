package les;

import ModelParser.AbstractModelParser;
import ModelParser.ParserFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import httpurlconnect.HTTPURLConnection;
import model.Root;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class EntryPoint {
    static final String jsonPath = "src\\service_station.json";
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

        System.out.println("Finished");
    }

}
