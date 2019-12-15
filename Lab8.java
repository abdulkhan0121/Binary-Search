package Lab8;
import java.util.Random;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;
public class Lab8 {
/*Perform a binary search using Java’s built-in binary search method in the Arrays class to see
if the item exists in the list, if so output the index.
3. Then write your two more binary search methods, one recursive and one iterative. Then
demo each binary search on the sorted array, counting the number of probes made, and output
that result. A probe is counted as a comparison between the element sought and an element in
the array.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		int arraySize = generator.nextInt(31) + 20;
		int array[] = new int [arraySize];
		
		for(int i = 0; i < arraySize; i++) {	
			array[i] = generator.nextInt(100);
		}
		
		System.out.println(" Original array of "+arraySize+" elements:");
		
		int counter = 0;
		//arraySize = 15;
		for(int i = 0; i < arraySize; i++) {	
			if(counter < 10) {
				System.out.printf("%3d",array[i]);
				counter++;
			}
			else if (counter >= 10) {
				counter = 1;
				System.out.println();
				System.out.printf("%3d",array[i]);

			}
		}
			Arrays.sort(array);
			
			System.out.println(" \n\n Sorted array of "+arraySize+" elements:");
			
			int secondCounter = 0;
			for(int j = 0; j < arraySize; j++) {	
				if(secondCounter < 10) {
					System.out.printf("%3d",array[j]);
					secondCounter++;
				}
				else if (secondCounter >= 10) {
					secondCounter = 1;
					System.out.println();
					System.out.printf("%3d",array[j]);

				}
		}
			
			int twice = 0, i = 0;
			
			System.out.println("\n\nBuilt-In Binary Search");
			do {
				System.out.print("\nWhat entry? ");
				int num = input.nextInt();
				builtIn(array, num);
				twice++;
			}while(twice < 2);
			twice = 0;
			
			System.out.println("\n\nMy iterative Binary Search");
			do {
				System.out.print("\nWhat entry? ");
				int num = input.nextInt();
				int probe = 0;
				iterative(array, num, probe);
				twice++;
			}while(twice < 100);
			twice = 0;
			
			System.out.println("\n\nMy Recursive Binary Search");
			do {
				System.out.print("\nWhat entry? ");
				int num = input.nextInt();
				int probe = 0;
				recursive(array, num, i, probe);
				twice++;
			}while(twice < 2);
			
		

	}
	public static void builtIn(int[] array, int num) {
	
		if(Arrays.binarySearch(array, num) < 0)
			System.out.println("	status: not found.");
		else
			System.out.println("	status: found at index "+Arrays.binarySearch(array, num)+".");
	
	}
	
	public static void iterative(int[] array, int num, int probe) {
		/*	0 = start
		 * 	1 = found
		 * 	2 = not found 
		 */
		int start = 0, end = 0;
		int found = 0;
		int middle = (start + end) / 2;

		do {
		
			if(num == array[middle]) {
				System.out.println("	status: found at index "+middle);
				found = 1;
			}
			else if(num < array[middle]) {
				end = middle;
			}
			else if(num > array[middle]) {
				start = middle;
			}
		
				
			
		}while (start < end);
		
	}

	public static void recursive(int[] array, int num, int i, int probe) {
		
		if(array[i] == num)
			System.out.println("	status: found at index "+i+" after "+probe+" probes.");
		else if(i == array.length - 1)
			System.out.println("	status: not found.");
			
		else
			probe++;
			recursive(array, num, i+1, probe);
			
}

	}
	
