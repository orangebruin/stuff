package com.ob.sort;

public class Sorting {
	
	public static void printList(int[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}
	
	public int[] insertionSort(int[] list) {
		int[] retVal = list;
		
		for (int j = 1; j < retVal.length; j++) {
			int key = retVal[j];
			int i = j - 1;
			while (i >= 0 && retVal[i] > key) {
				retVal[i+1] = retVal[i];
				i--;
			}
			retVal[i+1] = key;
			printList(retVal);
		}
		
		return retVal;
	}
	
	public int[] mergeSort(int[] A) {
		int[] retVal = A;
		printList(A);
		if (A.length > 1) {
			int counter = 0;
			int q = A.length/2;
			int[] L = new int[q];
			int[] R = new int[A.length - q];
			for (int i = 0; i < L.length; i++) {
				L[i] = A[counter];
				counter++;
			}
			for (int j = 0; j < R.length; j++) {
				R[j] = A[counter];
				counter++;
			}
			
			L = mergeSort(L);
			R = mergeSort(R);
			retVal = merge(L, R);
		}
		
		return retVal;
	}
	
	private int[] merge(int[] L, int[] R) {
		int length, n1, n2;
		if (L == null) {
			length = R.length;
			n1 = 0;
			n2 = R.length;
		} else if (R == null) {
			length = L.length;
			n1 = L.length;
			n2 = 0;
		} else {
			length = L.length + R.length;
			n1 = L.length;
			n2 = R.length;
		}
		
		int [] retVal = new int[length];
		
		int i = 0, j = 0;
		
		for (int k = 0; k < retVal.length; k++) {
			if (i < n1 && j < n2 && L[i] <= R[j]) {
				retVal[k] = L[i];
				i++;
			} else if (j < n2) {
				retVal[k] = R[j];
				j++;
			} else if (i < n1) {
				retVal[k] = L[i];
				i++;
			}
		}
		
		return retVal;
	}
	
	private int partition(int[] A, int p, int r) {
		int x = A[r], i = p - 1, temp;
		
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		
		temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		
		return (i+1);
	}
	
	public int[] quickSort(int[] A, int p, int r) {
		int[] retVal = A;
		
		if (p < r) {
			int q = partition(A, p, r);
			retVal = quickSort(retVal, p, q-1);
			retVal = quickSort(retVal, q+1, r);
		}
		
		return retVal;
	}
	
	private int randomPartition(int[] A, int p, int r) {
		int[] retVal = A;
		int i = (int)Math.random() * r;
		int temp = retVal[r];
		retVal[r] = retVal[i];
		retVal[i] = temp;
		return partition(retVal, p, r);
		
	}
	
	public int[] randomQuickSort(int[] A, int p, int r) {
		int[] retVal = A;
		
		if (p < r) {
			int q = randomPartition(retVal, p, r);
			retVal = randomQuickSort(retVal, p, q-1);
			retVal = randomQuickSort(retVal, q+1, r);
		}
		
		return retVal;
	}
	
	public int[] countingSort(int[] A, int k) {
		int[] B = new int[A.length];
		int[] C = new int[k];
		int i, j;
		
		for (i = 0; i < k; i++)
			C[i] = 0;
		
		for (j = 0; j < A.length; j++)
			C[A[j]-1]++;
		
		for (i = 1; i < k; i++)
			C[i] += C[i-1];
		
		for (j = A.length-1; j >= 0; j--) {
			B[C[A[j]-1]-1] = A[j];
			C[A[j]-1]--;
		}
		
		return B;
	}
	
	public static void main(String[] args) {
		int[] list = {4, 6, 132, 56, 11, 33, 37, 1, 3, 7};
		
		Sorting sort = new Sorting();
		//int[] sortedList = sort.mergeSort(list);
		//int[] sportedList = sort.insertionSort(list);
		//int[] sortedList = sort.quickSort(list, 0, list.length-1);
		int[] sortedList = sort.countingSort(list, 132);
		Sorting.printList(sortedList);
	}
}
