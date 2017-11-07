package com.bharath.datastructure.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortingExample1 {
	void printPairs(int[] a, int k) {

		for(int i=0;i<a.length-1;i++) {
			int j=i+1;
			while(i<j && j<a.length) {
				if(a[i]+a[j] == k) {
					System.out.println("pairs are " + a[i] + " and " + a[j]);
					return;
				} else {
					System.out.println(a[i] + " " + a[j] );
					j++;
				}
			}
		}
	}

	void printAll(int[] a, int k) {
		int i = 0;
		int j = a.length-1;

		while(i<j) {
			int temp = a[i] + a[j];
			if(temp == k ) {
				System.out.println("pairs are " + a[i] + " and " + a[j]);
				return;
			} if(temp>k) {
				j--;
			} else {
				i++;
			}
		}
	}

	//http://www.geeksforgeeks.org/given-two-unsorted-arrays-find-pairs-whose-sum-x/
	//Given two unsorted arrays, find all pairs whose sum is x
	void twoSort(int[] A, int[] B, int k) {
		Arrays.sort(A);
		Arrays.sort(B);
		int i=0;
		int j=B.length-1;

		while( i<A.length && j >= 0) {
			int temp = A[i] + B[j];
			if(temp == k) {
				System.out.println("pairs are " + A[i] + " and " + B[j]);
				i++;
			} else if(temp > k) {
				j--;
			} else {
				i++;
			}
		}
	}
	
	void findClosestElements(int[] a, int k, int element) {
		
		System.out.println(Arrays.toString(a));
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0 ;i<a.length; i++) {
			if(a[i] - element < 0) {
				a[i] = element -a[i];
			} else {
				a[i] = a[i] - element;
			}
		}
		
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
		for(int i = 0 ; i<k; i++) {
			a[i] = element - a[i];
			System.out.println("elements near to " + element + " are "+ a[i]);
		}
	}
	
public static void main(String[] args) {
		
	SortingExample1 obj1 = new SortingExample1();
		int A[] = {1, 4, 45, 6, 10, 8};
		Arrays.sort(A);
        int n = 16;
        int arr1[] = {1, 2, 4, 5, 7};
        int arr2[] = {5, 6, 3, 4, 8}; 
        //obj1.twoSort(arr1, arr2, 8);
        //obj1.printPairs(A,  n);
        //obj1.printAll(A, n);
        int B[] = {1,30,40,80,81,82,100,102,104};
        obj1.findClosestElements(B, 3, 70);
	}
}
