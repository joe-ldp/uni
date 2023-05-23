package saxparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SaxParsing {

    SAXParser parser;
    private final String filename = "saxparsing/recipe.xml";

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
    boolean inStruction = false;
    Map tags;
    final static StringBuilder builder = new StringBuilder();

    @Override
    public void startElement(String uri, String localname, String qname, Attributes attributes) {

        String key = localname;
        Object value = tags.get(key);

        if (value != null) {
            int count = ((Integer)value).intValue();
            count++;
            tags.put(key, new Integer(count));
        } else {
            tags.put(key, new Integer(1));
        }

        if(localname.equalsIgnoreCase("instruction"))
             inStruction = true;
    }


    @Override
    public void endElement(String uri, String localname, String qname) {
    }


    @Override
    public void startDocument() throws SAXException {
        tags = new HashMap();
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
        if (inStruction) {
            String inst = new String(text, start, length);
            System.out.println(length +": "+ inst);
            inStruction = false;
        }
    }

} // class ElementContentHandler