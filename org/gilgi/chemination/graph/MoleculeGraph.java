package org.gilgi.chemination.graph;

import java.util.List;

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

	public boolean validate() {
		for (AtomNode n : this) {
			if (n.getSigmaBonds() > n.getAtom().maxHybridization)
				return false;
		}
		return true;
	}
	
	public List<AtomNode> getUniqueNeighbors() {
		return getActive().getUniqueNeighbors();
	}

}
