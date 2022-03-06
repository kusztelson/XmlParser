package nl.protagonist.cdn.xmlparser;

import nl.protagonist.cdn.xmlparser.handlers.SalesHandler;
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

            SalesHandler handler = new SalesHandler();
            saxParser.parse(FILENAME, handler);

            System.out.println(handler.runningSum);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
