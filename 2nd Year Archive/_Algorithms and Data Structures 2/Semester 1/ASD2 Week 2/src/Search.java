public class Search
{
    public int LinearSearch(int[] data, int toFind)
    {
        if (!isSorted(data)) return -1;

        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == toFind) return i;
        }

        return -1;
    }

    public int BinarySearch(int[] data, int toFind)
    {
        if (!isSorted(data)) return -1;

        int min = 0, max = data.length, lookAt = -1;
        boolean found = false;

        while(!found)
        {
            lookAt = (min + max) / 2;
            System.out.println(lookAt);

            if      (data[lookAt] < toFind) { min = lookAt; }
            else if (data[lookAt] > toFind) { max = lookAt; }
            else                            { found = true; }
        }

        return found ? lookAt : -1;
    }

    private boolean isSorted(int[] data)
    {
        for (int i = 1; i < data.length; i++)
        {
            if (data[i] < data[i-1]) return false;
        }
        return true;
    }
}
