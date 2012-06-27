package org.gilgi.chemination;

import org.gilgi.chemination.graph.ConnectivityNode;
import org.gilgi.chemination.graph.Graph;
import org.gilgi.chemination.graph.Node;
import org.gilgi.chemination.util.PeriodicTable;

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
		
		System.out.println();
		
		ConnectivityNode firstCNode = new ConnectivityNode(PeriodicTable.C);
		Graph<ConnectivityNode> c = new Graph<ConnectivityNode>(firstCNode);
		ConnectivityNode secondCNode = new ConnectivityNode(PeriodicTable.H);
		c.addNode(secondCNode);
		System.out.println(c.getActive().getAtom().atomicNumber);
		System.out.println(c.contains(secondCNode));
		c.setActive(c.getNeighbors().get(0));
		System.out.println(c.getActive().getAtom().atomicNumber);
		System.out.println(c.contains(firstCNode));
		System.out.println(c.getActive().equals(firstCNode));
	}

}
