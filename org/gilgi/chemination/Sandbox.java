package org.gilgi.chemination;

import org.gilgi.chemination.graph.Graph;
import org.gilgi.chemination.graph.Node;
import org.gilgi.chemination.graph.NodeFactory;

public class Sandbox {

	public static void main(String[] args) {
		NodeFactory f = new NodeFactory();
		Graph<Node> g = new Graph<Node>(f);
		Node firstGNode = g.getActive();
		Node secondGNode = new Node();
		g.addNode(secondGNode);
		System.out.println(g.contains(secondGNode));
		g.setActive(g.getNeighbors().get(0));
		System.out.println(g.contains(firstGNode));
		System.out.println(g.getActive().equals(firstGNode));
	}
	
}
