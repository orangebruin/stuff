package com.ob.sort;

public class RBTreeNode {

	public enum Color { BLACK, RED }
	
	private int key;
	private Color color;
	private RBTreeNode left;
	private RBTreeNode right;
	private RBTreeNode parent;
	
	public RBTreeNode(int key) {
		this.key = key;
		color = null;
		left = null;
		right = null;
		parent = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setParent(RBTreeNode parent) {
		this.parent = parent;
	}
	
	public RBTreeNode getParent() {
		return parent;
	}
	
	public void setLeft(RBTreeNode left) {
		this.left = left;
	}
	
	public RBTreeNode getLeft() {
		return left;
	}
	
	public void setRight(RBTreeNode right) {
		this.right = right;
	}
	
	public RBTreeNode getRight() {
		return right;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
