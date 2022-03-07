# XmlParser

This is a sample program for memory efficient xml parsing. It uses SAX library which reads documents sequentially unlike DOM parser which stores the whole document in the memory.

## Resources used
[mykong](https://www.baeldung.com/java-sax-parser)

[baeldung](https://www.baeldung.com/java-sax-parser)

## Possible improvements
If the program was to support multiple operations on such files introduction of [strategy](https://refactoring.guru/design-patterns/strategy) design pattern may be useful.
One obstacle it a need to store state of the amout sum between:
https://github.com/kusztelson/XmlParser/blob/2d6e533ceb534e6b589f0f3ef2c812bca5e28bf6/src/main/java/nl/protagonist/cdn/xmlparser/handlers/SalesHandler.java#L17
and
https://github.com/kusztelson/XmlParser/blob/2d6e533ceb534e6b589f0f3ef2c812bca5e28bf6/src/main/java/nl/protagonist/cdn/xmlparser/handlers/SalesHandler.java#L28
which cannot be simply achieved and abstracted out with this pattern.
