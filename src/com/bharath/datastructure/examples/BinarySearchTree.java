package com.bharath.datastructure.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Node1 {
	int data;
	Node1 left,right;
	Node1(int data) {
		this.data = data;
		left = right = null;
	}
}
public class BinarySearchTree {
	static Node1 root;
	
	/**
	 * Inorder traversal of BST
	 * @param temp
	 */
	//int i;
	void inOrder(Node1 temp) {
		if(temp == null)
			return;
		inOrder(temp.left);
		System.out.println(temp.data);
		//System.out.println(temp.data + " element of " + ++i);
		inOrder(temp.right);
	}

	/**
	 * delete a BST  
	 * @param temp
	 */
	void deleteRef(Node1 temp) {
		deleteATree(temp);
		root=null;
	}
	
	void deleteATree(Node1 temp) {
		if(temp == null)
			return;
		deleteATree(temp.left);
		deleteATree(temp.right);
		System.out.println("deleted " + temp.data);
		temp = null;
	}


	/**
	 * This method mainly calls insertRec()
	 * Inserting nodes in to BST
	 * @param key
	 */
	void insert(int key) {
		root = insertRec(root, key);
	}

	Node1 insertRec(Node1 root, int key) {
		if(root == null) {
			root = new Node1(key);
			return root;
		}

		if(key < root.data) {
			root.left = insertRec(root.left, key);
		} else if(key > root.data) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}
	
	/**
	 * search a BST
	 * @param root
	 * @param key
	 * @return
	 */
	// A utility function to search a given key in BST
	public Node1 search(Node1 root, int key)
	{
		// Base Cases: root is null or key is present at root
		if (root==null || root.data==key)
			return root;

		// val is greater than root's key
		if (root.data > key)
			return search(root.left, key);

		// val is less than root's key
		return search(root.right, key);
	}
	/**
	 * Find the node with minimum value in a Binary Search Tree
	 * http://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
	 * @param temp
	 * @return
	 */
	Node1 getMinElement(Node1 temp) {
		if(temp==null)
			return null;
		while(temp.left!=null)
			temp = temp.left;
		return temp;
	}

	/**
	 * A program to check if a binary tree is BST or not
	 * http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	 */
	static boolean isBst = true;
	Node1 prev = null;
	void isBST(Node1 root)  
	{
		if(root==null)
			return;

		isBST(root.left);
		if(prev !=null && root.data < prev.data)
			isBst = false;
		prev = root;
		isBST(root.right);
	}

	/**
	 * Inorder Successor in Binary Search Tree
	 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
	 * @param temp
	 */
	List<Node1> listOfNodes = new ArrayList<>();
	Node1 inorderSuccessor(Node1 root,Node1 k)
	{
		Node1 result = null;
		traverseInorder(root);
		for(int i=0;i<listOfNodes.size();i++) {
			if(listOfNodes.get(i).data==k.data){
				result = listOfNodes.get(++i);
				break;
			}
		}
		return result;
	}
	
	void  traverseInorder(Node1 temp) {
		if(temp == null)
			return;
		traverseInorder(temp.left);
		System.out.println(temp.data);
		listOfNodes.add(temp);
		traverseInorder(temp.right);
	}
	
	/**
	 * Binary Tree to Binary Search Tree Conversion
	 * http://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
	 * @param head
	 */
	void binaryTreeToBST(Node1 head) {
		Node1 temp = head;
		traverseInorderData(head);
		Collections.sort(listOfData);
		createInorderNodes(temp);
	}
	List<Integer> listOfData = new ArrayList<>();
	int j=0;
	void  traverseInorderData(Node1 temp) {
		if(temp == null)
			return;
		traverseInorderData(temp.left);
		listOfData.add(temp.data);
		traverseInorderData(temp.right);
	}
	
	void  createInorderNodes(Node1 temp) {
		if(temp == null)
			return;
		createInorderNodes(temp.left);
		temp.data = listOfData.get(j++);
		createInorderNodes(temp.right);
	}
	
	
	/**
	 * kth largest element in BST
	 * @param args
	 */
	int count = 0;
	void printKthLargest(Node1 root, int k)
	{
	    if (root != null && count <= k)
	    {
	    	printKthLargest(root.right, k);
	        count++;
	        if (count == k)
	          System.out.println("the " + k +"th largest element is " + root.data);
	        printKthLargest(root.left, k);
	    }
	}
	

	/**
	 * kth smallest element in BST
	 * @param args
	 */
	void printKthSmallest(Node1 root, int k)
	{
	    if (root != null && count <= k)
	    {
	    	printKthSmallest(root.left, k);
	        count++;
	        if (count == k)
	          System.out.println("the " + k +"th largest element is " + root.data);
	        printKthSmallest(root.right, k);
	    }
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		//Inserting nodes in to BST
		/*bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);*/
		
		root 			= new Node1(4);
		root.left       = new Node1(2);
		root.right      = new Node1(5);
		root.left.left  = new Node1(1);
		root.left.right = new Node1(3); 

		//bst.inOrder(root);
		
		
		//delete a BST
		//bst.deleteRef(BinarySearchTree.root);
		//bst.inOrder(root1);
		
		
		//search a BST
		/*Node1 result = bst.search(root, 10);
		if(result != null)
			System.out.println(result.data);
		else
			System.out.println("given element not not found");*/
		
		
		//Find the node with minimum value in a Binary Search Tree
		/*Node1 minNode = bst.getMinElement(root);
		if(minNode!=null)
			System.out.println("Minimum element is : " + minNode.data);
		*/
		
		//A program to check if a binary tree is BST or not
		/*root 			= new Node1(3);
		root.left       = new Node1(2);
		root.right      = new Node1(5);
		root.left.left  = new Node1(1);
		root.left.right = new Node1(4);
		bst.isBST(root);
		System.out.println(isBst);*/
		
		//Inorder Successor in Binary Search Tree
		/*Node1 result = bst.inorderSuccessor(root,root.left);
		if(result!=null)
			System.out.println("The inorder successor of " + root.left.data + " is " + result.data);*/
		
		
		//Binary Tree to Binary Search Tree Conversion
	/*	root 			= new Node1(10);
		root.left       = new Node1(2);
		root.right      = new Node1(7);
		root.left.left  = new Node1(8);
		root.left.right = new Node1(4); 

		bst.binaryTreeToBST(root);
		bst.inOrder(root);*/
		
		
		//kth largest element in BST
		/*root 			= new Node1(4);
		root.left       = new Node1(2);
		root.right      = new Node1(5);
		root.left.left  = new Node1(1);
		root.left.right = new Node1(3); 
		bst.inOrder(root);
		bst.printKthLargest(root, 1);*/
		
		//kth smallest element in BST
		//bst.printKthSmallest(root, 2);
		
	}
}
