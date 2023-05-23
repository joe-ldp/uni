public class ADS2Vector
{
    /* STEP 1: Think about the following questions...
     *  1. what data type do you need to store? (we use int)
     *  2. what basic data structure do you need to build a vector (we will use array)
     *  3. what other variables you need to build a vector
     */

    //The ADS2Vector "global" variables/objects goes here. Make them "private", users do not need to visit them.
    int[] container;
    int length;


    /* STEP 2: This is your default constructor - initialise your "global" object variables
     * to sensible values for a generic vector object.
     */
    public ADS2Vector()
    {
        container = new int[1];
        length = 0;
    }

    public ADS2Vector(int initialSize)
    {
        container = new int[initialSize];
        length = 0;
    }

    /* STEP 3: Adds value to the end of the data structure
     * You need to check if the vector needs to grow or not
     */
    public void Append(int value)
    {
        if (length >= container.length)
        {
            int[] extended = new int[container.length * 2];

            for (int i = 0; i < container.length; i++)
            {
                extended[i] = container[i];
            }
            container = extended;
        }

        container[length++] = value;
    }


    /* STEP 4: Returns the current capacity of the vector before it will need to resize again */
    public int GetCapacity()
    {
        return container.length;
    }


    /* STEP 5: Returns the number of items in the vector */
    public int GetNoOfItems()
    {
        return length;
    }


    /* STEP 6: Returns the customer data held at index (base zero) */
    public int GetItem(int index)
    {
        return container[index];
    }


    /* STEP 7: Using Linear Search, returns the index of the item. Return -1 if the item is not in the vector*/
    public int Find(int value)
    {
        //if (!isSorted(container)) return -1;

        int min = 0, max = container.length, lookAt = -1;
        boolean found = false;

        while(!found)
        {
            lookAt = (min + max) / 2;
            //System.out.println(lookAt);

            if      (container[lookAt] < value) { min = lookAt; }
            else if (container[lookAt] > value) { max = lookAt; }
            else                                { found = true; }
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

    /* STEP 8: Inserts value into the data structure at index (base zero) or at the end
     * if there are less items in the data structure than index.
     * Warning: You need to check if the vector needs to grow or not before insert the value
     */
    public void InsertItem(int index, int value)
    {
        if (index > length)
        {
            Append(value);
            return;
        }
        else
        {
            int[] temp = new int[(length - index)];
            for (int i = index; i < length; i++)
            {
                temp[i-index] = container[i];
            }
            length = index;

            Append(value);
            for (int i : temp)
            {
                Append(i);
            }
        }

    }


    /* STEP 9: Removes the item at index from the data structure - if index is out of
     * bounds then the data structure remains unchanged
     * You do not need to reduce the size of the vector during this operation
     */
    public void DeleteItem(int index)
    {
        for (int i = index + 1; i < container.length; i++)
        {
            container[i-1] = container[i];
        }
        container[container.length] = 0;
    }
}
