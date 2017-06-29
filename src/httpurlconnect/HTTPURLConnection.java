package httpurlconnect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 *
 */
public class HTTPURLConnection {

    private final String XML_URL= "http://kiparo.ru/t/service_station.xml";
    private final String JSON_URL= "http://kiparo.ru/t/service_station.json";
    private final String XML_PATH= "d:\\Idea\\IdeaProjects\\view.ServiceStationFX\\src\\service_station.xml";
    private final String JSON_PATH= "d:\\Idea\\IdeaProjects\\view.ServiceStationFX\\src\\service_station.json";
    //Singleton implementation for HTTPURLConnection
    private HTTPURLConnection(){

    }

    private static class HTTPURLConnectionHolder{
        private final static HTTPURLConnection instance = new HTTPURLConnection();
    }

    public static HTTPURLConnection getInstance(){
        return HTTPURLConnectionHolder.instance;
    }

    //thread implementation

    public void downloadFiles(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                downloadFile(XML_URL,XML_PATH);
                System.out.println("XML download Complete");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                downloadFile(JSON_URL,JSON_PATH);
                System.out.println("JSON download Complete");
            }
        });
        thread.start();
        thread2.start();
//        this.downloadFile(XML_URL,XML_PATH);
//        this.downloadFile(JSON_URL,JSON_PATH);
    }

    private void downloadFile(String fileUrl, String filepath){
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

