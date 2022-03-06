package nl.protagonist.cdn.xmlparser.logic;

public interface IHandlerLogic<T> {
    String getStartElementTag();
    String getAttribute();
    boolean compareAttribute(String attribute);
    boolean isAttributeMatching();
    String getEndElementTag();
    void setAttributeMatching(boolean matching);
    void processCurrentValue(String currentValue);
    T getProcessedValue();

}
