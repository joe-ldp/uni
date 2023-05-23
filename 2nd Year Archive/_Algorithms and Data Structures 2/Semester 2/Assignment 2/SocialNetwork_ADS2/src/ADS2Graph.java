import java.util.ArrayList;

public class ADS2Graph
{
    private ArrayList<Node> nodes;

    public ADS2Graph() {
        this.nodes = new ArrayList<Node>();
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node)
    {
        nodes.add(node);
    }

    public void addNodeEdge(int nodeUserID, Edge edge)
    {
        Node theNode = null;
        for (Node n : nodes) if (n.getUserID() == nodeUserID) theNode = n;
        theNode.addEdge(edge);
    }

    public Node getNode(int index)
    {
        return nodes.get(index-1);
    }
}

class Node
{
    private int userID;
    private ArrayList<Edge> edges;

    public Node(int userID) {
        this.userID = userID;
        edges = new ArrayList<Edge>();
    }

    public void addEdge(Edge edge)
    {
        edges.add(edge);
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}

class Edge
{
    private Node nodeTo;
    private float weight;

    public Edge(Node nodeTo, float weight) {
        this.nodeTo = nodeTo;
        this.weight = weight;
    }

    public Node getNodeTo() {
        return nodeTo;
    }

    public float getWeight() {
        return weight;
    }
}