package tSmirnova_hW_auto01.Parsers_all;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaxParser {

    private static ArrayList<Medic> medics = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XmlHandler handler = new XmlHandler();
        parser.parse(new File("Medic.xml"), handler);

        for (Medic medic : medics) {
            System.out.println(String.format("Medic department: %s, Medic position: %s, Medic surname: %s, Medic name: %s, Medic middlename: %s, Medic workExperience: %s",
                    medic.getDepartment(), medic.getPosition(), medic.getSurname(), medic.getName(), medic.getMiddlename(), medic.getWorkExperience()));
        }
    }

    private static class XmlHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("medic")) {
                String department = attributes.getValue("department");
                String position = attributes.getValue("position");
                String surname = attributes.getValue("surname");
                String name = attributes.getValue("name");
                String middlename = attributes.getValue("middlename");
                String workExperience = attributes.getValue("workExperience");
                medics.add(new Medic(department, position, surname, name, middlename, workExperience));
            }
        }
    }
}