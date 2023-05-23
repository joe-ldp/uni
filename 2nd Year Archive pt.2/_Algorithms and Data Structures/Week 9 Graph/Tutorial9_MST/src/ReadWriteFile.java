import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Iterator;
import java.util.Random;

public class ReadWriteFile {

	public static void main(String[] args) {
		//double [][] arrayGraph = readCSV();
		double[][] d = genData(5);
		printArray(d);

	}
	
	public static double [][]  genData (int n) {
		Random r = new Random();
		DecimalFormat df = new DecimalFormat("#0.00");
		double[][] res = new double[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) res[i][j] = 0;
				else {
					double val = Double.parseDouble(df.format(r.nextDouble() * 100));
					res[i][j] = val;
					res[j][i] = val;
				}
				
			}
		}
	
		return res;
	}
	
	public static void writeResult(double [][] result, int dataset) {
		try {
			
			String fileName = "C:\\Users\\joeki\\OneDrive - Sheffield Hallam University\\Algorithms and Data Structures\\Week 9 Graph\\Tutorial9_MST\\result\\result_"+dataset+".csv";
			
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Iter");
			bw.write(" ");
			bw.write("Runtime");
			bw.newLine();
			
			for (int i = 0; i < result.length; i++) {
				bw.write(Double.toString(result[i][0]));
				bw.write(" ");
				bw.write(Double.toString(result[i][1]));
				bw.newLine();
			}
			
			bw.close();
			fw.close();
			
		} catch(Exception e) {
			System.err.println(e);
		}
		
	}
	
	public static double [][] readCSV () {
		
		String file = "graph.csv";
		double [][] graph = null;
		
		try {
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = null;
			int row=0;
			int col=0;
			
			while((line=br.readLine())!=null) {
				row++;
				String [] rowLine = line.split(",");
				col = rowLine.length;
			}
			
			graph = new double [row][col];
			
			br = new BufferedReader(new FileReader(file));
			int i=0;
			line = null;
			
			while ((line=br.readLine())!=null) {
				
				String colData [] = line.split(",");
				for (int j=0; j<colData.length; j++) {
					graph[i][j]=Double.parseDouble(colData[j]); 
				}
				i++;
			}
			
		}
		catch (Exception e) {
			System.err.println("Error in reading the file");
		}
		
		return graph;	
	}
	
	public static void printArray (double [][] array) {
		
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array.length; j++) {
				System.out.print(array[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	

}
