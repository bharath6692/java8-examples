package com.bharath.datastructure.examples;


class Node {
	int data;
	Node next;
	Node prev;
	Node(int d) { 
		data = d; 
		next = null;
		prev = null;
	} // Constructor
}

public class DoubleLinkedListExample {
	Node head;
	
	void push(Node node) {
		if(head != null) {
			head.prev = node;
			node.next = head;
			head = node;
		}
		else {
			head = node;
		}
	}
	
	void append(Node node) {
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = node;
		node.prev = last;
	}
	
	void insertAfter(Node previousNode, Node node) {
		node.next = previousNode.next;
		previousNode.next = node;
		node.prev = previousNode;
		if(node.next != null)
			node.next.prev = node;
	}
	
    void reverse() {
        Node temp = null;
        Node current = this.head;
        
        printList(current);
 
        /* swap next and prev for all nodes of 
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        	/*temp=current.next; 
        	current.next=current.prev; 
        	current.prev=temp; 
        	current=current.next;*/
        }
 
        /* Before changing head, check for the cases like empty 
         list and list with only one node */
        /*if (temp != null) {
            this.head = temp.prev;
        }*/
        
        printList(temp.prev);
    }
	void printList(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		DoubleLinkedListExample dll = new DoubleLinkedListExample();
		dll.push(new Node(10));
		dll.push(new Node(11));
		dll.push(new Node(12));
		dll.append(new Node(9));
		dll.push(new Node(13));
		dll.printList(dll.head);
		//dll.insertAfter(dll.head.next, new Node(18));
		//dll.printList(dll.head);
		dll.reverse();
		//dll.printList(dll.head);
	}
}
		

