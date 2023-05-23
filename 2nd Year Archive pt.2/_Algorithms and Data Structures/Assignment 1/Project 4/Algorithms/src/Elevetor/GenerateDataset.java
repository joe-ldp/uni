package Elevetor;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Random;

public class GenerateDataset {

	public static void main(String[] args) {
		//double [][] arrayGraph = readCSV();
		
		generateRequests(5);
		generateRequests(10);
		generateRequests(20);
		generateRequests(25);
		generateRequests(30);
		generateRequests(40);
		generateRequests(50);
	}
	
	public static void generateRequests(int n) {
		for (int i = 0; i < 10; i++) {
			int[] d = genData(n);
			printArray(d);
			writeResult(d, i);
		}
	}
	
	public static int[]  genData (int n) {
		Random r = new Random();
		int[] res = new int[n];
		
		for (int i = 0; i < n; i++) {
			int val = r.nextInt(8)+1;
			res[i] = val;
		}
	
		return res;
	}
	
	public static void writeResult(int[] result, int dataset) {
		try {
			
			String fileName = "C:\\Users\\joeki\\OneDrive - Sheffield Hallam University\\Algorithms and Data Structures\\Assignment 1\\Project 4\\Datasets\\n"+result.length+"v"+dataset+".csv";
			
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < result.length; i++) {
				bw.write(Integer.toString(result[i]));
				if (i < result.length-1) bw.write(",");
			}
			bw.newLine();
			bw.close();
			fw.close();
			
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public static void printArray (int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			System.out.print(",");
		}
		System.out.println();
	}
}
