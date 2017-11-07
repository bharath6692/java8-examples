package com.bharath.datastructure.examples;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// A simple Java program for traversal of a linked list
class LinkedListExample2
{
	Node head; // head of list
	Node head1;
	
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
	/**
	 * Add two numbers represented by linked lists (Function Problem)
	 * http://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
	 * @param first
	 * @param second
	 */
	void addTwoLists(Node first, Node second)
	{
		Node list_1  = first;
		Node list_2 = second;

		StringBuilder sb1 = new StringBuilder();
		int number_1 = 0;
		int number_2 = 0;
		while(list_1 != null) {
			sb1.append(list_1.data);
			list_1 = list_1.next;
		}
		if(sb1.length()!=0) {
			StringBuilder s1 = sb1.reverse();
			number_1 = Integer.parseInt(s1.toString());
			sb1.setLength(0);
		}

		while(list_2 != null) {
			sb1.append(list_2.data);
			list_2 = list_2.next;
		}
		if(sb1.length()!=0) {
			StringBuilder s1 = sb1.reverse();
			number_2 = Integer.parseInt(s1.toString());
			sb1.setLength(0);
		}

		Integer total = number_1 + number_2;

		String final_number = total.toString();

		Node head = null;
		Node temp = null;
		if(final_number.length()>0) {
			for(int j=0;j<final_number.length();j++) {
				temp = new Node(Integer.parseInt(final_number.charAt(j)+""));
				if(head!=null) {
					temp.next = head;
				}
				head = temp;
			}
		}

		printList(head);
		/*Node n = head;
		while (n != null)
		{
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println("\n");*/
	}
	//if i/p is 1, 2, 3, 4, 5, 6, 7 
	//   o/p is 2, 3, 4, 5, 6, 7, 1
	void alterElements(Node head) {
		if(head==null && head.next==null)
			return;
		int temp;
		Node p = head;
		Node q = p.next;

		while(q!=null) {
			temp = p.data;
			p.data = q.data;
			q.data = temp;
			p = q.next;
			q = p!=null?p.next : null;
		}
	}
	void printInReverse(Node head) {
		if(head==null)
			return;
		printInReverse(head.next);
		System.out.print(head.data + " ");
	}
	//http://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
	/**
	 * Given an input stream of n characters consisting only of small case alphabets the task is to find the first non repeating character each time a character is inserted to the stream.
	 */
	void stream() {
		Scanner sc = new Scanner(System.in);
		while(true) {
		int c = sc.nextInt();
		Node node  = new Node(c);
		if(this.head == null){
			System.out.println("first" + c);
		} else if(c == this.head.data) {
			System.out.println("second" + "-1");
		} else {
			System.out.println("third" + c);
		}
		node.next = this.head;
		this.head = node;
		}
	}
	/**
	 * Segregate even and odd nodes in a Linked List
	Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.
	Input: 17->15->8->12->10->5->4->1->7->6->NULL
	Output: 8->12->10->4->6->17->15->5->1->7->NULL
	http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
	 * @param head
	 */
	void segregateEvenOdd(Node head) {
		Node oddStart = null;
		Node oddEnd = null;
		Node evenStart = null;
		Node evenEnd = null;
		Node current = this.head;
		
		while(current != null) {
			int element = current.data;
			if(element%2 == 0) {
				if(evenStart == null) {
					evenStart = current;
					evenEnd = evenStart;
				} else {
					evenEnd.next = current;
					evenEnd = evenEnd.next;
				}
			} else {
				if(oddStart == null) {
					oddStart = current;
					oddEnd = oddStart;
				} else {
					oddEnd.next = current;
					oddEnd = oddEnd.next;
				}
			}
			current = current.next;
		}
		
		if(oddStart ==null && evenStart == null)
			return;
		evenEnd.next = oddStart;
		oddEnd.next = null;
		this.head = evenStart;
	}
	//Implementation of Floyd’s Cycle-Finding Algorithm:
	int detectLoopUsingFloyds()
    {
        Node slow_p = head, fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                System.out.println("Found loop");
                return 1;
            }
        }
        return 0;
    }
	//Detect and Remove Loop in a Linked List
	//http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
	void detectLoop(Node head) {
		Node temp = head;
		Set<Node> set = new HashSet<>();
		set.add(temp);
		while(temp != null) {
			if(!set.add(temp.next)) {
				System.out.println("loop found at " + temp.next.data);
				temp.next = null;
				return;
			}
			temp = temp.next;
		}
	}
	int length ;
	/**
	 * Modify contents of Linked List
	 * Input : 10 -> 4 -> 5 -> 3 -> 6
	   Output : 4 -> 1 -> 5 -> 3 -> 6
	   http://www.geeksforgeeks.org/modify-contents-linked-list/
	 * @param head
	 * @param i - index of node
	 */
	void alterList(Node head , int i) {
		if(head==null)
			return;
		++i;
		alterList(head.next, i);
		add(head.data, i);
	} 
	
	void add(int data , int i) {
		if(length/2<i) {
			Node temp = this.head;
			for(int j=0;j<length-i;j++) {
				temp = temp.next;
			}
			temp.data = temp.data - data;
		}
	}
	
	void getLength(Node head) {
		Node temp = head;
		int count = 0;
		while (temp!=null) {
			temp = temp.next;
			count++;
		}
		this.length = count;
	}
	
	Node merge(Node h1, Node h2)
	{
	    if (h1 == null)
	        return h2;
	    if (h2 == null)
	        return h1;
	 
	    // start with the linked list
	    // whose head data is the least
	    if (h1.data < h2.data)
	    {
	        h1.next = merge(h1.next, h2);
	        return h1;
	    }
	    else
	    {
	        h2.next = merge(h1, h2.next);
	        return h2;
	    }
	}
	/* method to create a simple linked list with 3 nodes*/
	public static void main(String[] args)
	{
		/* Start with the empty list. */
		LinkedListExample2 llist = new LinkedListExample2();

		llist.head	 = new Node(1);
		Node second	 = new Node(3);
		Node third	 = new Node(5);
		Node fourth	 = new Node(7);
		llist.head.next = second; // Link first node with the second node
		second.next = third; // Link first node with the third node
		third.next = fourth; //Link first node with the fourth node	
		//below line is for creating loop in list
		//llist.head.next.next.next.next = llist.head;
		llist.printList(llist.head);
		//llist.segregateEvenOdd(llist.head);
		//llist.getLength(llist.head);
		//llist.alterList(llist.head,0);
		//llist.printList(llist.head);
		//llist.printInReverse(llist.head);
/*		llist.alterElements(llist.head);
		llist.printList(llist.head);
*/
		llist.head1	 = new Node(2);
		Node second1	 = new Node(4);
		Node third1	 = new Node(6);
		//Node fourth	 = new Node(2);
		llist.head1.next = second1; // Link first node with the second node
		second1.next = third1; // Link first node with the third node
		
		llist.printList(llist.head1);
		
		Node h3 = llist.merge(llist.head, llist.head1);
		
		llist.printList(h3);
		//llist.addTwoLists(llist.head, llist.head1);
		
		//llist.stream();
	}
}
