package org.gilgi.chemination.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private List<Node> neighbors;
	
	public Node() {
		neighbors = new ArrayList<Node>();
	}
	
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Node n) {
		neighbors.add(n);
	}
	
	public void removeNeighbor(Node n) {
		neighbors.remove(n);
	}
	
	public boolean hasNeighbor(Node n) {
		return neighbors.contains(n);
	}
	
}
