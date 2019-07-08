package gui;

import java.util.Stack;

public class BSTIterator {
	Stack<Node> stack;
	
	public BSTIterator(Node root) {
		stack = new Stack<Node>();
		while (root != null) {
		stack.push(root);
		root = root.left;		
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	public int next() {
		Node node = stack.pop();
		int result = 0;
		if(node!=null) {
			result = node.key;
		}
		if(node.right != null) {
			node = node.right;
			while(node!=null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
}
