package fr.unilim.iut.kataparrot;

public class NorvegianBlueParrot extends Parrot {
	
	private static final double MAXIMUM_SPEED = 24.0;
	private double voltage;
	private boolean isNailed;
	public NorvegianBlueParrot(double voltage) {
		super();
		this.voltage=voltage;
	}
	
	@Override
	public double getSpeed() {
		return (isNailed) ? MINIMUM_SPEED: getBaseSpeed();
	}
	
	public double getBaseSpeed() {
		return Math.min(MAXIMUM_SPEED, voltage * BASE_SPEED);
	}
}
