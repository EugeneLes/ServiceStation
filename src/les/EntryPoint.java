package les;

import httpurlconnect.HTTPURLConnection;

public class EntryPoint {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Start at EntryPoint");
        HTTPURLConnection.uploadFiles();



        System.out.println("Finished");
    }
}
