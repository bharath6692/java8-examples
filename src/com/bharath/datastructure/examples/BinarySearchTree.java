package com.bharath.datastructure.examples;


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
	static Node1 root1;
	
	void inOrder(Node1 temp) {
		if(temp == null)
			return;
		inOrder(temp.left);
		System.out.println(temp.data);
		inOrder(temp.right);
	}
	
	void deleteATree(Node1 temp) {
		if(temp == null)
			return;
		deleteATree(temp.left);
		deleteATree(temp.right);
		System.out.println("deleted " + temp.data);
		temp = null;
	}
	
	
	void deleteRef(Node1 temp) {
		root1 = temp;
		deleteATree(temp);
		root=null;
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
	
	// This method mainly calls insertRec()
    void insert(int key) {
       root = insertRec(root, key);
    }
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
	
	Node1 getMinElement(Node1 temp) {
		if(temp==null)
			return null;
		while(temp.left!=null)
			temp = temp.left;
		return temp;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		
		bst.inOrder(root);
		//bst.deleteRef(BinarySearchTree.root);
		//bst.inOrder(root1);
		Node1 result = bst.search(root, 10);
		Node1 minNode = bst.getMinElement(root);
		if(minNode!=null)
			System.out.println("Minimum element is : " + minNode.data);
		if(result != null)
			System.out.println(result.data);
		else
			System.out.println("given element not not found");
	}
}
