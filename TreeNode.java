package com.ob.sort;

public class TreeNode {

	private int key;
	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int key) {
		this.key = key;
		parent = null;
		left = null;
		right = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode getRight() {
		return right;
	}
}
