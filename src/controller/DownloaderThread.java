package controller;

import httpurlconnect.HTTPURLConnection;

/**
 * Created by Eugene on 28.06.2017.
 */
public class DownloaderThread extends Thread{
    private ParserThread parserThread;

    public void setParserThread(ParserThread parserThread){
        this.parserThread = parserThread;

    }

    @Override
    public void run() {
        //downloading file
        System.out.println("DownloaderThread - Dowloading file");
        HTTPURLConnection connection = HTTPURLConnection.getInstance();
        connection.downloadFiles();
        try {// to give Parser thread time to fall asleep
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //waking up parserthread, then sleeping
        synchronized (parserThread) {
            System.out.println("DownloaderThread - Waking up parseThread");
            parserThread.notifyAll();
        }

        //going on sleep
        synchronized (this) {//Actually, there is no need for waiting here, but just in case for future implementation
            System.out.println("DownloaderThread - going on sleep");
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        System.out.println("DownloaderThread - finish");
    }
}
