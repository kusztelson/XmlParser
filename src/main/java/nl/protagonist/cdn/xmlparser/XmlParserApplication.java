package nl.protagonist.cdn.xmlparser;

import nl.protagonist.cdn.xmlparser.handlers.SalesHandler;
import nl.protagonist.cdn.xmlparser.logic.ClientAmountLogic;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XmlParserApplication {

    private static final String FILENAME = "src/main/resources/big.xml";

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            SAXParser saxParser = factory.newSAXParser();
            ClientAmountLogic clientAmountLogic = new ClientAmountLogic("128");

            SalesHandler handler = new SalesHandler(clientAmountLogic);
            saxParser.parse(FILENAME, handler);

            System.out.println(clientAmountLogic.getProcessedValue());

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}