package com.bharath.datastructure.examples;

import java.util.Arrays;

/**
 * this program is to create min/max heap
 * @author dawson
 *http://www.geeksforgeeks.org/heap-sort/
 */
public class MinMaxHeapSort {

	void heapSort(int[] a, int n) {
		//step 1
		//start heap from last subtree 
		for(int i=n/2-1;i>=0;i--) {
			heapify(a,n,i);
		}

		//step 3
		//move current root to end
		for(int i = n-1; i>=0;i--) {
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			heapify(a,i,0);
		}
	}

	//step 2
	//this creates a max heap or min heap based on selected logic
	void heapify(int[] a, int n, int i) {
		int largest = i;	//root element
		int l = 2*i+1;		//left subnode
		int r = 2*i+2;		//right subnode

		//Max Heap
/*		if(l < n && a[l] > a[largest] )
			largest = l;
		if(r < n && a[r] > a[largest] )
			largest = r;

		if(largest!=i) {
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			heapify(a,n,largest);
		}*/
		
		//MinHeap
		int smallest = i;
		if(l < n && a[l] < a[smallest] )
			smallest = l;
		if(r < n && a[r] < a[smallest] )
			smallest = r;

		if(smallest!=i) {
			int temp = a[smallest];
			a[smallest] = a[i];
			a[i] = temp;
			heapify(a,n,smallest);
		}

	}
	public static void main(String[] args) {
		MinMaxHeapSort heapObj = new MinMaxHeapSort(); 
		int a[] = {4,10,11,1,65,3};
		System.out.println("Before sorting" + Arrays.toString(a));
		heapObj.heapSort(a,a.length);
		System.out.println("After sorting" + Arrays.toString(a));
	}
}
