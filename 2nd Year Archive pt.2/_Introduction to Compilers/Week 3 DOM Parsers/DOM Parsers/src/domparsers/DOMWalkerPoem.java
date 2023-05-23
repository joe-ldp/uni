package domparsers;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class DOMWalkerPoem {
    public static void main(String argv[]) {
        try {
            File fXmlFile = new File("./poem.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            printElementsOfType(doc, "author");
            printElementsOfType(doc, "stanza");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main

    private static void printElementsOfType(Document doc, String type) {
        NodeList nList = doc.getElementsByTagName(type);

        for (int i=0; i<nList.getLength(); i++) {
            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element is type: "+ eElement.getNodeType());

                Node child = eElement.getFirstChild();
                System.out.println("Child is type: "+ child.getNodeType());
                System.out.println(child.getTextContent());
            } // if
        } // for
    }
} // class DOMWalkerPoem