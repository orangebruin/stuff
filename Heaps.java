package com.ob.sort;

public class Heaps {
	public static void printList(int[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}
	
	public int parent(int i) {
		return i/2;
	}
	
	public int left(int i) {
		return (i*2) + 1 ;
	}
	
	public int right(int i) {
		return (i*2) + 2;
	}
	
	public int[] maxHeapify(int[] A, int i, int heapSize) {
		int [] retVal = A;
		int l = left(i), r = right(i);
		int largest = -1;
		
		if (l < heapSize && retVal[l] > retVal[i]) {
			largest = l;
		} else {
			largest = i;
		}
		
		if (r < heapSize && retVal[r] > retVal[largest]) {
			largest = r;
		}
		
		if (largest != -1 && largest != i) {
			int temp = retVal[i];
			retVal[i] = retVal[largest];
			retVal[largest] = temp;
			return maxHeapify(retVal, largest, heapSize);
		}

		return retVal;
	}
	
	public int[] buildMaxHeap(int[] A) {
		int[] retVal = A;
		int heapSize = A.length;
		
		for (int i = (heapSize/2 - 1); i >= 0; i-- ){ 
			retVal = maxHeapify(retVal, i, heapSize);
		}
		
		return retVal;
	}
	
	public int[] heapSort(int[] A) {
		int[] retVal = buildMaxHeap(A);
		int heapSize = A.length;
		
		for (int i = A.length-1; i > 0; i--) {
			int temp = retVal[0];
			retVal[0] = retVal[i];
			retVal[i] = temp;
			heapSize--;
			retVal = maxHeapify(retVal, 0, heapSize);
		}
		
		return retVal;
	}
	
	public static void main(String[] args) {
		Heaps heap = new Heaps();
		//int[] values = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int[] values = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		Heaps.printList(values);
		//int[] heaped = heap.maxHeapify(values, 1);
		//int[] heaped = heap.buildMaxHeap(values);
		int[] heaped = heap.heapSort(values);
		Heaps.printList(heaped);
	}
}
