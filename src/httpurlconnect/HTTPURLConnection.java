package httpurlconnect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HTTPURLConnection {

    private static final String XML_URL= "http://kiparo.ru/t/service_station.xml";
    private static final String JSON_URL= "http://kiparo.ru/t/service_station.json";
    private static final String XML_PATH= "d:\\Idea\\IdeaProjects\\ServiceStation\\src\\service_station.xml";
    private static final String JSON_PATH= "d:\\Idea\\IdeaProjects\\ServiceStation\\src\\service_station.json";


    public static void uploadFiles(){
        uploadFile(XML_URL,XML_PATH);
        uploadFile(JSON_URL,JSON_PATH);
    }

    private static void uploadFile(String fileUrl, String filepath){
	// write your code here

        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL url = new URL(fileUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            //get RC
            int responseCode = httpURLConnection.getResponseCode();
            //verify connection
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();

                File file = new File(filepath);
                outputStream = new FileOutputStream(file);


                byte[] buffer = new byte[1024]; //the entire information(data)
                int bytesRead = -1;// amount of data that was read pe iteration
                while ((bytesRead = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer,0,bytesRead); //write data from position 0 to bytesRead
                }

            } else {
                System.out.println(responseCode);
            }
        } catch (Exception ex) {
            System.out.println("Error - "+ ex.toString());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                System.out.println("Closing file error" + e.toString());
            }
        }
    }
}

