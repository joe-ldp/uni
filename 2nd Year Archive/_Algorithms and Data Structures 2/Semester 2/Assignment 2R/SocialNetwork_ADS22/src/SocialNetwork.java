/**
 * You can also develop help functions and new classes for your system. You
 * can change the skeleton code if you need but you do not allow to remove the
 * methods provided in this class.
 */
public class SocialNetwork {
    private ADS2Graph userNetwork;//You may use different container for the social network data
    private ADS2List userNames;//You may use different container for the user name list

    public SocialNetwork(){

    }

    /**
     * Loading social network data from files.
     * The dataset contains two separate files for user names (NameList.csv) and
     * the network distributions (SocialNetworkData.csv).
     * Use file I/O functions to load the data.You need to choose suitable data
     * structure and algorithms for an effective loading function
     */
    public void Load(){

    }

    /**
     * Locating a user from the network
     * @param fullName users full name as a String
     * @return return the ID based on the user list. return -1 if the user do not exist
     * based on your algorithm, you may also need to locate the reference
     * of the node from the graph.
     */
    public int FindUserID(String fullName){
        return -1;
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
    public String[] GetMyFriends(String currentUserName){
        String[] myFriends = {"Dummy 1","Dummy 2","Dummy 3","Dummy 4","Dummy 5"};//TO Be replaced by the requested algorithm
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
