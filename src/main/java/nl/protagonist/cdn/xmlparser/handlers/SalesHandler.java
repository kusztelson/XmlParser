package nl.protagonist.cdn.xmlparser.handlers;

import nl.protagonist.cdn.xmlparser.logic.IHandlerLogic;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SalesHandler extends DefaultHandler {
    private final StringBuilder _currentValue = new StringBuilder();
    IHandlerLogic _logic;

    public SalesHandler(IHandlerLogic _logic) {
        this._logic = _logic;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        _currentValue.setLength(0);

        if(qName.equalsIgnoreCase(_logic.getStartElementTag())) {
            String attribute = attributes.getValue(_logic.getAttribute());
            _logic.compareAttribute(attribute);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(_logic.getEndElementTag())) {
            if(_logic.isAttributeMatching()) {
                _logic.processCurrentValue(_currentValue.toString());
                _logic.setAttributeMatching(false);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        _currentValue.append(ch, start, length);
    }
}
