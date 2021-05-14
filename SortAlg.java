import java.util.Random;
import java.util.ArrayList;


public class SortAlg {
	public static void main (String []args) {
		ArrayList<Integer> current = generateUnSort();
		ArrayList<Integer> currentSolve = new ArrayList<Integer>();
		for(int i = 0; i < current.size(); i++) {
			currentSolve.add(i, current.get(i));
		}
		
		
		System.out.println(current);
		//System.out.println(currentSolve);

		//System.out.println(bubbleSort(currentSolve));
		
		//System.out.println(selectionSort(currentSolve));
		
		System.out.println(countingSort(currentSolve));
		
	}
	
	public static ArrayList<Integer> generateUnSort() {
		Random rand = new Random();
		ArrayList<Integer> unSort = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) 
		{
			unSort.add(rand.nextInt(10));
		}
	
		return unSort;
	}

	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> currentSolve) {
		int count = 0;
		int gen = 0;
		for(int j = 0; j < currentSolve.size(); j++) 
		{
			for(int i = 0;i < currentSolve.size(); i++)
			{
				try {
					while(currentSolve.get(i) > currentSolve.get(i+1))
					{
						int store = currentSolve.get(i);
						currentSolve.set(i, currentSolve.get(i+1));
						currentSolve.set(i+1, store);
						System.out.println( "Gen: " + gen + " Iter: "+ count + "  " + currentSolve);
						count++;
					}
				} catch(Exception e) {
					continue;
				}
			}
			gen++;
		}
		return currentSolve;
	}

	public static ArrayList<Integer> selectionSort(ArrayList<Integer> currentSolve) {
		int index = 0;
		int count = 0;
		while(count < 10)
		{
			int min = 100;
			for (int j = 0 + count; j < currentSolve.size(); j++)
			{
				if(currentSolve.get(j) < min) {
					min = currentSolve.get(j);
					index = j;
				}
				//System.out.println(min);
			}
			currentSolve.add(count, min);
			currentSolve.remove(index+1);
			count++;
			//System.out.println(currentSolve);
			
		}
		return currentSolve;
	}

	public static ArrayList<Integer> countingSort(ArrayList<Integer> currentSolve) {
		ArrayList<Integer> rule2 = new ArrayList<Integer>();
		for(int i = 9; i > -1; i--) 
		{
			rule2.add(0);
		}
		for(int j = 0; j < currentSolve.size(); j++) 
		{
			int count = 0;
			for(int i = 0; i < currentSolve.size(); i++) 
			{
				if(currentSolve.get(i) == j) 
				{
					count++;
					rule2.set(j, count);
				}
			}
		}
		int count = 0;
		for(int i = 0; i < currentSolve.size(); i++)
		{
			for(int j = 0; j < rule2.get(i); j++)
			{
				currentSolve.set(count, i);
				count++;
			}
		}
		
		return currentSolve;
	}

	

}
