package org.gilgi.chemination;

public class Atom {
	
	public final int atomicNumber;
	public final double electronegativity;
	public final double atomicRadius;
	
	public Atom(int atomicNumber, double electronegativity, double atomicRadius) {
		this.atomicNumber = atomicNumber;
		this.electronegativity = electronegativity;
		this.atomicRadius = atomicRadius;
	}

}
