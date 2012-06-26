package org.gilgi.chemination;

import org.gilgi.chemination.graph.Connectivity;
import org.gilgi.chemination.graph.ConnectivityNode;
import org.gilgi.chemination.graph.Graph;
import org.gilgi.chemination.graph.Node;
import org.gilgi.chemination.util.PeriodicTable;

public class Sandbox {

	public static void main(String[] args) {
		Graph g = new Graph();
		Node firstGNode = g.getActive();
		Node secondGNode = new Node();
		g.addNode(secondGNode);
		System.out.println(g.contains(secondGNode));
		g.setActive(g.getNeighbors().get(0));
		System.out.println(g.contains(firstGNode));
		System.out.println(g.getActive().equals(firstGNode));
		
		System.out.println();
		
		Connectivity c = new Connectivity(PeriodicTable.C);
		System.out.println(c.getAtom().atomicNumber);
		ConnectivityNode firstNode = c.getActive();
		ConnectivityNode secondNode = new ConnectivityNode(PeriodicTable.H);
		c.addNode(secondNode);
		System.out.println(c.contains(secondNode));
		//System.out.println(c.contains(secondNode, c.getActive()));
		c.setActive(c.getNeighbors().get(0));
		System.out.println(c.getAtom().atomicNumber);
		System.out.println(c.contains(firstNode));
		System.out.println(c.getActive().equals(firstNode));
	}
}
