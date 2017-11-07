package com.bharath.datastructure.examples;

import java.util.Set;
import java.util.TreeSet;

// A simple Java program for traversal of a linked list
class LinkedListExample1
{
	Node head; // head of list
	Node head1;
	Node head_1;

	/* Linked list Node. This inner class is made static so that
	main() can access it */
	static class Node {
		int data;
		Node next;
		Node(int d) { data = d; next=null; } // Constructor
	}

	/* This function prints contents of linked list starting from head */
	public void printList(Node head)
	{
		Node n = head;
		while (n != null)
		{
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println("\n");
	}

	//Delete Middle of Linked List
	/**
	 * Given a singly linked list, delete middle  of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
		If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
		If the input linked list is NULL, then it should remain NULL.
		If the input linked list has 1 node, then this node should be deleted and new head should be returned.
		http://practice.geeksforgeeks.org/problems/delete-middle-of-linked-list/1/?ref=self
	 * @param head
	 * @return Node
	 */
	void deleteMiddleElementFromList(Node head)
	{
		// This is method only submission.
		// You only need to complete the method.
		if(head!=null && head.next==null){
			this.head = null;
			return;
		}
		int length = 0;
		Node temp = head;
		while(temp!=null) {
			length++;
			temp = temp.next;
		}
		temp = head;
		int limit = length/2;
		for(int i=0;i<limit-1;i++)
			temp = temp.next;
		temp.next = temp.next.next;
	}
	/**
	 * Remove duplicate element from an unsorted Linked List ..
	 * http://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1/?ref=self
	 * @param head
	 * @return
	 */
	Node removeDuplicatesFromUnSortedList(Node head)
	{
		// Your code here
		Node temp = head;
		Set<Integer> set = new TreeSet<>();
		int i=0;
		while(temp!=null) {
			boolean isunique = set.add(temp.data);
			if(!isunique){
				deleteByIndex(i);
			} else
				i++;
			temp = temp.next;
		}
		return head;
	}
	/**
	 * Remove duplicate element from sorted Linked List
	 * http://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1/?ref=self
	 * @param head
	 */
	void removeDuplicatesFromSortedList(Node head)
	{
		Node current = head;
		Node next_next;
		if (head!=null && head.next == null)    {
			this.head = null;
			return;
		}

		while (current.next != null) {

			if (current.data == current.next.data) {
				next_next = current.next.next;
				current.next = null;
				current.next = next_next;
			}
			else // advance if no deletion
				current = current.next;
		}
	}

	public void deleteByIndex(int index) {
		Node temp = head;
		if(index<0) {
			System.out.println("Not a valid index");
			return;
		}
		if(index==0 && temp!=null) {
			this.head = temp.next;
		}
		for(int j=0;j<index-1;j++){
			if(temp!=null)
				temp = temp.next;
			else {
				System.out.println("index is more than size of list");
				return;
			}
		}
		temp.next = temp.next.next;
	}

	//iterative reverse of a linked list
	public static Node reverse(Node node) {

		if (node == null || node.next == null) {
			return node;
		}
		Node next = null;
		Node prev = null;
		Node cur = node;
		while(cur!=null ) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur=next;
		}
		return prev;
	}

