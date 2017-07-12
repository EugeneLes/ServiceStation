package view;

import controller.Controller;
import model.CustomerTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.*;

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
    static private String[] comboSortItems = {"ID","Name","Surname","Middle Name","Date of Birth","Last Order Day","Discount"};
    static private String[] comboFilterItems = {"No filter","ID","Name","Surname","Middle Name","Cars","Discount"};
    static private String filteredBy = "No filter";

    public static void main(String[] args) {
        // This is an Entry Point
        System.out.println("Start at EntryPoint at " + System.currentTimeMillis());
        new ServiceStationUI();

    }

    public ServiceStationUI() {
        JFrame frame = new JFrame("ServiceStation");
        frame.setContentPane(panel1);
        frame.setBounds(100, 100, 600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Controller.getInstance().initializeRootModel();
        AbstractTableModel tableModel = new CustomerTableModel(Controller.getInstance().getRoot());

        Controller.getInstance().setjTable(tableCustomers);

        tableCustomers.setModel(tableModel);
        tableCustomers.getModel().addTableModelListener(new MyTableModelListener());
        buttonUpdateModel.addActionListener(new ButtonClickListener());
        for (String s:comboSortItems) {comboBoxSort.addItem(s);}
        comboBoxSort.addItemListener(new MySorterItemListener());
        for (String s:comboFilterItems) {comboFilteredField.addItem(s);}
        comboFilteredField.addItemListener(new MyFilterItemListener());

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
                    controller.setFileType(".json");
                    statusLabel.setText("FileType - JSON.");
                } else {
                    controller.setFileType(".xml");
                    statusLabel.setText("FileType - XML.");
                }
                Controller.getInstance().performUpdateModel();
//                tableCustomers.createDefaultColumnsFromModel();
//                tableCustomers.setAutoCreateColumnsFromModel(true);
            } else if (command.equals("Filter")) {
                statusLabel.setText("Filter Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
    public class MySorterItemListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent itemEvent) {
            int state = itemEvent.getStateChange();
            System.out.println((state == ItemEvent.SELECTED) ? " Selected" : " Deselected");
            if (state == ItemEvent.SELECTED) {

                String itemStr = itemEvent.getItem().toString();
                System.out.println("Item: " + itemStr);
                System.out.println(itemEvent.getStateChange());
                Controller.getInstance().sortBy(itemStr);
//                ItemSelectable is = itemEvent.getItemSelectable();
//                System.out.println(", Selected: " + is.getSelectedObjects().toString());
            }
        }
    }
    public class MyFilterItemListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent itemEvent) {
            int state = itemEvent.getStateChange();
            System.out.println((state == ItemEvent.SELECTED) ? " Selected" : " Deselected");
            if (state == ItemEvent.SELECTED) {
                String itemStr = itemEvent.getItem().toString();
//                System.out.println("Item: " + itemStr);
//                System.out.println(itemEvent.getStateChange());
                Controller.getInstance().setFilteredBy(itemStr);
            }
        }
    }
    public class MyTableModelListener implements TableModelListener{
        public void tableChanged(TableModelEvent e) {
            System.out.println("Table changed"+e);
        }
    }
}
