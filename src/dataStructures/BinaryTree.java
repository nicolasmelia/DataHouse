package dataStructures;

import java.util.LinkedList;

public class BinaryTree {
	public Node root;
		
	public void addNode(int key, String value){
		Node newNode = new Node(key, value);

		if (root == null) {
			root = newNode;
		} else {
			Node parentNode = root;
			while (true) {				 
				if (key < parentNode.key) {
					if (parentNode.leftChild == null) {
						parentNode.leftChild = newNode;
						break;
					} 
					parentNode = parentNode.leftChild;
				} else {				
					if (parentNode.rightChild == null) {
						parentNode.rightChild = newNode;	
						break;
					} 
					parentNode = parentNode.rightChild;								
				}				
			}		
		}		
	}
	
	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {		
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;		
			} else {
				focusNode = focusNode.rightChild;	
			}		
			
			if (focusNode == null) return null;
			
		}
		
		return focusNode;
		
	}
	

	public void invertTree(Node focusNode) {
		if (focusNode == null){
			return;
		}
		 
		Node TempNode = focusNode.rightChild;
		focusNode.rightChild = focusNode.leftChild;
		focusNode.leftChild = TempNode;
		
		invertTree(focusNode.leftChild);
		invertTree(focusNode.rightChild);	
	}
	
	public int getMaxKey(Node focusNode) {		
		 while (focusNode.rightChild != null) {
			 focusNode = focusNode.rightChild;
		 }
		 return focusNode.key;
	}
	
	public BinaryTree createSampTree(int[] keys){
    	BinaryTree BST = new BinaryTree();	
    	
    	if (keys == null) {
	    	for (int i = 0; i <= 10; i++) {
	        	BST.addNode((int)(Math.random() * (100 - 10 + 1) + 10), "Value of " + i);    		
	    	}
    	} else {
	    	for (int i = 0; i < keys.length; i++) {
	        	BST.addNode((int)(keys[i]), "Value of " + i);    		
	    	}
    	}
    	return BST;
	}
	
	// ************* Traversal Methods (Depth-first search) *************	
	//Inorder: left, root, right
	public void inorderTraversal(Node focusNode) {
		if (focusNode != null){
			inorderTraversal(focusNode.leftChild);
			System.out.println(focusNode);
			inorderTraversal(focusNode.rightChild);		
		}	
	}
	
	//preorder: root, let, right
	public void preorderTraversal(Node focusNode) {
		if (focusNode != null){
			System.out.print(focusNode);
			preorderTraversal(focusNode.leftChild);
			preorderTraversal(focusNode.rightChild);	
		}
	}
	
	//postorder: left, right, root
	public void postorderTraversal(Node focusNode) {
		if (focusNode != null){
			postorderTraversal(focusNode.leftChild);
			postorderTraversal(focusNode.rightChild);	
			System.out.println(focusNode);
		}
	}
	
	
	//Breadth-first search
	public void levelOrder(Node root) {
		if (root == null) return;
		Queue<Node> q = new Queue<Node>(100);
		q.add(root);
		
		while (!q.isEmpty()) {
			Node currNode = q.poll();
			if (currNode.leftChild != null) q.add(currNode.leftChild);
			if (currNode.rightChild != null) q.add(currNode.rightChild);
			System.out.println(currNode);			
		}
	}
		
	public int getMax(Node root) { //check if root is null
		   if(root.rightChild == null) {
		       return root.key; 
		   } else {
		       return getMax(root.rightChild);
		   }
		}
	
	//Get children of a node
	public Node getRightChild(Node node){
		return node.rightChild;	
	}
	public Node getLeftChild(Node node){
		return node.leftChild;	
	}	

}

class Node {
	int key;
	String value;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	public String toString(){
		return key + " " + value;
	}
	
	
	
	
}
