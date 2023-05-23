package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMAsTree
{
    private File file;
    private DocumentBuilder dBuilder;
    private Document doc;


    public DOMAsTree(String f) throws ParserConfigurationException
    {
        file = new File(f);
        dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    public void parse() throws IOException, SAXException
    {
        doc = dBuilder.parse(file);
        System.out.println(file);
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        if (doc.hasChildNodes())
        {
            printNode(doc.getChildNodes());
        }
    }
    
    private static void printNode(NodeList nodeList)
    {
        for (int count = 0; count < nodeList.getLength(); count++)
        {
            Node tempNode = nodeList.item(count);
            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE)
            {

                // get node name and value
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + tempNode.getTextContent());

                if (tempNode.hasAttributes())
                {
                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++)
                    {
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
                    }
                }

                if (tempNode.hasChildNodes())
                {
                    // loop again if has child nodes
                    printNode(tempNode.getChildNodes());
                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
            }
        }

    } // printnote

} // class DOMParser