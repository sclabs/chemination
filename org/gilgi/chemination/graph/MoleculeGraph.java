package org.gilgi.chemination.graph;

import org.gilgi.chemination.core.Atom;
import org.gilgi.graph.Graph;

public class MoleculeGraph extends Graph<AtomNode> {

	public MoleculeGraph(AtomNode n) {
		super(n);
	}

	public int numBonds(AtomNode n) {
		int count = 0;
		for (AtomNode m : n.getNeighbors()) {
			if (m.equals(n))
				count++;
		}
		return count;
	}
	
	public int numBonds() {
		return getActive().getBonds();
	}
	
	public Atom getAtom() {
		return getActive().getAtom();
	}

}
