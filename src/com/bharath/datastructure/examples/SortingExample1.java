package com.bharath.datastructure.examples;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;
	import java.util.Map.Entry;

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
	/**
	 * http://www.geeksforgeeks.org/find-k-closest-elements-given-value/
	 * Find k closest elements to a given value
	 * Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42, 
                45, 48, 50, 53, 55, 56}
			Output: 30 39 42 45
	 * @param a
	 * @param k
	 * @param element
	 */
	void findClosestElements(int[] a, int k, int element) {

		System.out.println(Arrays.toString(a));
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0 ;i<a.length; i++) {
			if(a[i] - element < 0) {
				map.put(a[i], element -a[i]);
			} else {
				map.put(a[i],a[i] - element);
			}
		}
		System.out.println(map);
		List<Entry<Integer, Integer>> lb = new ArrayList<>(map.entrySet());
		Collections.sort(lb, (c,d)->c.getValue().compareTo(d.getValue()));
		int i=0;
		for (Iterator<Entry<Integer, Integer>> iterator = lb.iterator(); iterator.hasNext();) {
			Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator
					.next();
			if(entry.getKey() == element)
				continue;
			if(i<k){
				i++;
				System.out.println(entry.getKey());
			}
			else {
				break;
			}
		}
	}

	/**
	 * Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
	 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
	 */
	List<Integer> lowList = new ArrayList<>();
	List<Integer> highList = new ArrayList<>();
	int temp = 0;
	void unsorted(int a[], int low , int high) {
		boolean isFound = false;
		for(int i=low;i<high;i++) {
			if(a[i] > a[i+1]) {
				low = i;
				lowList.add(low);
				isFound = true;
				break;
			}
		}
		for(int j=high;j>low;j--) {
			if(a[j] < a[j-1]) {
				high = j;
				highList.add(high);
				isFound = true;
				break;
			}
		}
		if(isFound){
			Arrays.sort(a,low,high+1);
			unsorted(a, 0, a.length-1); 
		}
		else {
			System.out.println(Arrays.toString(a));
			System.out.println(lowList + "," + highList);
			System.out.println(Collections.min(lowList) + "," + Collections.max(highList));
		}
	}
	/**
	 * geeksforgeeks solution
	 * @param arr
	 * @param n
	 */
	void printUnsorted(int arr[], int n)
	{
		int s = 0, e = n-1, i, max, min; 

		// step 1(a) of above algo
		for (s = 0; s < n-1; s++)
		{
			if (arr[s] > arr[s+1])
				break;
		}
		if (s == n-1)
		{
			System.out.println("The complete array is sorted");
			return;
		}

		// step 1(b) of above algo
		for(e = n - 1; e > 0; e--)
		{
			if(arr[e] < arr[e-1])
				break;
		}

		// step 2(a) of above algo
		max = arr[s]; min = arr[s];
		for(i = s + 1; i <= e; i++)
		{
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}

		// step 2(b) of above algo
		for( i = 0; i < s; i++)
		{
			if(arr[i] > min)
			{ 
				s = i;
				break;
			}	 
		} 

		// step 2(c) of above algoT
		for( i = n -1; i >= e+1; i--)
		{
			if(arr[i] < max)
			{
				e = i;
				break;
			} 
		} 

		// step 3 of above algo
		System.out.println(" The unsorted subarray which"+
				" makes the given array sorted lies"+
				" between the indices "+s+" and "+e);
		return;
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
		int C[] = {12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};
		obj1.findClosestElements(C, 4, 35);
		int a[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int b[] = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		//System.out.println(Arrays.toString(b));
		//obj1.unsorted(a,0,a.length-1);
		int arr_size = a.length;
		//obj1.printUnsorted(a, arr_size);
	}
}
