package saxparsing;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParsing {

    SAXParser parser;
    private final String filename = "weather.xml";

    public static void main(String[] args) {
        try {
            SaxParsing sp = new SaxParsing();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    } // main

    SaxParsing() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(true);
        parserFactory.setNamespaceAware(true);

        parser = parserFactory.newSAXParser();

        ElementContentHandler handler = new ElementContentHandler();

        parser.parse(new File(filename), handler);

    } // constructor
} // class SaxParsing

class ElementContentHandler extends DefaultHandler {
    boolean instruction = false;
    Map<String, Integer> tags;
    final static StringBuilder builder = new StringBuilder();

    @Override
    public void startElement(String uri, String localname, String qname, Attributes attributes) {

        String key = localname;
        Object value = tags.get(key);
        
        if (value != null) {
            int count = ((Integer)value).intValue();
            count++;
            tags.put(key, Integer.valueOf(count));
        } else {
            tags.put(key, Integer.valueOf(1));
        }

        if(localname.equalsIgnoreCase("instruction"))
            instruction = true;
    }

    @Override
    public void endElement(String uri, String localname, String qname) {
        if(!localname.equalsIgnoreCase("instruction"))
            instruction = false;
    }

    @Override
    public void startDocument() throws SAXException {
        tags = new HashMap<String, Integer>();
    }

    @Override
    public void endDocument() throws SAXException {
        Set<String> keys = tags.keySet();

        for(String k : keys) {
            int count = ((Integer)tags.get(k)).intValue();
            System.out.println("Local Name \"" + k + "\" occurs "+ count + " times");
        }
    }

    @Override
    public void characters(char[] text, int start, int length) {
        if (instruction) {
            String inst = new String(text, start, length);
            System.out.println(length +": "+ inst);
            instruction = false;
        }
    }
} // class ElementContentHandler