	//recursive reverse of linked list
	public static Node reverseLinkedList(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node remaining = reverseLinkedList(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}

	// Find nth element from end of linked list	
	public void nthnode(Node head, int nth) {
		Node last;
		Node first;
		first = head;
		last = head;
		int length = 0;
		while(last!=null ) {
			System.out.println(last.data);
			last = last.next;
			length++; 

		}
		System.out.println("1lenght is" + length);
		for(int i=0;i<length-nth;i++) {
			first=first.next;
		}
		System.out.println("inside " + first.data);
	}
	// Function to check if linked list has a palindrome or not
	public void listHasAPAlindrome(Node head) {
		Node temp1 = head;
		Node temp2 = temp1.next;
		while(temp2 != null) {
			temp2 = temp2.next;
			if(temp2 != null && temp1.data==temp2.data){
				System.out.println("Yes its is a palindrome");
				break;
			}
			temp1 = temp1.next;
		}
	}

	// Function to check if linked list is palindrome or not
	public void listIsAPalindrome(Node head) {
		Node first = head;
		Node last = head;
		int length = 0;
		while(last.next != null) {
			length++;
			last=last.next;
		}
		length++;
		for(int i=0;i<length/2;i++) {
			if(first.data == last.data) {
				first = first.next;

			}
		}
	}

	public void swapByData(Node head) {
		Node cur = head;
		Node next = head;

		while(cur!=null) {
			next = cur.next;
			if(next!=null) {
				int temp = next.data;
				next.data = cur.data ;
				cur.data = temp;
				next = next.next;
			}
			cur = next;
		}
	}

	public void swapTwoElements(int x, int y) {
		// Nothing to do if x and y are same
		if (x == y) return;
		// Search for x (keep track of prevX and CurrX)
		Node prevX = null, currX = head;
		while (currX != null && currX.data != x)
		{
			prevX = currX;
			currX = currX.next;
		}

		// Search for y (keep track of prevY and currY)
		Node prevY = null, currY = head;
		while (currY != null && currY.data != y)
		{
			prevY = currY;
			currY = currY.next;
		}
		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return;

		// If x is not head of linked list
		if (prevX != null)
			prevX.next = currY;
		else //make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.next = currX;
		else // make x the new head
			head = currX;

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}
	public void swap(Node head) {
		Node cur = head;
		Node next = head;
		while(cur!=null) {
			next = cur.next;
			cur.next = next.next;
			next.next = cur;
			next = cur.next;
			cur = next;
		}
	}
	void swapEvenOdd(Node head) {
		Node temp = head;
		Node prev = null;
		while(temp.next!=null) {
			if(temp.data%2==0) {
				prev = temp;
				temp = temp.next;
			}else {
				append(new Node(temp.data));
				if(prev==null){
					prev = this.head;
					this.head = temp.next;
					temp = temp.next;
				}else {
					temp = temp.next;
					prev.next = temp.next;
				}

			}
		}
	}
	
	void append(Node node) {
				Node temp = head_1;
				if(temp == null) {
					head_1 = node;
					System.out.println("hi");
					return;
				} else {
					while(temp.next!=null) {
						temp = temp.next;
					} 
					temp.next = node;
				}
		 	}
	/* method to create a simple linked list with 3 nodes*/
	public static void main(String[] args)
	{
		/* Start with the empty list. */
		LinkedListExample1 llist = new LinkedListExample1();

		llist.head	 = new Node(3);
		Node second	 = new Node(4);
		Node third	 = new Node(5);
		Node fourth	 = new Node(2);
		llist.head.next = second; // Link first node with the second node
		second.next = third; // Link first node with the third node
		third.next = fourth; //Link first node with the fourth node	

		llist.printList(llist.head);
		/*llist.head1	 = new Node(4);
		Node second1	 = new Node(5);
		Node third1	 = new Node(6);
		//Node fourth	 = new Node(2);
		llist.head1.next = second1; // Link first node with the second node
		second1.next = third1; // Link first node with the third node
		llist.printList(llist.head1);
		 */
		//llist.deleteByIndex(7);
		//llist.deleteMiddleElementFromList(llist.head);
		//llist.removeDuplicates(llist.head);
		//llist.removeDuplicatesFromUnSortedList(llist.head);
		//llist.listHasAPAlindrome(llist.head);
		//llist.listIsAPalindrome(llist.head);
		//llist.printList();
		
		//llist.removeDuplicatesFromUnSortedList(llist.head);
		//llist.swapByData(llist.head);
		//llist.printList();
		//llist.swapEvenOdd(llist.head);
	}
}
