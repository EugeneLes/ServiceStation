package ModelParser;

import model.Customer;
import model.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by LeskovskijE on 6/28/2017.
 */

//<root>
//        <name>Service station 213</name>
//        <location>Minsk</location>
//        <customers>
//            <id>0</id>
//            <name>Ivan</name>
//            <surname>Ivanov</surname>
//            <middle_name>Ivanovich</middle_name>
//            <lastOrder>2015-09-25</lastOrder>
//            <dateOfBirth>2004-10-25</dateOfBirth>
//            <car>BMW 5</car>
//            <car>Opel</car>
//            <discount>true</discount>
//        </customers>
public class XMLModelParser extends AbstractModelParser {
    @Override
    public Root parse(String path) {
        Document dom = null;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //to look at Singleton Pattern
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(path);
        }catch(Exception e){
            System.out.println("Opening file error "+ e.toString());
            return null;
        }
        Element root = dom.getDocumentElement();    //to look at javax.swing.text.Element
        System.out.println("tag 1 = "+root.getTagName());

        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        System.out.println("tag 2 = "+ nameNode.getNodeName());

        String name = nameNode.getFirstChild().getNodeValue();
        System.out.println("name = "+ name);

        NodeList customerNodeList = root.getElementsByTagName("customers");
        Node customersNode = customerNodeList.item(0);
        System.out.println("tag 3 = " + customersNode.getNodeName());

        NodeList elementsNodeList = customersNode.getChildNodes();

        ArrayList<Customer> listCustomers = new ArrayList<>();

        for (int i = 0; i < elementsNodeList.getLength(); i++) {

            Node node = elementsNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Customer customer = new Customer();

            System.out.println("======================================");

            Element element = (Element) node;
            System.out.println("tag = " + node.getNodeName());

            // id
            NodeList idElemlist = element.getElementsByTagName("id");
            Element idElement = (Element) idElemlist.item(0);
            String idCustomer = idElement.getFirstChild().getNodeValue();
            System.out.println("id : " + idCustomer);

            customer.setId(Integer.valueOf(idCustomer));

            // name
            String nameCustomer = element.getElementsByTagName("surname").item(0).getTextContent();
            System.out.println("name : " + nameCustomer);

            customer.setName(nameCustomer);

            // surname
            String surnameCustomer = element.getElementsByTagName("surname").item(0).getTextContent();
            System.out.println("surname : " + surnameCustomer);

            customer.setSurname(surnameCustomer);

            // middle_name
            String middle_nameCustomer = element.getElementsByTagName("middle_name").item(0).getTextContent();
            System.out.println("middle_name : " + middle_nameCustomer);

            customer.setMiddle_name(middle_nameCustomer);

            // lastOrder
            String lastOrderCustomer = element.getElementsByTagName("lastOrder").item(0).getTextContent();
            System.out.println("lastOrder : " + lastOrderCustomer);

            customer.setLastOrder(Date.valueOf(lastOrderCustomer));

            // dateOfBirth
            String dateOfBirthCustomer = element.getElementsByTagName("dateOfBirth").item(0).getTextContent();
            System.out.println("dateOfBirth : " + dateOfBirthCustomer);

            customer.setDateOfBirth(Date.valueOf(dateOfBirthCustomer));

            // car
            ArrayList<String> carList = new ArrayList<>();
            String carCustomer = "";

            for (int ii = 0; ii< element.getElementsByTagName("car").getLength();ii++){
                carCustomer = element.getElementsByTagName("car").item(ii).getTextContent();
                System.out.println("car : " + carCustomer);
                carList.add(carCustomer);
            }
            customer.setCar(carList);

            // discount
            String discount = element.getElementsByTagName("discount").item(0).getTextContent();
            System.out.println("discount : " + discount);

            customer.setDiscount(Boolean.valueOf(discount));


            listCustomers.add(customer);
        }

        for(Customer e: listCustomers) {

            System.out.println(e.toString());

        }
        return null;
    }
}
