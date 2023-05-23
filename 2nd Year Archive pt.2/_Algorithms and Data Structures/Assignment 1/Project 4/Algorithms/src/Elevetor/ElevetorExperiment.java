package Elevetor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ElevetorExperiment {
	
	static int currentLevel = 5;
	static int elevatorWaitTime = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*LinkedList<Integer> levelList = new LinkedList<Integer>();
		levelList.add(3);
		levelList.add(4);
		levelList.add(6);
		levelList.add(8);
		levelList.add(9);
		
		System.out.println("The elevator will go to these floors : "+levelList);
		try {
			//FIFO(levelList);
			Algo_Joe(levelList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//runCsvLevelList("C:\\Users\\joeki\\OneDrive - Sheffield Hallam University\\Algorithms and Data Structures\\Assignment 1\\Project 4\\Datasets\\n5v0.csv");
		
		experiment(5, 10);
	}
	
	public static void experiment(int n, int numExperiments) {
		String basePath = "C:\\Users\\joeki\\OneDrive - Sheffield Hallam University\\Algorithms and Data Structures\\Assignment 1\\Project 4\\Datasets\\n"+n+"v";
		double totalRuntime = 0, avgRuntime, minRuntime = Double.MAX_VALUE;
		for (int i = 0; i < numExperiments; i++) {
			double runtime = runCsvLevelList(basePath+i+".csv");
			totalRuntime += runtime;
			if (runtime < minRuntime) minRuntime = runtime;
		}
		avgRuntime = totalRuntime / numExperiments;
		System.out.println("Total runtime: "+totalRuntime+" | Average runtime: "+avgRuntime+" | Minimum runtime: "+minRuntime);
	}
	
	public static double runCsvLevelList(String path) {
		LinkedList<Integer> levelList = loadLevelList(path);
		
		double runtime = -1;
		
		System.out.println("The elevator will go to these floors: "+levelList);
		try {
			runtime = Algo_Joe(levelList);
			//runtime = FIFO(levelList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return runtime;
	}
	
	public static LinkedList<Integer> loadLevelList(String path) {
		LinkedList<Integer> levelList = new LinkedList<Integer>();
		
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while ((line=br.readLine())!=null) {
				String colData [] = line.split(",");
				for (int i=0; i<colData.length; i++) {
					levelList.push(Integer.parseInt(colData[i]));
				}
			}
			br.close();
			fr.close();
		}
		catch (Exception e) {
			System.err.println("Error in reading the file");
		}
		
		return levelList;
	}
	
	public static double Algo_Joe(LinkedList<Integer> floors) throws InterruptedException {
		elevatorWaitTime = 0;
		System.out.println("The current floor is: "+currentLevel);
		long timeStart = System.currentTimeMillis();
		
		int target = floors.getFirst();
		while (!floors.isEmpty()/* || currentLevel != 5*/) {
			moveElevator(target-currentLevel);
			if (floors.contains(currentLevel)) {
				System.out.println("\nStopping and opening doors at level: " + currentLevel);
				floors.removeFirstOccurrence(currentLevel);
				target = !floors.isEmpty() ? floors.getFirst() : 5;
				//Thread.sleep(2000);
				elevatorWaitTime += 2000;
			}
		}
		
		long endtime = System.currentTimeMillis();
		double time = (endtime-timeStart+elevatorWaitTime)/1000;
		System.out.println("Duration: "+time+ " seconds");
		return time;
	}
	
	public static void moveElevator(int direction) throws InterruptedException {
		//Thread.sleep(1000);
		elevatorWaitTime += 1000;
		currentLevel += (direction > 0 ? 1 : -1);
		System.out.println("\nElevator arriving at level: " + currentLevel);
	}
	
	public static double FIFO (LinkedList<Integer> floors) throws InterruptedException {
		elevatorWaitTime = 0;
		System.out.println("The current floor is : "+currentLevel);
		long timeStart = System.currentTimeMillis();
		while(!floors.isEmpty()) {
			
			int l = floors.getFirst();
			
			while(l>currentLevel) {
				String string = String.format("%s", currentLevel);
				System.out.print(string);
			
					//Thread.sleep(1000);
					elevatorWaitTime += 1000;
			
					currentLevel++;
			}
			
			while(l<currentLevel) {
				String string = String.format("%s", currentLevel);
				System.out.print(string);
				//Thread.sleep(1000);
				elevatorWaitTime += 1000;
				currentLevel--;
			}
			System.out.println("\nYou have arrived level "+currentLevel);
			floors.removeFirst();
			//Thread.sleep(2000);
			elevatorWaitTime += 2000;
		}
		
		long endtime = System.currentTimeMillis();
		double time = (endtime-timeStart+elevatorWaitTime)/1000;
		System.out.println("Duration : "+time+ " seconds");
		return time;
	}

}