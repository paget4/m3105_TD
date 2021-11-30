package fr.unilim.iut.tirepressuremonitoringsystem.helper;

import fr.unilim.iut.tirepressuremonitoringsystem.Alarm;
import fr.unilim.iut.tirepressuremonitoringsystem.SafetyRange;
import fr.unilim.iut.tirepressuremonitoringsystem.Sensor;

public class AlarmBuilder {

	Sensor sensor;
	SafetyRange safetyRange;
	public AlarmBuilder withSensor(Sensor sensor) {
		this.sensor=sensor;
		return this;
	}
	public AlarmBuilder withSafetyRange(SafetyRange safetyRange) {
		this.safetyRange=safetyRange;
		return this;
	}
	public Alarm build() {
		return new Alarm(sensor, safetyRange);
	}
	
	public static AlarmBuilder anAlarm() {
		return new AlarmBuilder();
	}

}
