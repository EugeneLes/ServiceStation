package modelparser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Root;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by LeskovskijE on 6/28/2017.
 */
public class JSONModelParser extends AbstractModelParser {

//    @Override
//    public Root parse(String path){//parse json file with Gson - not used
//        Root root = null;
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(path));
//            Gson gson = new Gson();
//            root  = gson.fromJson(reader, Root.class);
//
//        }catch(Exception e){
//            System.out.println("Reading error!!!"+e.toString());
//        }
//
//        return root;
//    }
    @Override
    public Root parse(String path){//parse json file with Jackson
        Root root = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            BufferedReader reader = new BufferedReader(new FileReader(path));
            root = mapper.readValue(reader, Root.class);
            System.out.println(root.toString());
        } catch (IOException e) {
            System.out.println("Reading error!!!"+e.toString());
        }
        return root;
    }
}
