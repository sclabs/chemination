package org.gilgi.chemination;

public class Atom {

	public final int atomicNumber;
	public final double electronegativity;
	public final double atomicRadius;
	public final int valenceElectrons;
	
	public Atom(int atomicNumber, double electronegativity,
			double atomicRadius, int valenceElectrons) {

		this.atomicNumber = atomicNumber;
		this.electronegativity = electronegativity;
		this.atomicRadius = atomicRadius;
		this.valenceElectrons = valenceElectrons;
	}

	public Atom(int atomicNumber, double electronegativity, double atomicRadius) {
		this.atomicNumber = atomicNumber;
		this.electronegativity = electronegativity;
		this.atomicRadius = atomicRadius;

		// calculate valence electrons
		if (atomicNumber > 0 && atomicNumber <= 2) {
			valenceElectrons = atomicNumber;
		} else if (atomicNumber <= 18) {
			valenceElectrons = (atomicNumber - 2) % 8;
		} else if (atomicNumber <= 54) {
			int group = (atomicNumber - 18) % 18;
			if (group <= 2) {
				valenceElectrons = group;
			} else if (group <= 12) {
				valenceElectrons = 2;
			} else {
				valenceElectrons = group - 10;
			}
		} else {
			throw new RuntimeException("Invalid atomic number.");
		}
	}

}
