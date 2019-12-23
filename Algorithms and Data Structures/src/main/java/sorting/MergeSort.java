package sorting;

public class MergeSort {

	public static void mergeSort(int[] Array, int left, int right) {
		if (right > left) {
			int m = (left + right) / 2;
			mergeSort(Array, left, m);
			mergeSort(Array, m + 1, right);
			merge(Array, left, m, right);
		}
	}// end of method

	static void merge(int Arr[], int start, int mid, int end) {

		// create a temp array
		int temp[] = new int[end - start + 1];

		// crawlers for both intervals and for temp
		int i = start, j = mid+1, k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(i <= mid && j <= end) {
			if(Arr[i] <= Arr[j]) {
				temp[k] = Arr[i];
				k += 1; i += 1;
			}
			else {
				temp[k] = Arr[j];
				k += 1; j += 1;
			}
		}

		// add elements left in the first interval 
		while(i <= mid) {
			temp[k] = Arr[i];
			k += 1; i += 1;
		}

		// add elements left in the second interval 
		while(j <= end) {
			temp[k] = Arr[j];
			k += 1; j += 1;
		}

		// copy temp to original interval
		for(i = start; i <= end; i += 1) {
			Arr[i] = temp[i - start];
		}
	}
	
	static void merge1(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	static void merge2(int[] A, int left, int middle, int right) {
		int[] leftTmpArray = new int[middle - left + 2]; // Create tmp arrays
		int[] rightTmpArray = new int[right - middle + 1];

		for (int i = 0; i <= middle - left; i++) // Copy values from Array 'A' to these tmp arrays
			leftTmpArray[i] = A[left + i];
		for (int i = 0; i < right - middle; i++)
			rightTmpArray[i] = A[middle + 1 + i];

		leftTmpArray[middle - left + 1] = Integer.MAX_VALUE; // Merge values and insert into Array 'A'
		rightTmpArray[right - middle] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (leftTmpArray[i] < rightTmpArray[j]) {
				A[k] = leftTmpArray[i];
				i++;
			} else {
				A[k] = rightTmpArray[j];
				j++;
			}
		}
	}// end of method

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}// end of method

}// end of class
