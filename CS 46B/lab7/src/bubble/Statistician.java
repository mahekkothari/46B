package bubble;

import java.util.*;


public class Statistician 
{
	private final static int N_REPETITIONS = 1000;
	
	//returns a array of random integers with values between -maxValue and maxValue
	private static int[] buildRandom(int length, int maxValue)
	{
		int[] array = new int[length];
		for (int i=0; i<length; i++)
			array[i] = (int)(Math.random()*(maxValue + 1));
		return array;
	}
	
	private static boolean isSorted(int[] a) {
		for(int i=0;i<a.length-2;i++) {
			if(a[i]>a[i+1]) {return false;}
		}
		return true;
	}

	private static boolean isSorted(int[] a) {

	}
	
	private static void getStats(int arrayLength)
	{
		ArrayList<Long> visitCounts = new ArrayList<>();
		ArrayList<Long> swapCounts = new ArrayList<>();
		
		for (int i=0; i<N_REPETITIONS; i++)
		{
			int[] array = buildRandom(arrayLength, arrayLength*100);
			BubbleSorter sorter = new BubbleSorter(array);
			sorter.sort();
			// Assert that the sorter sorted correctly.
			assert isSorted(sorter.getArray());
            // Append the number of visits and swaps to the array lists.
            visitCounts.add(sorter.getNVisits());
            swapCounts.add(sorter.getNSwaps());
		}

		// Compute and print min/average/max number of visits.
		System.out.println("Number of Visits " + arrayLength);
        printStats("Visits", visitCounts);
        printStats("Swaps", swapCounts);

		//helper method for printing out the min, max, and max
		private static void printStats(String label, ArrayList<Long> counts) {
			long min = Long.MAX_VALUE;
			long max = Long.MIN_VALUE;
			long sum = 0;
	
			for (Long count : counts) {
				if (count < min) min = count;
				if (count > max) max = count;
				sum += count;
			}
	
			double avg = (double) sum / counts.size();
			System.out.printf("%s - Min: %d, Avg: %.2f, Max: %d%n", label, min, avg, max);
			
			double avg = (double) sum / counts.size();
		}

	}
	
	public static void main(String[] args)
	{
		int[] tiny = {1,24,5,25};
		int[] alreadySorted = {1,24,5,25};//fill in your example
		int[] backward = {25,24,5,1};//fill in your example

		System.out.println("Tiny");
		BubbleSorter tinySorted = new BubbleSorter(tiny);
		tinySorted.sort();
		System.out.println(tinySorted);
		
		System.out.println("Already Sorted");
        BubbleSorter alreadySortedSorter = new BubbleSorter(alreadySorted);
        alreadySortedSorter.sort();
        System.out.println(alreadySortedSorter);
		
		System.out.println("Backward");
		BubbleSorter backwardSorted = new BubbleSorter(backward);
        backwardSorted.sort();
        System.out.println(backwardSorted);
	
        System.out.println("1000:");
        getStats(1000);
        
		System.out.println("3000:");
		getStats(3000);
		
	}
}