package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomToList
{
    private File file;
    private DocumentBuilder dBuilder;
    private Document doc;

    public DomToList(String file) throws ParserConfigurationException
    {
        this.file = new File(file);
        dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    }

    public void parse() throws IOException, SAXException
    {
        doc = dBuilder.parse(file);
    }

    public void walk() throws Exception
    {
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("stanza");

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) nNode;
                System.out.println("Element is type: "+ eElement.getNodeType());

                Node child = eElement.getFirstChild();
                System.out.println("Child is type: "+ child.getNodeType());
                System.out.println(child.getTextContent());
            }
        }
    }
}