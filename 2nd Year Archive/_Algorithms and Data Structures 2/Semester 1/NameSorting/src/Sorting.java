import java.util.Arrays;

//Since we are comparing strings, you need to use StringA.compareToIgnoreCase(StringB)
//to sort items under alphabetical order
public class Sorting {
    //Create a sorting algorithm using Insertion Sort
    public static void InsertionSort(String[] data)
    {

    }

    //Create a sorting algorithm using Merge Sort
    public static void MergeSort(String[] data)
    {
        System.out.println(data);

        MergeSortDivCon(data, 0, data.length);

        System.out.println(data);
    }

    public static void MergeSortDivCon(String[] data, int left, int right)
    {
        if (left >= right) return;

        int middle = (left + right) / 2;

        MergeSortDivCon(data, left, middle);
        MergeSortDivCon(data, middle + 1, right);

        Merge(data, left, middle, right);
    }

    public static void Merge(String[] data, int left, int mid, int right)
    {
        int n1 = mid - left;
        int n2 = right - mid;

        String[] d1 = Arrays.copyOfRange(data, left, mid+1);
        String[] d2 = Arrays.copyOfRange(data, mid+1, right+1);

        n1 = d1.length;
        n2 = d2.length;

        int i = 0, j = 0, k = 1;
        String smaller;

        while (i < n1 && j < n2)
        {
            if (d1[i].compareTo(d2[j]) == 0)
            {
                smaller = d1[i++];
            }
            else
            {
                smaller = d2[j++];
            }

            data[k++] = smaller;
        }
    }

    //Create a sorting algorithm using Quick Sort
    public static void QuickSort(String[] data)
    {

    }


    //Create some other private helper functions.
    //Create some other private helper functions.
    private static void Swap(String[] data, int i, int j)
    {
        String temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //Heap Sort algorithm
    public static void HeapSort(String[] data)
    {
        //Make the the entire tree become max heap
        for (int i = data.length/2-1; i >= 0; i--)
            Heapify(data, i, data.length);//Build the heap

        //In place
        for (int i = data.length-1; i >= 0; i--)
        {
            Swap(data,0,i);
            Heapify(data,0,i);//Maintain the down heap algorithm
        }
    }

    private static void Heapify(String[] data, int idx, int range)
    {
        //Initial the tracker
        int larger = idx;
        int lChildIdx = 2*idx+1;
        int rChildIdx = lChildIdx+1;

        //Find the largest node
        if (lChildIdx < range && data[larger].compareTo(data[lChildIdx])<=0)
            larger = lChildIdx;
        if (rChildIdx < range && data[larger].compareTo(data[rChildIdx])<=0)
            larger = rChildIdx;

        //Swap the root with the children if needed
        if (idx != larger)
        {
            //then we do the swap
            Swap(data, idx, larger);
            Heapify(data,larger,range);
        }
    }
}
