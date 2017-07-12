package controller;

import model.CustomerTableModel;
import modelparser.AbstractModelParser;
import modelparser.ParserFactory;

/**
 * Created by Eugene on 28.06.2017.
 */
public class ParserThread extends Thread {
    final String PATHWITHOUTSUFFIX = "d:\\Idea\\IdeaProjects\\ServiceStation\\src\\service_station";
    private DownloaderThread downloaderThread;

    public void setDownloaderThread(DownloaderThread downloaderThread){
        this.downloaderThread = downloaderThread;
    }

    @Override
    public void run() {
        //going on sleep waiting until DownloaderThread will work
        synchronized (this) {
            System.out.println("ParserThread - going on sleep");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        //parsing file
        System.out.println("ParserThread - Parsing file");
        String fullPath = PATHWITHOUTSUFFIX+Controller.getInstance().getFileType();
        ParserFactory parserFactory = new ParserFactory();
        AbstractModelParser parser = parserFactory.getParser(fullPath);
        Controller.getInstance().setRoot(parser.parse(fullPath));
        System.out.println(Controller.getInstance().getRoot().toString());
        //Controller.getInstance().getCustomerTableModel().fireTableDataChanged();//Parsing


        //waking up downloaderThread
        synchronized (downloaderThread) {
            System.out.println("ParserThread - Waking up downloaderThread");
            downloaderThread.notifyAll();
        }
        Controller.getInstance().getjTable().setModel(new CustomerTableModel(Controller.getInstance().getRoot()) );//need to update TableModel just after parsing
        System.out.println("ParserThread - Finish");
    }
}
