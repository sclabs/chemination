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
		return 0;
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
	
}
