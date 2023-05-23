import java.util.Arrays;

public class ADS2List
{
    private static final int init_size = 10;
    private int size;
    private User[] elements;

    public ADS2List()
    {
        size = 0;
        elements = new User[init_size];
    }

    public void add(User i)
    {
        if (size == elements.length)
        {
            expand();
        }
        elements[size++] = i;
    }

    public void remove(int index)
    {
        if (index == size) size--;
        for (int i = index; i < size; i++)
        {
            elements[i] = elements[i+1];
        }
    }

    public User get(int index)
    {
        return elements[index];
    }

    public void sort()
    {
        Arrays.sort(elements);
    }

    public int search(String name)
    {
//        int start = 0;
//        int mid = size / 2;
//        int end = size;
//
//        while (start <= end)
//        {
//            if (elements[mid].getUserName() == name)
//            {
//                return elements[mid];
//            }
//            else
//            {
//
//            }
//        }

        for (int i = 0; i < size; i++)
        {
            if (elements[i].getUserName().equals(name)) return i;
        }
        return -1; // TO-DO: Implement binary search for name
    }

    private void expand()
    {
        elements = Arrays.copyOf(elements, size * 2);
    }
}