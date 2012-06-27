package org.gilgi.chemination;

import org.gilgi.chemination.graph.Graph;
import org.gilgi.chemination.graph.Node;

public class Sandbox {

	public static void main(String[] args) {
		Node firstGNode = new Node();
		Graph<Node> g = new Graph<Node>(firstGNode);
		Node secondGNode = new Node();
		g.addNode(secondGNode);
		System.out.println(g.contains(secondGNode));
		g.setActive(g.getNeighbors().get(0));
		System.out.println(g.contains(firstGNode));
		System.out.println(g.getActive().equals(firstGNode));
	}
	
}
