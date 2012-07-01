package org.gilgi.graph;

import java.util.ArrayList;
import java.util.List;

public class SimpleNode implements Node<SimpleNode> {
	
	private List<SimpleNode> neighbors;
	
	public SimpleNode() {
		neighbors = new ArrayList<SimpleNode>();
	}
	
	public List<SimpleNode> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(SimpleNode n) {
		neighbors.add(n);
	}
	
	public void removeNeighbor(SimpleNode n) {
		neighbors.remove(n);
	}
	
	public boolean hasNeighbor(SimpleNode n) {
		return neighbors.contains(n);
	}
	
}
