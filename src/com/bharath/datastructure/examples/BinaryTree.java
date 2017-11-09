package com.bharath.datastructure.examples;


// Recursive optimized Java program to find the diameter of a
// Binary Tree

/* Class containing left and right child of current
Node2 and key value*/
class Node2
{
	int data, lc, rc;
	Node2 left, right;

	public Node2(int item)
	{
		data = item;
		left = right = null;
		lc = rc = 0;
	}
}

/* Class to print the Diameter */
class BinaryTree
{
	Node2 head;

	/* Method to calculate the diameter and return it to main */
	int diameter(Node2 root)
	{
		/* base case if tree is empty */
		if (root == null )
			return 0;

        if(root.left != null) {
            root.lc++;
            root.lc = root.lc + diameter(root.left);
        }
            
        if(root.right != null) {
            root.rc++;
            root.rc = root.rc + diameter(root.right);
        }
        if(root != head) {
        	if(root.lc<=root.rc){
                return root.rc;
            }else {
                return root.lc;
            }
        } else {
        	return 0;
        }
	}

	/* A wrapper over diameter(Node2 root) */
	int diameter()
	{
		return diameter(head);
	}

	public static void main(String args[])
	{
		/* creating a binary tree and entering the Node2s */
		BinaryTree tree = new BinaryTree();
		tree.head = new Node2(1);
		tree.head.left = new Node2(2);
		tree.head.right = new Node2(7);
		tree.head.left.left = new Node2(3);
		tree.head.left.right = new Node2(4);
		tree.head.left.right.left = new Node2(5);
		tree.head.left.right.right = new Node2(6);
        
        tree.head.right.right = new Node2(8);
        tree.head.right.right.right = new Node2(9);
        tree.head.right.right.right.left = new Node2(10);
        tree.head.right.right.right.right = new Node2(13);
        tree.head.right.right.right.left.left = new Node2(11);
        tree.head.right.right.right.left.right = new Node2(12);
		System.out.println("The diameter of given binary tree is : "
						+ tree.diameter());
		System.out.println(tree.head.lc + tree.head.rc);
	}
}
