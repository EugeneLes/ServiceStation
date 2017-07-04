package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Eugene on 04.07.2017.
 */
public class CustomerTableModel implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    List<Customer> customers;
    public CustomerTableModel(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Surname";
            case 3:
                return "Middle name";
            case 4:
                return "Last order date";
            case 5:
                return "Date of birth";
            case 6:
                return "Cars";
            case 7:
                return "Discount";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 1:
            case 2:
            case 3:
                return String.class;
            case 4:
                return Date.class;
            case 5:
                return Date.class;
            case 6:
                return ArrayList.class;
            case 7:
                return boolean.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = customers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getId();
            case 1:
                return customer.getName();
            case 2:
                return customer.getSurname();
            case 3:
                return customer.getMiddle_name();
            case 4:
                return customer.getLastOrder();
            case 5:
                return customer.getDateOfBirth();
            case 6:
                return customer.getCar();
            case 7:
                return customer.isDiscount();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }
}
