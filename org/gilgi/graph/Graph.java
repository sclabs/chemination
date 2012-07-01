package org.gilgi.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph<N extends Node<N>> {

	private N active;

	public Graph(N n) {
		active = n;
	}

	public N getActive() {
		return active;
	}

	public List<N> getNeighbors() {
		return active.getNeighbors();
	}

	// adds to active node
	public void addNode(N n) {
		active.addNeighbor(n);
		n.addNeighbor(active);
	}

	// cuts link, keeps active side, discards rest of graph if no cycle
	public void cut(N n) {
		active.removeNeighbor(n);
		n.removeNeighbor(active);
	}

	// you keep the active side of the cut, other side is returned as a graph
	public Graph<N> separate(N n) {
		if (contains(n)) {
			Graph<N> newGraph = new Graph<N>(n);
			// cut old graph active side
			cut(n);
			// cut new graph n side
			newGraph.cut(active);
			return newGraph;
		}
		return null;
	}

	public void setActive(N n) {
		if (contains(n)) {
			active = n;
		}
	}

	// bfs for n from origin
	public boolean contains(N n) {
		return bfs(n, active);
	}

	public boolean bfs(N n, N origin) {
		if (n.equals(origin))
			return true;
		Queue<N> queue = new LinkedList<N>();
		queue.add(origin);
		List<N> seen = new ArrayList<N>();
		seen.add(origin);
		while (!queue.isEmpty()) {
			N next = queue.remove();
			for (N m : next.getNeighbors()) {
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
	
	public int numBonds(N n) {
		int count = 0;
		for (N m : (List<N>) n.getNeighbors()) {
			if (m.equals(n)) count++;
		}
		return count;
	}
	
}
