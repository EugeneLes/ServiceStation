package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.Controller;
import httpurlconnect.HTTPURLConnection;
import model.Customer;
import model.CustomerTableModel;
import model.Root;
import modelparser.AbstractModelParser;
import modelparser.ParserFactory;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by LeskovskijE on 6/29/2017.
 */
public class ServiceStationUI {
    private JPanel panel1;
    private JRadioButton radioXML;
    private JRadioButton radioJSON;
    private JProgressBar progressBar1;
    private JButton buttonUpdateModel;
    private JTable tableCustomers;
    private JTextField textFilterField;
    private JComboBox comboFilteredField;
    private JComboBox comboBoxSort;
    private JLabel statusLabel;

    public static void main(String[] args) {
        // write your code here
        System.out.println("Start at EntryPoint at " + Runtime.getRuntime() + " , " + System.currentTimeMillis());
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

    public ServiceStationUI() {
        JFrame frame = new JFrame("ServiceStation");
        frame.setContentPane(panel1);
        frame.setBounds(100, 100, 600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Controller.getInstance().initializeRootModel();
        TableModel model = new CustomerTableModel(Controller.getInstance().getRoot());
        //JTable table = new JTable(model);
        tableCustomers.setModel(model);
//        createUIComponents();
        buttonUpdateModel.addActionListener(new ButtonClickListener());


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void showUI() {
        createUIComponents();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("UpdateModel")) {
                Controller controller = Controller.getInstance();
                if (radioJSON.isSelected()) {
                    controller.performUpdateModel("JSON");
                } else {
                    controller.performUpdateModel("XML");
                };
                tableCustomers.setAutoCreateColumnsFromModel(true);
            } else if (command.equals("Filter")) {
//                statusLabel.setText("Submit Button clicked.");
            } else {
//                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
    //private class

}
