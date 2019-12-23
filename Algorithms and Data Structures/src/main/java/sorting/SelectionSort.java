package sorting;

public class SelectionSort {
	
	static void selectionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i<n; i++) {
			int minimumIndex = i;
			for (int j=i+1; j<n; j++) {
				if (a[j] < a[minimumIndex]) //find which is the smallest element to right of 'j'
					minimumIndex = j;
			}//end of inner loop
			if (minimumIndex != i) { // if j is not minimum index then swap
				int temp = a[i];
				a[i] = a[minimumIndex];
				a[minimumIndex] = temp;
			}
		}//end of outer loop
	}//end of method

	
	public static void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}//end of method

}//end of class
