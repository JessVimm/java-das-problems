// Class with orderArray method which is supposed to rearrange
// a given array of int values so that the even numbers appear
// first, followed by odd numbers.
// This solution is O(n). It implements two pointers.
// Case 1: [1,2]     -> [2,1]
// Case 2: [2,4,7,9] -> [2,4,9, 7]

import java.util.Arrays;

public class BetterEvenBeforeOdd {
	public static void main(String[] args) {
		//int[] example = {1,2,3,4,5,6,7,8,9,10};
		int[] example = {2, 4, 7, 9};

		System.out.println("Before, the array is: " + Arrays.toString(example));

		orderArray(example);

		System.out.println("After, the array is: " + Arrays.toString(example));
	}

	public static void orderArray(int[] givenArray) {
		// Create pointers
		int evenPointer = 0;
		int oddPointer = givenArray.length - 1;

		// Arrange the array
		while(evenPointer < oddPointer) {
			int currentValue = givenArray[evenPointer];

			if(isEven(currentValue)) {
				evenPointer++;
			}else {
				// Swap with last value
				swap(givenArray, evenPointer, oddPointer);
				oddPointer--;
			}
		}
	}

	public static boolean isEven(int value) {
		return value % 2 == 0;
	}

	public static void swap(int[] array, int start, int end) {
		int temp = array[start];

		array[start] = array[end];
		array[end] = temp;
	}
	
}


