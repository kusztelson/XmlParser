package nl.protagonist.cdn.xmlparser.logic;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ClientAmountLogic implements IHandlerLogic<BigDecimal> {
    private final String ATTRIBUTE = "id";
    private final String ATTRIBUTE_TAG = "client";
    private final String VALUE_TAG = "amount";

    private final String _attributeToCompare;
    private BigDecimal _processedValue = new BigDecimal(BigInteger.ZERO);
    private boolean _attributeMatching = false;

    public ClientAmountLogic(String _attributeToCompare) {
        this._attributeToCompare = _attributeToCompare;
    }

    @Override
    public void processCurrentValue(String currentValue) {
        _processedValue = _processedValue.add(new BigDecimal(currentValue));
    }

    @Override
    public String getStartElementTag() {
        return ATTRIBUTE_TAG;
    }

    @Override
    public String getAttribute() {
        return ATTRIBUTE;
    }

    @Override
    public boolean compareAttribute(String attribute) {
        _attributeMatching = _attributeToCompare.equals(attribute);
        return _attributeMatching;
    }

    @Override
    public boolean isAttributeMatching() {
        return _attributeMatching;
    }

    @Override
    public String getEndElementTag() {
        return VALUE_TAG;
    }

    @Override
    public void setAttributeMatching(boolean matching) {
        _attributeMatching = false;
    }

    @Override
    public BigDecimal getProcessedValue() {
        return _processedValue;
    }
}
