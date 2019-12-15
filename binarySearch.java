/*Abdul Khan
 * C Block
 * 1/11/19
 */
package binarySearch;
import java.util.Random;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;
public class binarySearch {
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
				probe = iterative(array, num);
				if(probe != 1000) {
					System.out.println("after "+probe+" probes.");
				}
				
				twice++;
			}while(twice < 2);
			twice = 0;
			
			System.out.println("\n\nMy Recursive Binary Search");
			do {
				System.out.print("\nWhat entry? ");
				int num = input.nextInt();
				int probe = 0;
				recursive(array, num, 0, array.length-1, probe, 0);
				twice++;
			}while(twice < 2);
			
		

	}
	public static void builtIn(int[] array, int num) {
	
		if(Arrays.binarySearch(array, num) < 0)
			System.out.println("	status: not found.");
		else
			System.out.println("	status: found at index "+Arrays.binarySearch(array, num)+".");
	
	}
	
	public static int iterative(int[] array, int num) {
		/*	0 = starti
		 * 	1 = found
		 * 	2 = not found 
		 */
		int start = 0, end = array.length-1;
		int probe = 0, found = 0, count = 0;
		int middle = (start + (end)) / 2;

		while (found == 0) {
			count++;
			middle = (start + (end)) / 2;
			
			 if(count > 1000) {
				System.out.print("	status: not found.");
				 found = 1;
				}
			else if(num == array[middle]) {
				System.out.print("	status: found at index "+middle+" ");
				probe++;
				return probe;
			}
			else if(num < array[middle]) {
				probe++;
				end = middle;
			}
			else if(num > array[middle]) {
				probe++;
				start = middle;
			}
			
			

		}
		return probe;
		
	}

	public static void recursive(int[] array, int num, int start, int end, int probe, int count) {
		
		int found = 0;
		int middle = (start+end)/2;
		count++;
		if(count > 1000) {
			System.out.println("	status: not found.");
		}
		else if(array[middle] == num) {
			probe++;
			found = 1;
			System.out.println("	status: found at index "+middle+" after "+probe+" probes.");
		}
		else if(num < array[middle]) {
			probe++;
			recursive(array, num, 0, middle, probe, count);
		}
		else if(num > array[middle]) {
			probe++;
			recursive(array, num, middle, end, probe, count);
		}
		
		
}

	}
	
