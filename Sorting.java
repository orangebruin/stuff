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
	
	public static void main(String[] args) {
		int[] list = {4, 6, 132, 56, 11, 33, 37, 1, 3, 7};
		
		Sorting sort = new Sorting();
		int[] sortedList = sort.mergeSort(list);
		//int[] sportedList = sort.insertionSort(list);
		Sorting.printList(sortedList);
	}
}
