package org.gilgi.chemination.core;

import java.util.ArrayList;
import java.util.List;

import org.gilgi.chemination.core.exception.InvalidConnectivityException;
import org.gilgi.chemination.graph.MoleculeGraph;

public class Molecule {
	
	private List<MoleculeGraph> resonance;
	
	public Molecule(MoleculeGraph connectivity) throws InvalidConnectivityException {
		resonance = new ArrayList<MoleculeGraph>();
		resonance.add(connectivity);
		if (!resonance.get(0).validate()) {
			throw new InvalidConnectivityException();
		}
	}
	
}
