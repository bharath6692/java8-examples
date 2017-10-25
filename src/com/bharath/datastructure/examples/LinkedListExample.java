package com.bharath.datastructure.examples;

// A simple Java program for traversal of a linked list
class LinkedListExample
{
	Node head; // head of list

	/* Linked list Node. This inner class is made static so that
	main() can access it */
	static class Node {
		int data;
		Node next;
		Node(int d) { data = d; next=null; } // Constructor
	}

	/* This function prints contents of linked list starting from head */
	public void printList()
	{
		Node n = this.head;
		while (n != null)
		{
			System.out.print(n.data+" ");
			n = n.next;
		}
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
	void Delete(Node head)
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
	 * Remove duplicate element from sorted Linked List
	 * http://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1/?ref=self
	 * @param head
	 */
	void removeDuplicates(Node head)
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
	/* method to create a simple linked list with 3 nodes*/
	public static void main(String[] args)
	{
		/* Start with the empty list. */
		LinkedListExample llist = new LinkedListExample();

		llist.head	 = new Node(1);
		//Node second	 = new Node(2);
		//Node third	 = new Node(2);
		//Node fourth	 = new Node(4);
		//llist.head.next = second; // Link first node with the second node
		//second.next = third; // Link first node with the third node
		//third.next = fourth; //Link first node with the fourth node	
		llist.printList();
		llist.Delete(llist.head);
		//llist.removeDuplicates(llist.head);
		llist.printList();
	}
}
