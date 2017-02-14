import java.util.*;
public class ShortestPath {
	class Node {
		int x;
		int y;
		Set<Character> keys;
		Node parent;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			keys = new HashSet<>();
		}
		@Override
		public boolean equals(Object object) {
			Node node = (Node)object;
			return x == node.x && y == node.y && keys.equals(node.keys);
		}
		@Override
		public int hashCode() {
			return keys.hashCode() + x + y;
		}
	}


	private int[] dx = {-1, 0, 1, 0};
	private int[] dy = {0, 1, 0, -1};
	public Node findPath(String[] map, int sx, int sy) {
		if (map == null || map.length == 0 || map[0].length() == 0 || map[sy].charAt(sx) != '2') {
			//System.out.println("im here");
			return null;
		}
		//System.out.println(sx + " " + sy);
		Deque<Node> queue = new ArrayDeque<>();
		Set<Node> visited = new HashSet<>();
		Node start = new Node(sx, sy);
		//System.out.println(start.x + " " + start.y);
		queue.offer(start);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.println(current.x + " " + current.y);
			int x = current.x;
			int y = current.y;
			if (map[y].charAt(x) == '3') {
				return current;
			}
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if (newX < 0 || newX >= map[0].length() || newY < 0 || newY >= map.length) {
					continue;
				}
				char c = map[newY].charAt(newX);
				if (c == '0') {
					continue;
				}
				if (c >= 'A' && c <= 'Z') {
					char key = (char)(c - 'A' + 'a');
					if (!current.keys.contains(key)) {
						continue;
					}
				}
				Node next = new Node(newX, newY);
				next.parent = current;
				next.keys.addAll(current.keys);
				
				if (!visited.contains(next)) {
					if (Character.isLowerCase(c)) {
						next.keys.add(c);
					}
					queue.offer(next);
					visited.add(next);

				}
			}

		}
		return null;

	}

	public static void main(String[] args) {
		Solution s = new ShortestPath();
		String[] map = {"02a11", 
                        "0100A", 
                        "01003", 
                        "01001", 
                        "01111"}; 
        Node dest = s.findPath(map, 1, 0);
        if (dest == null) {
            System.out.println("no path");
        } else {
          	while (dest != null) {
            	System.out.println(dest);
                dest = dest.parent;
                } 
            }
		}
}