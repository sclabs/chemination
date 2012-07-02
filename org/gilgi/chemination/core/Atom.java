package org.gilgi.chemination.core;

public class Atom {

	public final int atomicNumber;
	public final double electronegativity;
	public final double atomicRadius;
	public final int valenceElectrons;
	public final int group;
	public final int period;
	public final int maxHybridization;

	public Atom(int atomicNumber, double electronegativity,
			double atomicRadius, int valenceElectrons, int group, int period, int maxHybridization) {
		this.atomicNumber = atomicNumber;
		this.electronegativity = electronegativity;
		this.atomicRadius = atomicRadius;
		this.valenceElectrons = valenceElectrons;
		this.group = group;
		this.period = period;
		this.maxHybridization = maxHybridization;
	}

	public Atom(int atomicNumber, double electronegativity, double atomicRadius) {
		this.atomicNumber = atomicNumber;
		this.electronegativity = electronegativity;
		this.atomicRadius = atomicRadius;

		// calculate group and period
		if (atomicNumber <= 0)
			throw new RuntimeException("Invalid atomic number.");
		else if (atomicNumber <= 2) {
			period = 1;
			if (atomicNumber == 1)
				group = 1;
			else
				group = 18;
		} else if (atomicNumber <= 18) {
			if ((atomicNumber - 2) % 8 == 0)
				group = 18;
			else if ((atomicNumber - 2) % 8 <= 2)
				group = (atomicNumber - 2) % 8;
			else
				group = ((atomicNumber - 2) % 8) + 10;
			if (atomicNumber <= 10)
				period = 2;
			else
				period = 3;
		} else if (atomicNumber <= 54) {
			group = atomicNumber % 18;
			if (atomicNumber <= 36)
				period = 4;
			else
				period = 5;
		} else {
			throw new RuntimeException("Invalid atomic number.");
		}

		// calculate valence electrons
		if (group <= 2) {
			valenceElectrons = group;
		} else if (group <= 12) {
			valenceElectrons = 2;
		} else {
			valenceElectrons = group - 10;
		}
		
		// calculate maximum hybridization
		if (period == 1) maxHybridization = 1;
		else if (period == 2) maxHybridization = 4;
		else maxHybridization = 6;
	}

}
