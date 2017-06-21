package les;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import httpurlconnect.HTTPURLConnection;
import model.Customers;
import model.Root;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class EntryPoint {
    static final String jsonPath = "src\\service_station.json";
    public static void main(String[] args) {
	// write your code here
        System.out.println("Start at EntryPoint");
        HTTPURLConnection.uploadFiles();

        Root root = parseJackson(jsonPath);
        System.out.println(root.toString());

        System.out.println("Finished");
    }
    public static Root parseGson(String path){
        Root root = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            root  = gson.fromJson(reader, Root.class);

        }catch(Exception e){
            System.out.println("Reading error!!!"+e.toString());
        }

        return root;
    }
    public static Root parseJackson(String path){
        Root root = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            BufferedReader reader = new BufferedReader(new FileReader(jsonPath));
            root = mapper.readValue(reader, Root.class);
            System.out.println(root.toString());
        } catch (IOException e) {
            System.out.println("Reading error!!!"+e.toString());
        }
        return root;
    }
}
