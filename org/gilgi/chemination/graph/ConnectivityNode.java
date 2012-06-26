package org.gilgi.chemination.graph;

import org.gilgi.chemination.Atom;

public class ConnectivityNode extends Node {
	
	private final Atom atom;

	public ConnectivityNode(Atom atom) {
		super();
		this.atom = atom;
	}
	
	public Atom getAtom() {
		return atom;
	}
}
