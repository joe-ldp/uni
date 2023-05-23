import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class GeneticAlgo {
	
	static double [][] dataset;
	static double finalFitness = 0;
	
	class Individual {
		public ArrayList<Integer> chromosome = new ArrayList<Integer>();
		double fitness;
		
		public Individual(int n) {
			
			Set<Integer> chromosome = new LinkedHashSet<Integer>();//we use set to get unique number within the range
			
			Random r = new Random();
			
			while(chromosome.size()<n) {
				chromosome.add(r.nextInt(n));
			}
			
			this.chromosome = new ArrayList<Integer>(chromosome); //convert set into arrayList
			setFitness();
		}
		
		public void setFitness () {
			
			double res = 0;
			int size = chromosome.size();
			
			for(int i=0; i<size-1; i++) {
				int from = chromosome.get(i);
				int to = chromosome.get(i+1);
				
				//System.out.println(from+" "+to);
				//System.out.println(dataset[from][to]);
				
				res += dataset[from][to];
			}
			//System.out.println(ind.chromosome.get(size-1)+" "+ind.chromosome.get(0));
			res+= dataset[chromosome.get(size-1)][chromosome.get(0)]; //x[n][0] - return to the origin
			//System.out.println(res);
				
			this.fitness = res;
			
		}
		
		public Individual copyGenes(Individual ind) {
			
			Individual res = new Individual(ind.chromosome.size());
			
			for (int i=0; i<ind.chromosome.size(); i++) {
				res.chromosome.set(i, ind.chromosome.get(i));
			}
			
			return res;
		}
		
		public void printChromosome () {
			
			System.out.print(chromosome+" "+fitness);
		
		}
		
	}

	class Population{
		
		public ArrayList<Individual> population = new ArrayList<Individual>();
		
		public Population (int popSize, int chromosomeSize) {
		
			for (int i=0; i<popSize; i++) {
				Individual ind = new Individual(chromosomeSize);
				this.population.add(ind);
			}
		}
		
		public void printPop() {
			
			for (int i=0; i<population.size(); i++) {
				System.out.print(population.get(i).chromosome+"\t");
				System.out.println(population.get(i).fitness);
			}
		}
		
		public Individual crossOver (Individual p1, double rate) {
			
			//Declare a chromosome variable (use Set<Integer>,  new LinkedHashSet<Integer>)
			//p1 = [1,2,3,4,5,6];
			//p2 = [6,2,4,5,3,1];
			
			//c1 = [1,2,3,5,3,1];
			//c2 = [6,2,4,4,5,6];
			
			Set<Integer> chromosome = new LinkedHashSet<Integer>();
			
			//Declare the result variable (should be Individual type), the res size should be the parent's size
			Individual res = new Individual(p1.chromosome.size());
			
			//Get the crossover point. Use the rate. Value of crossover point should be int
			int point = (int)(p1.chromosome.size()*rate);

		
			//A for loop to copy the genetic from the parent up to the crossover point
			for (int i = 0; i < point; i++) {
				chromosome.add(p1.chromosome.get(i));
			}

			
			//Now to get the remaining genes by random. Use while loop to get the remaining genes
			Random r = new Random();
			//c = [1,4,3,]
			
			while (chromosome.size() < p1.chromosome.size()) {
				chromosome.add(r.nextInt(p1.chromosome.size())); // 5 {1,4,3,xx,xx}
			}

			
			
			//Since our chromosome in Individual class is ArrayList, convert the Set variable into ArrayList
			res.chromosome = new ArrayList<Integer>(chromosome);
			
			
			return res;
		}
		
		public Individual mutate (Individual p1) {
			
			//Copy the genetic from p1 to our initial result
			Individual res = p1.copyGenes(p1);
			
			//now we mutate the genes, using small change (swap genes by random)
			//p1 = [1,2,3,4,5,6]
			Random r = new Random();
			int i = r.nextInt(p1.chromosome.size());
			int j;
			
			
			//Use a while loop to regenerate random j to avoid getting the same gene. WARNING : This is not application is the remaining genes is only 1
			do {
				j = r.nextInt(p1.chromosome.size());
			} while (i == j);
			
			//Swap the value between i and j for our mutate chromosome
			res.chromosome.set(i,  p1.chromosome.get(j));
			res.chromosome.set(j,  p1.chromosome.get(i));
			
			return res;
		}
	}
	
	public static void runGA() {
		
		//create a population object and parameters
		GeneticAlgo ga = new GeneticAlgo();
		int numGeneration = 10;
		int popSize = 10;
		double crossOverRate = 0.5;
		
		//prepare dataset
		dataset = Data.readFile("C:\\Users\\joeki\\OneDrive - Sheffield Hallam University\\Algorithms and Data Structures\\Week 10 Heuristic Search\\Tutorial10_TSP_GeneticAlgorithm\\Data\\data10.csv");
		int chromosomeSize = dataset.length;
		
		//initialise the population
		Population pop = ga.new Population(popSize, chromosomeSize);
		
		//We sort the candidates by fitness in ascending order, the least the better in this example (TSP)
		Collections.sort(pop.population, new CompareFitness());
		System.out.println("=======Population Before Search=======");
		pop.printPop();
		
		
		//Find solution in the generations
		for (int gen=0; gen<numGeneration; gen++) {
			
			System.out.println("\nGeneration : "+gen);
			
			//get the parents - top 2 from the list
			Individual p1 = pop.population.get(0);
			Individual p2 = pop.population.get(1);
			
			
			//get 2 new children
			Individual ch1 = pop.crossOver(p1, crossOverRate);
			Individual ch2 = pop.crossOver(p2, crossOverRate);
			
			System.out.println("\nChild 1: ");
			ch1.printChromosome();
			
			System.out.println("\nChild 2: ");
			ch2.printChromosome();
			
			//get a mutate child
			Individual ch3 = pop.mutate(p1);
			System.out.println("\nChild 3: ");
			ch3.printChromosome();
			
			//add these new children to the population
			pop.population.add(ch1);
			pop.population.add(ch2);
			pop.population.add(ch3);
			
			//sort them
			Collections.sort(pop.population, new CompareFitness());			
			
			//remove the weak candidate
			pop.population.remove(pop.population.size() - 1);
		}
		
		System.out.println("\n\n====Result====");
		pop.printPop();
		
		finalFitness = pop.population.get(0).fitness;
		
		//Write the result into a csv file
		
		
	
	}
	
	public static double calFitness (ArrayList<Integer> x) {
		double res = 0;
		int size = x.size();
		
		for(int i=0; i<size-1; i++) {
			int from = x.get(i);
			int to = x.get(i+1);
			
			//System.out.println(from+" "+to);
			//System.out.println(dataset[from][to]);
			
			res += dataset[from][to];
		}
		//System.out.println(ind.chromosome.get(size-1)+" "+ind.chromosome.get(0));
		res+= dataset[x.get(size-1)][x.get(0)]; //x[n][0] - return to the origin
		//System.out.println(res);
			
		return res;
	}

	public static void main(String[] args) {
		
		runGA();
		
		double [][] mst = MST.PrimsMST(dataset);
		System.out.println("\nMST fitness : "+MST.getMstValue(mst));
		
		double resultQuality = (MST.getMstValue(mst)/finalFitness)*100;
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println("The result is close "+df.format(resultQuality)+"% to MST cost");
		
		for (int i = 0; i < 10; i++) {
			runGA();
		}
	}

}