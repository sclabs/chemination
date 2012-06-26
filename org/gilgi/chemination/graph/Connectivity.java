package org.gilgi.chemination.graph;

import org.gilgi.chemination.Atom;

public class Connectivity extends Graph {
	
	private ConnectivityNode active;
	
	// no public constructor that takes a node
	public Connectivity(Atom a) {
		active = new ConnectivityNode(a);
	}
	
	private Connectivity(ConnectivityNode n) {
		active = n;
	}
	
	// is it possible to enforce only adding ConnectivityNodes?
	/*
	public void addNode(ConnectivityNode n) {
		super.addNode(n);
	}
	*/
	
	public Atom getAtom() {
		return active.getAtom();
	}
	
	public void setActive(ConnectivityNode n) {
		if (contains(n)) {
			active = n;
		}
	}

	public ConnectivityNode getActive() {
		return active;
	}
	
	public Connectivity separate(ConnectivityNode n) {
		if (contains(n)) {
			Connectivity newGraph = new Connectivity(n);
			// cut old graph active side
			cut(n);
			// cut new graph n side
			newGraph.cut(active);
			return newGraph;
		}
		return null;
	}
}
