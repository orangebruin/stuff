package com.ob.sort;

public class BinaryTree {

	private TreeNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public void insert(TreeNode z) {
		TreeNode y = null;
		TreeNode x = root;
		
		while (x != null) {
			y = x;
			if (z.getKey() < x.getKey())
				x = x.getLeft();
			else
				x = x.getRight();
		}
		
		z.setParent(y);
		if (y == null)
			root = z;
		else if (z.getKey() < y.getKey())
			y.setLeft(z);
		else
			y.setRight(z);
	}
	
	public void delete(TreeNode z) {
		TreeNode y = null, x = null;
		
		if (z.getLeft() == null || z.getRight() == null)
			y = z;
		else
			y = getSuccessor(z);
		
		if (y.getLeft() != null)
			x = y.getLeft();
		else
			x = y.getRight();
		
		if (x != null)
			x.setParent(y.getParent());
		
		if (y.getParent() == null)
			root = x;
		else if (y == y.getParent().getLeft())
			y.getParent().setLeft(x);
		else
			y.getParent().setRight(x);
		
		if (y != z)
			y.setKey(z.getKey());
	}
	
	public TreeNode getSuccessor(TreeNode node) {
		TreeNode y = null, x = node;
		
		if (node.getRight() != null)
			return minimum(node.getRight());
		
		y = node.getParent();
		while (y != null && x == y.getRight()) {
			x = y;
			y = y.getParent();
		}
		
		return y;
	}
	
	public TreeNode minimum(TreeNode node) {
		TreeNode retVal = node;
		
		while (retVal.getLeft() != null)
			retVal = retVal.getLeft();
		
		return retVal;
	}
	
	public TreeNode maximum(TreeNode node) {
		TreeNode retVal = node;
		
		while (retVal.getRight() != null)
			retVal = retVal.getRight();
		
		return retVal;
	}
	
	public void printInorder() {
		inorder(root);
	}
	
	private void inorder(TreeNode node) {
		if (node.getLeft() != null)
			inorder(node.getLeft());
		
		System.out.print(node.getKey() + " ");
		
		if (node.getRight() != null)
			inorder(node.getRight());
	}
	
	public void printPreorder() {
		preorder(root);
	}
	
	private void preorder(TreeNode node) {
		System.out.print(node.getKey() + " ");
		
		if (node.getLeft() != null)
			preorder(node.getLeft());
		
		if (node.getRight() != null)
			preorder(node.getRight());
	}
	
	public void printPostorder() {
		postorder(root);
	}
	
	private void postorder(TreeNode node) {
		if (node.getLeft() != null)
			postorder(node.getLeft());
		
		if (node.getRight() != null)
			postorder(node.getRight());
		
		System.out.print(node.getKey() + " ");
	}
	
	public TreeNode getNode(TreeNode node, int key) {
		if (node == null || key == node.getKey())
			return node;
		
		if (key < node.getKey())
			return getNode(node.getLeft(), key);
		else
			return getNode(node.getRight(), key);
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.insert(new TreeNode(10));
		bt.insert(new TreeNode(34));
		bt.insert(new TreeNode(1));
		bt.insert(new TreeNode(7));
		bt.insert(new TreeNode(4));
		bt.insert(new TreeNode(17));
		bt.insert(new TreeNode(23));
		bt.insert(new TreeNode(8));
		
		bt.printInorder();
		System.out.println();
		bt.printPreorder();
		System.out.println();
		bt.printPostorder();
		System.out.println();
		
		System.out.println("Get the node with key 4 " + bt.getNode(bt.getRoot(), 4).getKey());
		
		System.out.println("The minimum is " + bt.minimum(bt.getRoot()).getKey());
		System.out.println("The maximum is " + bt.maximum(bt.getRoot()).getKey());
		System.out.println("The successor of the root is " + bt.getSuccessor(bt.getNode(bt.getRoot(), 7)).getKey());
		
		bt.delete(bt.getNode(bt.getRoot(), 7));
		bt.printInorder();
	}
}
