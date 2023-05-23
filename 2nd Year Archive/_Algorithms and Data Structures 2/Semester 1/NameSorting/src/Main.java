import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("NameList.csv"))) {

            scanner.useDelimiter("\r\n");
            String[] fullNames =  new String[10000];//There are 10000 names in the csv file
            int i=0;
            while(scanner.hasNext()){
                String[] currentLine = scanner.next().split("_");
                fullNames[i++]=currentLine[0].replaceAll("\"","");
            }
            System.out.println("There are "+i+" names in the list");


            long millis_start = System.currentTimeMillis();


            ////////////////////////////////////
            //Put your sorting algorithms here//
            ////////////////////////////////////

            //Sorting.MergeSort(fullNames);




            long millis_end = System.currentTimeMillis();
            long timeConsumption = millis_end-millis_start;
            System.out.println("The sorting time consumption:"+ timeConsumption+" ms");


        }
        catch (FileNotFoundException e){
            System.err.println("File error");
        }
    }
}
