package org.gilgi.chemination;

import org.gilgi.graph.Graph;
import org.gilgi.graph.SimpleNode;

public class Sandbox {

	public static void main(String[] args) {
		SimpleNode firstGNode = new SimpleNode();
		Graph<SimpleNode> g = new Graph<SimpleNode>(firstGNode);
		SimpleNode secondGNode = new SimpleNode();
		g.addNode(secondGNode);
		System.out.println(g.contains(secondGNode));
		g.setActive(g.getNeighbors().get(0));
		System.out.println(g.contains(firstGNode));
		System.out.println(g.getActive().equals(firstGNode));
		
		System.out.println();
	}

}
