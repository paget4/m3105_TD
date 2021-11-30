package fr.unilim.iut.tirepressuremonitoringsystem;

public class SafetyRange {

	final double lowPressureThreshold;
	final double highPressureThreshold;

	
	public SafetyRange(double lowPressureThreshold, double highPressureThreshold) {
		super();
		this.lowPressureThreshold = lowPressureThreshold;
		this.highPressureThreshold = highPressureThreshold;
	}


	public boolean doesNotContain(double psiPressureValue) {
		return psiPressureValue < this.lowPressureThreshold || this.highPressureThreshold < psiPressureValue;
	}

}
