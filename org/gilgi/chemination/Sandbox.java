package org.gilgi.chemination;

import org.gilgi.chemination.graph.AtomNode;
import org.gilgi.chemination.graph.MoleculeGraph;
import org.gilgi.chemination.util.PeriodicTable;
import org.gilgi.graph.Graph;
import org.gilgi.graph.SimpleNode;

public class Sandbox {

	public static void main(String[] args) {
		// test Graph<SimpleNode>
		SimpleNode firstGNode = new SimpleNode();
		Graph<SimpleNode> g = new Graph<SimpleNode>(firstGNode);
		SimpleNode secondGNode = new SimpleNode();
		g.addNode(secondGNode);
		System.out.println(g.contains(secondGNode));
		g.setActive(g.getNeighbors().get(0));
		System.out.println(g.contains(firstGNode));
		System.out.println(g.getActive().equals(firstGNode));
		
		System.out.println();
		
		// test MoleculeGraph
		AtomNode centerAtom = new AtomNode(PeriodicTable.C);
		MoleculeGraph graph = new MoleculeGraph(centerAtom);
		AtomNode h1 = new AtomNode(PeriodicTable.H);
		AtomNode h2 = new AtomNode(PeriodicTable.H);
		AtomNode h3 = new AtomNode(PeriodicTable.H);
		graph.addNode(h1);
		graph.addNode(h2);
		graph.addNode(h3);
		System.out.println(graph.getAtom().atomicNumber);
		System.out.println(graph.getActive().equals(centerAtom));
		System.out.println(graph.contains(h2));
		graph.setActive(graph.getNeighbors().get(0));
		System.out.println(graph.getAtom().atomicNumber);
		System.out.println(graph.contains(centerAtom));
		
		System.out.println();
		
		// test graph iteration
		for (AtomNode n : graph) {
			System.out.println(n.getAtom().atomicNumber);
		}
	}
	
}
