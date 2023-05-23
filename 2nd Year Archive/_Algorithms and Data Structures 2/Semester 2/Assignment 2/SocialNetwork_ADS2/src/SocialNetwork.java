import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You can also develop help functions and new classes for your system. You
 * can change the skeleton code if you need but you do not allow to remove the
 * methods provided in this class.
 */
public class SocialNetwork
{
    private final ADS2Graph userNetwork; //You may use different container for the social network data
    private final ADS2List userNames; //You may use different container for the user name list

    public SocialNetwork()
    {
        userNames = new ADS2List();
        userNetwork = new ADS2Graph();
    }

    /**
     * Loading social network data from files.
     * The dataset contains two separate files for user names (NameList.csv) and
     * the network distributions (SocialNetworkData.csv).
     * Use file I/O functions to load the data.You need to choose suitable data
     * structure and algorithms for an effective loading function
     */
    public void Load()
    {
        try (Scanner scanner = new Scanner(new File("NameList.csv")))
        {
            scanner.useDelimiter("\r\n");

            int currentID = 1;
            while(scanner.hasNext())
            {
                String currentLine = scanner.next();
                String currentName = currentLine;

                //System.out.println("Loading..."+currentID+"\t"+currentName);

                User newUser = new User(currentID, currentName);
                userNames.add(newUser);
                userNetwork.addNode(new Node(currentID));
                currentID++;
            }
            System.out.println("Loaded name list");
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getLocalizedMessage());
        }

        try (Scanner scanner = new Scanner(new File("SocialNetworkData.csv")))
        {
            scanner.useDelimiter("\r\n");

            while(scanner.hasNext())
            {
                String[] currentLine = scanner.next().split(",");
                int sourceUser = Integer.parseInt(currentLine[0]);
                int toUser = Integer.parseInt(currentLine[1]);
                float weight = Float.parseFloat(currentLine[2]);
                userNetwork.addNodeEdge(sourceUser, new Edge(userNetwork.getNode(toUser), weight));
                userNetwork.addNodeEdge(toUser, new Edge(userNetwork.getNode(sourceUser), weight));

                //System.out.println("Loading..."+sourceUser+"\t"+toUser+"\t"+weight);
            }
            System.out.println("Loaded social network data");
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getLocalizedMessage());
        }
    }

    /**
     * Locating a user from the network
     * @param fullName users full name as a String
     * @return return the ID based on the user list. return -1 if the user do not exist
     * based on your algorithm, you may also need to locate the reference
     * of the node from the graph.
     */
    public int FindUserID(String fullName){
        return userNames.search(fullName);
    }


    /**
     * Listing ALL the friends belongs to the user
     * You need to retrieval all the directly linked nodes and return their full names.
     * Current Skeleton only have some dummy data. You need to replace the output
     * by using your own algorithms.
     * @param currentUserName use FindUserID or other help functions to locate
     * the user in the graph first.
     * @return You need to return all the user names in a String Array directly
     * linked to the users node.
     */
    public String[] GetMyFriends(String currentUserName) {
        Node n = userNetwork.getNode(userNames.search(currentUserName));
        String[] myFriends = new String[n.getEdges().size()/2];
        for (int i = 0; i < myFriends.length; i++) {
            String thisName = userNames.get(n.getEdges().get(i).getNodeTo().getUserID()).getUserName();
            if (!Arrays.stream(myFriends).anyMatch(x->x==thisName)) myFriends[i] = thisName;
        }

        return myFriends;
    }

    /**
     * Listing the top 10 recommended friends for the user
     * In the task, you need to calculate the shortest distance between the
     * current user and all other non-directly linked users. Pick up the top three
     * closest candidates and return their full names.
     * Use some help functions for sorting and shortest distance algorithms
     * @param currentUserName use FindUserID or other help functions to locate
     * the user in the graph first.
     * @return You need to return all the user names in a String Array containing
     * top 3 closest candidates.
     */
    public String[] GetRecommended (String currentUserName){
        String[] recommended = {"Dummy X","Dummy Y","Dummy Z"};//TO Be replaced by the requested algorithm
        return recommended;
    }
}
