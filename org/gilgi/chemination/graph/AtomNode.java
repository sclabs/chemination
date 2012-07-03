package org.gilgi.chemination.graph;

import java.util.ArrayList;
import java.util.List;

import org.gilgi.chemination.core.Atom;
import org.gilgi.graph.Node;

public class AtomNode implements Node<AtomNode> {
	
	private List<AtomNode> neighbors;
	private final Atom atom;
	private int hybridization;
	private int lonePairs;
	private int radicals;
	
	public AtomNode(Atom atom) {
		neighbors = new ArrayList<AtomNode>();
		this.atom = atom;
		hybridization = 1;
		lonePairs = atom.valenceElectrons / 2;
		radicals = atom.valenceElectrons % 2;
	}
	
	public List<AtomNode> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(AtomNode n) {
		neighbors.add(n);
	}
	
	public void removeNeighbor(AtomNode n) {
		neighbors.remove(n);
	}
	
	public boolean hasNeighbor(AtomNode n) {
		return neighbors.contains(n);
	}
	
	public Atom getAtom() {
		return atom;
	}
	
	public int getLonePairs() {
		return lonePairs;
	}

	public void setLonePairs(int lonePairs) {
		this.lonePairs = lonePairs;
	}
	
	public void addLonePair() {
		lonePairs++;
	}
	
	public void removeLonePair() {
		lonePairs--;
	}

	public int getRadicals() {
		return radicals;
	}

	public void setRadicals(int radicals) {
		this.radicals = radicals;
	}
	
	public void addRadical() {
		radicals++;
	}
	
	public void removeRadical() {
		radicals--;
	}

	public int getElectrons() {
		return getBonds() + (getLonePairs() * 2) + getRadicals();
	}
	
	public int getFormalCharge() {
		return atom.atomicNumber - getElectrons();
	}
	
	public int getBonds() {
		return neighbors.size();
	}

	public int getHybridization() {
		return hybridization;
	}

	public void setHybridization(int hybridization) {
		this.hybridization = hybridization;
	}
	
	public int getGeometry() {
		return getUniqueNeighbors().size() + lonePairs + radicals;
	}
	
	public List<AtomNode> getUniqueNeighbors() {
		List<AtomNode> result = new ArrayList<AtomNode>();
		for (AtomNode n : getNeighbors()) {
			if (!result.contains(n)) {
				result.add(n);
			}
		}
		return result;
	}
	
	public int getSigmaBonds() {
		return getUniqueNeighbors().size();
	}
	
	public int getPiBonds() {
		return getBonds() - getSigmaBonds();
	}
	
	public int getLooseElectrons() {
		return (getLonePairs() * 2) + getRadicals();
	}

	public void removeLooseElectron() {
		if (radicals != 0)
			radicals--;
		else {
			lonePairs--;
			radicals++;
		}
	}

	public void addLooseElectron() {
		if (radicals != 0) {
			lonePairs++;
			radicals--;
		} else {
			radicals++;
		}
	}
	
	public void makeBond(AtomNode n) {
		// for covalent bond, each atom has to have an electron to contribute
		if (getLooseElectrons() == 0 || n.getLooseElectrons() == 0) return;
		// if this is supposed to be sigma, check hybridizations
		if (!hasNeighbor(n)) {
			if (getSigmaBonds() + 1 > hybridization) {
				if (hybridization + 1 > atom.maxHybridization) return;
				if (n.getSigmaBonds() + 1 > n.hybridization) {
					if (n.hybridization + 1 > n.atom.maxHybridization) return;
				}
			}
		}
		// change the hybridizations if necessary
		//TODO fix this
		addNeighbor(n);
	}

}
