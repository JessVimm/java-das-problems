// Class with orderArray method which is supposed to rearrange
// a given array of int values so that the even numbers appear
// first, followed by odd numbers.
// Case 1: [1,2,3,4,5,6,7,8,9,10] -> [2,4,6,8,10,3,7,1,9,5]
// Case 2: [2,4,6,1,8]  	  -> [2,4,6,8,1]

import java.util.Arrays;

public class EvenBeforeOdd {
	public static void main(String[] args) {
		//int[] example = {1,2,3,4,5,6,7,8,9,10};
		int[] example = {2, 4, 6, 1, 8};
		
		System.out.println("Before the array is: " + Arrays.toString(example));

		orderArray(example);
		
		System.out.println("After the array is: " + Arrays.toString(example));
	}



	public static void orderArray(int[] givenArray) {
		for(int idx = 0; idx < givenArray.length; idx++) {
			int currentValue = givenArray[idx];

			if (isEven(currentValue)) {
				continue; 
			} else {
				// Is odd, search for an even number to swap it
				int nextIdx;

				for(nextIdx = idx + 1; nextIdx < givenArray.length; nextIdx++) {
					if(isEven(givenArray[nextIdx])) {
						// Found an even number, swap them
						swap(givenArray, idx, nextIdx);
						// Stop searching
						break;
					}
				}
			}
		}
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static void swap(int[] array, int start, int end) {
		int temp = array[start];

		array[start] = array[end];
		array[end] = temp;
	}
}
