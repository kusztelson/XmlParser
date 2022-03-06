package nl.protagonist.cdn.xmlparser.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SalesHandler extends DefaultHandler {
    private boolean clientFlag = false;
    private StringBuilder currentValue = new StringBuilder();
    public BigDecimal runningSum = new BigDecimal(BigInteger.ZERO);

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        currentValue.setLength(0);

        if(qName.equalsIgnoreCase("client")) {
            String id = attributes.getValue("id");
            if("128".equals(id)) {
                clientFlag = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("amount")) {
            if(clientFlag) {
                BigDecimal temp = new BigDecimal(currentValue.toString());
                runningSum = runningSum.add(temp);
                clientFlag = false;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }
}
