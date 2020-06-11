package tSmirnova_hW_auto01.Parsers_all;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DomParser {
    private static ArrayList<Medic> medics = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("Medic.xml"));

        NodeList medicElements = document.getDocumentElement().getElementsByTagName("medic");

        for (int i = 0; i < medicElements.getLength(); i++) {
            Node medic = medicElements.item(i);
            NamedNodeMap attributes = medic.getAttributes();
            medics.add(new Medic(attributes.getNamedItem("department").getNodeValue(), attributes.getNamedItem("position").getNodeValue(), attributes.getNamedItem("surname").getNodeValue(),
                    attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("middlename").getNodeValue(), attributes.getNamedItem("workExperience").getNodeValue()));
        }

        for (Medic medic : medics) {
            System.out.println(String.format("Medic department: %s, Medic position: %s, Medic surname: %s, Medic name: %s, Medic middlename: %s, Medic workExperience: %s",
                    medic.getDepartment(), medic.getPosition(), medic.getSurname(), medic.getName(), medic.getMiddlename(), medic.getWorkExperience()));
        }
    }
}