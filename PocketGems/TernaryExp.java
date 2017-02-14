import java.util.*;
public class TernaryExp {
	class Node {
		char c;
		Node left;
		Node right;
		public Node(char c) {
			this.c = c;
		}
	}
	public Node toTree(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		Deque<Node> stack = new ArrayDeque<>();
		Node root = new Node(s.charAt(0));
		stack.push(root);
		boolean isLeft = true;
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			Node node = new Node(s.charAt(i + 1));
			
			
			if (c == '?') {
				stack.peek().left = node;
				//stack.push(node);
				//isLeft = true;
			} else if (c == ':') {
				if (stack.isEmpty()) {
					return null;
				}
				stack.pop();
				while (stack.peek().right != null) {
					stack.pop();
				}
				stack.peek().right = node;
			}
			stack.push(node);

		}
		return root;

	}

	public static void main(String[] args) {
		TernaryExp t = new TernaryExp();
		String s = "a?b?d:e?f:g:c";
		Node root = t.toTree(s);
		System.out.println(root.left.right.right.c);
	}
}