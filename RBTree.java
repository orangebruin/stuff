package com.ob.sort;

import com.ob.sort.RBTreeNode.Color;

public class RBTree {

	private RBTreeNode sentinal;
	private RBTreeNode root;
	
	public RBTree() {
		sentinal = new RBTreeNode(-1);
		sentinal.setColor(Color.BLACK);
		root = sentinal;
	}
	
	public RBTreeNode getRoot() {
		return root;
	}
	
	public void insert(RBTreeNode node) {
		RBTreeNode x = root, y = sentinal, z = node;
		
		while (x != sentinal) {
			y = x;
			if (z.getKey() < x.getKey())
				x = x.getLeft();
			else
				x = x.getRight();
		}
		
		z.setParent(y);
		if (y == sentinal)
			root = z;
		else if (z.getKey() < y.getKey())
			y.setLeft(z);
		else
			y.setRight(z);
		
		z.setLeft(sentinal);
		z.setRight(sentinal);
		z.setColor(Color.RED);
		insertFixup(z);
	}
	
	private void insertFixup(RBTreeNode node) {
		RBTreeNode z = node, y = null;
		
		while (z.getParent().getColor() == Color.RED) {
			if (z.getParent() == z.getParent().getParent().getLeft()) {
				y = z.getParent().getParent().getRight();
				if (y.getColor() == Color.RED) {
					z.getParent().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getRight()) {
						z = z.getParent();
						leftRotate(z);
					}
					z.getParent().setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					rightRotate(z.getParent().getParent());
				}
			} else {
				y = z.getParent().getParent().getLeft();
				if (y.getColor() == Color.RED) {
					z.getParent().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getLeft()) {
						z = z.getParent();
						rightRotate(z);
					}
					z.getParent().setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					leftRotate(z.getParent().getParent());
				}
			}
		}
		
		root.setColor(Color.BLACK);
	}
	
	public void delete(RBTreeNode node) {
		RBTreeNode x = sentinal, y = sentinal, z = node;
		
		if (z.getLeft() == sentinal || z.getRight() == sentinal)
			y = z;
		else
			y = getSuccessor(z);
		
		if (y.getLeft() != sentinal)
			x = y.getLeft();
		else
			x = y.getRight();
		
		x.setParent(y.getParent());
		if (y.getParent() == sentinal)
			root = x;
		else if (y == y.getParent().getLeft())
			y.getParent().setLeft(x);
		else
			y.getParent().setRight(x);
		
		if (y != z)
			z.setKey(y.getKey());
		
		if (y.getColor() == Color.BLACK)
			deleteFixup(x);
	}
	
	private void deleteFixup(RBTreeNode node) {
		RBTreeNode x = node, w = sentinal;
		
		while (x != root && x.getColor() == Color.BLACK) {
			if (x == x.getParent().getLeft()) {
				w = x.getParent().getRight();
				if (w.getColor() == Color.RED) {
					w.setColor(Color.BLACK);
					x.getParent().setColor(Color.RED);
					leftRotate(x.getParent());
					w = x.getParent().getRight();
				}
				if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
					w.setColor(Color.RED);
					x = x.getParent();
				} else {
					if (w.getRight().getColor() == Color.BLACK) {
						w.getLeft().setColor(Color.BLACK);
						w.setColor(Color.RED);
						rightRotate(w);
						w = x.getParent().getRight();
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Color.BLACK);
					w.getRight().setColor(Color.BLACK);
					leftRotate(x.getParent());
					x = root;
				}
			} else {
				w = x.getParent().getLeft();
				if (w.getColor() == Color.RED) {
					w.setColor(Color.BLACK);
					x.getParent().setColor(Color.RED);
					rightRotate(x.getParent());
					w = x.getParent().getLeft();
				}
				if (w.getRight().getColor() == Color.BLACK && w.getLeft().getColor() == Color.BLACK) {
					w.setColor(Color.RED);
					x = x.getParent();
				} else {
					if (w.getLeft().getColor() == Color.BLACK) {
						w.getRight().setColor(Color.BLACK);
						w.setColor(Color.RED);
						leftRotate(w);
						w = x.getParent().getLeft();
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Color.BLACK);
					w.getLeft().setColor(Color.BLACK);
					rightRotate(x.getParent());
					x = root;
				}
			}
		}
		x.setColor(Color.BLACK);
	}
	
	private void leftRotate(RBTreeNode node) {
		RBTreeNode x = node, y = sentinal;
		
		if (x.getRight() == sentinal)
			return;
		
		y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != sentinal)
			y.getLeft().setParent(x);
		
		y.setParent(x.getParent());
		if (x.getParent() == sentinal)
			root = y;
		else if (x == x.getParent().getLeft())
			x.getParent().setLeft(y);
		else
			x.getParent().setRight(y);
		
		y.setLeft(x);
		x.setParent(y);
	}
	
	private void rightRotate(RBTreeNode node) {
		RBTreeNode x = sentinal, y = node;
		
		if (y.getLeft() == sentinal)
			return;
		
		x = y.getLeft();
		y.setLeft(x.getRight());
		if (x.getRight() != sentinal)
			x.getRight().setParent(y);
		
		x.setParent(y.getParent());
		if (y.getParent() == sentinal)
			root = x;
		else if (y == y.getParent().getRight())
			y.getParent().setRight(x);
		else
			y.getParent().setLeft(x);
		
		x.setRight(y);
		y.setParent(x);
	}
	
	public RBTreeNode getSuccessor(RBTreeNode node) {
		RBTreeNode y = sentinal, x = node;
		
		if (node.getRight() != sentinal)
			return minimum(node.getRight());
		
		y = node.getParent();
		while (y != sentinal && x == y.getRight()) {
			x = y;
			y = y.getParent();
		}
		
		return y;
	}
	
	public RBTreeNode minimum(RBTreeNode node) {
		RBTreeNode retVal = node;
		
		while (retVal.getLeft() != sentinal)
			retVal = retVal.getLeft();
		
		return retVal;
	}
	
	public void printInorder() {
		inorder(root);
		System.out.println();
	}
	
	private void inorder(RBTreeNode node) {
		if (node.getLeft() != sentinal)
			inorder(node.getLeft());
		
		System.out.print(node.getKey() + ":" + node.getColor() + " ");
		
		if (node.getRight() != sentinal)
			inorder(node.getRight());
	}
	
	public void printPreorder() {
		preorder(root);
		System.out.println();
	}
	
	private void preorder(RBTreeNode node) {
		System.out.print(node.getKey() + ":" + node.getColor() + " ");
		
		if (node.getLeft() != sentinal)
			preorder(node.getLeft());
		
		if (node.getRight() != sentinal)
			preorder(node.getRight());
	}
	
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}
	
	private void postorder(RBTreeNode node) {
		if (node.getLeft() != sentinal)
			postorder(node.getLeft());
		
		if (node.getRight() != sentinal)
			postorder(node.getRight());
		
		System.out.print(node.getKey() + ":" + node.getColor() + " ");
	}
	
	public static void main(String[] args) {
		RBTree rb = new RBTree();
		
		rb.insert(new RBTreeNode(10));
		rb.insert(new RBTreeNode(34));
		rb.insert(new RBTreeNode(1));
		rb.insert(new RBTreeNode(7));
		rb.insert(new RBTreeNode(4));
		rb.insert(new RBTreeNode(17));
		rb.insert(new RBTreeNode(23));
		rb.insert(new RBTreeNode(8));
		
		rb.printInorder();
		rb.printPreorder();
		rb.printPostorder();
	}
}
