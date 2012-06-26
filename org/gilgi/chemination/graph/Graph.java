package org.gilgi.chemination.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

	// this is the only reference into the graph so be careful with it
	// override this
	private Node active;

	// override this
	public Graph() {
		active = new Node();
	}

	// private constructor only used for separate()
	// override this
	private Graph(Node n) {
		active = n;
	}

	// override this
	public Node getActive() {
		return active;
	}

	public List<Node> getNeighbors() {
		return getActive().getNeighbors();
	}

	// adds to active node
	public void addNode(Node n) {
		getActive().addNeighbor(n);
		n.addNeighbor(getActive());
	}

	// cuts link, keeps active side, discards rest of graph if no cycle
	public void cut(Node n) {
		getActive().removeNeighbor(n);
		n.removeNeighbor(getActive());
	}

	// you keep the active side of the cut, other side is returned as a graph
	// override this
	public Graph separate(Node n) {
		if (contains(n)) {
			Graph newGraph = new Graph(n);
			// cut old graph active side
			cut(n);
			// cut new graph n side
			newGraph.cut(active);
			return newGraph;
		}
		return null;
	}

	public void setActive(Node n) {
		if (contains(n)) {
			active = n;
		}
	}

	// bfs for n from origin
	public boolean contains(Node n) {
		return bfs(n, getActive());
	}

	public boolean bfs(Node n, Node origin) {
		if (n.equals(origin))
			return true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(origin);
		List<Node> seen = new ArrayList<Node>();
		seen.add(origin);
		while (!queue.isEmpty()) {
			Node next = queue.remove();
			for (Node m : next.getNeighbors()) {
				if (m.equals(n))
					return true;
				if (!seen.contains(m)) {
					queue.add(m);
					seen.add(m);
				}
			}
		}
		return false;
	}
}
