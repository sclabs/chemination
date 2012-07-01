package org.gilgi.chemination.graph;

import org.gilgi.graph.Graph;
import org.gilgi.graph.Node;

public class MoleculeGraph<N extends Node<N>> extends Graph<N> {

	public MoleculeGraph(N n) {
		super(n);
	}

	public int numBonds(N n) {
		int count = 0;
		for (N m : n.getNeighbors()) {
			if (m.equals(n))
				count++;
		}
		return count;
	}

}
