import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

//import ScalesProblem.Individual;

public class GeneticAlgo {
	
	static int popSize = 10;
	static int gen = 10;

	public static void main(String[] args) {
		
		ArrayList<Double> data = Data.getData();
		int geneSize=data.size();
		System.out.println(data);

		Population pop = new Population();	
		pop.initialPop(popSize, geneSize);
		
		for (int i = 0; i < gen; i++) {
			System.out.println("\nGen: "+(i+1));
			//pop.printPopulation();
			pop.getPopFitness(data);
			System.out.println();
			pop.sortPopFit();

			pop.getFittest();//getting parents fitness values
		
			//child1 = pop.crossOver(geneSize);
			//child2 = pop.crossOver(geneSize);
			pop.crossOver(geneSize);
			
			pop.child1.calFitness(data);
			
			pop.child2.calFitness(data);
		
			pop.mutation(pop.parent1, geneSize);
			
			pop.mutate.calFitness(data);
		
			pop.newPop(data);
		}
		
		System.out.println("\nFinal gene: ");
		pop.pop[0].printGene();
		System.out.println("\nFinal fitness: "+pop.pop[0].calFitness(data));
	}
}

class Individual {
	
	double fitness=0;
	int [] gene=null;
	
	//Initiate a new individual with a random genetic information
	public Individual (int n) {
		
		Random r = new Random ();
		gene = new int [n];
		for (int i=0; i<n; i++) {
			int geneNo = r.nextInt(100)%2;
			this.gene[i]=geneNo;
		}
	}
	
	public Individual copyIndividual(Individual ind, int genSize) {
		
		Individual res=new Individual(genSize);
		for (int i=0; i<ind.gene.length; i++) {
			res.gene[i]=ind.gene[i];
		}
		return res;
	}
	
	public double calFitness (ArrayList<Double> data) {
		double left = 0, right = 0;
		for (int i = 0; i < data.size(); i++) {
			if (gene[i] == 0) left += data.get(i);
			else right += data.get(i);
		}
		this.fitness = Math.abs(left-right);
		return this.fitness;
	}
	
	public void printGene() {
		for (int i=0; i<gene.length; i++) {
			System.out.print(gene[i]+" ");
		}
	}
}

class Population {
	
	Individual[] pop = null;
	double[] popFit = null;
	ArrayList<Double> sortedFit;
	Individual parent1;
	Individual parent2;
	
	Individual child1;
	Individual child2;
	Individual mutate;
	
	public void initialPop (int popSize, int n) {
		
		pop = new Individual[popSize];
		popFit = new double[popSize];
		sortedFit = new ArrayList<Double>();
		for (int i=0; i<popSize; i++) {
			this.pop[i] = new Individual(n); //create an individual randomly
		}
	}
	
	public void printPopulation () {
		System.out.println("\nPopulation :");
		for (int i=0; i<pop.length; i++) {
			pop[i].printGene();
			System.out.println();
		}
	}
	
	public void getPopFitness (ArrayList<Double> data) {
		for (int i = 0; i < pop.length; i++) {
			popFit[i] = pop[i].calFitness(data);
		}
	}
	
	public void sortPopFit () {
		java.util.Arrays.sort(pop, new CompareFitness());
	}
	
	//getting fitness for parent1 and parent2
	public void getFittest () {
		parent1 = pop[0];
		parent2 = pop[1];
	}
	
	public void crossOver(int genSize) {
		child1 = new Individual(genSize);
		child2 = new Individual(genSize);
		child1 = doCrossOver(child1, genSize);
		child2 = doCrossOver(child2, genSize);
	}
	
	public Individual doCrossOver(Individual child, int genSize) {
		double crossOverRate = 0.5;
		int filledIndex = 0;
		int[] gene = new int[genSize];
				
		int point = (int)(parent1.gene.length*crossOverRate);
	
		for (int i = 0; i < point; i++) {
			gene[i] = parent1.gene[i];
			filledIndex++;
		}
		
		Random r = new Random();
		for (int i = filledIndex; i < gene.length; i++) {
			gene[i] = parent1.gene[r.nextInt(parent1.gene.length)];
		}
		
		child.gene = gene;
		return child;
	}
	
	public void mutation (Individual parent1, int genSize) {
		ArrayList<Integer> mutateIndices = new ArrayList<Integer>();
		Random r = new Random();
		
		mutate = parent1.copyIndividual(parent1, genSize);
		
		for (int i = 0; i < mutateIndices.size(); i++) {
			mutateIndices.add(r.nextInt(parent1.gene.length));
		}
		
		for (int i = 0; i < parent1.gene.length; i++) {
			if (mutateIndices.contains(i)) {
				mutate.gene[i] = r.nextInt(1);
			}
		}
	}

	public void newPop (ArrayList<Double> data) {
		
		Hashtable<Double, Individual> newPop = new Hashtable<Double, Individual>(); //use hashtable to store key:value (fitness value:gene)
		ArrayList<Double> fitList = new ArrayList<Double>(); //use arraylist to store the fitnesses so that we can sort the element
		
		//adding all candidates into a new pool of population
		for (int i=0; i<pop.length; i++) {
			newPop.put(pop[i].calFitness(data), pop[i]);
			fitList.add(pop[i].calFitness(data));
		}
		
		//adding the new children and the mutate into a new pool of population
		newPop.put(child1.calFitness(data),child1);
		fitList.add(child1.calFitness(data));
		newPop.put(child2.calFitness(data),child2);
		fitList.add(child2.calFitness(data));
		newPop.put(mutate.calFitness(data),mutate);
		fitList.add(mutate.calFitness(data));
		
		Collections.sort(fitList);//sort the candidates fitness values
		
		//getting the first 10 candidates for the next generation
		for (int i=0; i<pop.length; i++)
			pop[i]=newPop.get(fitList.get(i));
		
		
	}
}

class CompareFitness implements java.util.Comparator {	
	public int compare(Object a, Object b) 
	{
		if (((Individual)a).fitness < ((Individual)b).fitness) return(-1);
		if (((Individual)a).fitness > ((Individual)b).fitness) return(1);
		return(0);
	}
}